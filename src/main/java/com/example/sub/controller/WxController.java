package com.example.sub.controller;

import com.example.sub.service.WeixinCoreService;
import com.example.sub.util.WeiXinSignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/wx")
public class WxController {

    private static final Logger logger = LoggerFactory.getLogger(WxController.class);
    @Autowired
    private WeiXinSignUtil weixinSignUtil;
//    @Autowired
//    private DataProcess dataProcess;
    @Autowired
    private WeixinCoreService weixinCoreService;

    @RequestMapping("/index")
    public String index(){
        return "test..";
    }

    @RequestMapping(value="/access", method= RequestMethod.POST)
    public String getWeiXinMessage(HttpServletRequest request, HttpServletResponse response)throws Exception{
        logger.info("----------------开始处理微信发过来的消息------------------");
        // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        request.setCharacterEncoding("UTF-8");
        // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        response.setCharacterEncoding("UTF-8");

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        logger.info("signature is :"+signature+"timestamp is"+timestamp+"nonce is :"+nonce);
        if (weixinSignUtil.checkSignature(signature, timestamp, nonce)){
            System.out.println("-----------验证微信服务号结束------------");
            String respXml = weixinCoreService.weixinMessageHandelCoreService(request, response);
            return respXml;
        }else {
            // 此处可以实现其他逻辑
            logger.warn("不是微信服务器发过来的请求，请小心！");
            return null;
        }

    }


}
