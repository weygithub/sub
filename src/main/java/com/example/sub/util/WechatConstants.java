package com.example.sub.util;

import org.springframework.stereotype.Component;

@Component
public class WechatConstants {
    /**
	 * 微信接入token，自定义但是一定要与公众平台上的保持一致
	 */
	public static final String TOKEN = "weixin";
 
	public static final String APPID="wx4c6b4d1782fefb36";  
	
	public static final String  APPSECRET="6a3c2d92df4fe8dad40afb62585ef4b7";
	/**
     * EncodingAESKey 公众平台上面自己填写的43位EncodingAESKey(服务号的)
     */
	//public static final String EncodingAESKey = "bcW2S8ZsB19kbCTMmHtKi82ZYyNQmA5MRTFWwEj8Gwv";
	public static final String EncodingAESKey = "SCNajXZhXHcGNt8tiGbLHb5LVlXjk8iWDXxLrRhlylu";
	/**
	 *  获取access_token的接口地址（GET） 限200（次/天）
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * 获取JS_SDK_TICKET
	 */
	public static final String JS_SDK_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	/**
	 * 获取网页授权的access_token的接口地址
	 */
	public static final String  OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
 
	/**
	 * 自定义菜单删除接口
	 */
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
 
	/**
	 * 自定义菜单的创建接口
	 */
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	/**
	 * 自定义菜单的查询接口
	 */
	public static final String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN"; 
	/**
	 *  客服接口-发消息接口
	 */
	public static final String CUSTOM_SERVICE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	/**
	 * 发送模板消息接口
	 */
    public static final String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    
    /**
	 * 创建标签接口
	 * @Method :POST
	 */
	public static final String USE_TAG_CREATE_URL  = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 获取用户身上的标签
	 * @Method:POST
	 */
	public static final String GET_INUSER_TAG_URL  = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";
	
	/**
	 * 批量为用户取消标签
	 * @Method:POST
	 */
	public static final String UNTAGGING_USER_BATCH_URL  = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN";
	
	/**
	 * 创建个性化菜单
	 * @Method :POST
	 */
	public static final String CREATE_PERSONALIZED_MENU_URL  = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
	
	/**
	 * 删除个性化菜单
	 * @Method:
	 */
	public static final String DELETE_PERSONAL_MENU_URL  = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
	
	/**
	 * 给用户打标签的姐接口
	 */
	public static final String CREATE_USERTAG_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
	
	/**
	 * 网页授权获取用户详细信息的的接口
	 */
	public static final String GET_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
 
	/**
	 * openid获取用户的基本信息的接口
	 */
	public static final String OPENID_USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
 
 
}
