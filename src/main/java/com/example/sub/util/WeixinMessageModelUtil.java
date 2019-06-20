package com.example.sub.util;

import com.example.sub.entity.Article;
import com.example.sub.entity.NewsMessage;
import com.example.sub.entity.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class WeixinMessageModelUtil {

    @Autowired
	private WeixinMessageUtil weixinMessageUtil;
//	@Autowired
//	private WebConfigBean webConfigBean;
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private EncodeUTF8 encodeUT8;
	
	/**
	  * @Description: 当系统出错时，默认回复的文本消息
	  * @Parameters: WeixinMessageModelUtil
	  * @Return: 系统出错回复的消息
	  * @Create Date: 2017年10月23日上午11:55:17
	  * @Version: V1.00 
	  * @author:来日可期
	  */
	public String systemErrorResponseMessageModel(WeixinMessageInfo weixinMessageInfo ){
		
		// 回复文本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(weixinMessageInfo.getFromUserName());
		textMessage.setFromUserName(weixinMessageInfo.getToUserName());
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(weixinMessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		textMessage.setContent("系统出错啦，请稍后再试");	
		return weixinMessageUtil.textMessageToXml(textMessage);	
	}
	
	/**
	  * @Description: 用户关注时发送的图文消息
	  * @Parameters: WeixinMessageModelUtil
	  * @Return: 用户关注后发送的提示绑定用户的图文消息
	  * @Create Date: 2017年10月23日下午2:01:34
	  * @Version: V1.00 
	  * @author:来日可期
	  */
	public String followResponseMessageModel(WeixinMessageInfo weixinMessageInfo){
	
		// 关注时发送图文消息
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(weixinMessageInfo.getFromUserName());
		newsMessage.setFromUserName(weixinMessageInfo.getToUserName());
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(weixinMessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
	     
		// 图文消息
		List<Article> articleList=new ArrayList<Article>();
		Article article = new Article();
		// 设置图文消息的标题
		String string = "尊敬的用户，欢迎关注国家纤维局会议系统，点击查看会议。";
		article.setTitle(string);
		article.setPicUrl("meetingLogo2.png");
		article.setUrl("/WeixinParticipantFouce");
		articleList.add(article);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		return weixinMessageUtil.newsMessageToXml(newsMessage);
	}
	
	/**
	  * @Description: 用户取消关注，先判断用户是否绑定，如果已经绑定则解除绑定
	  * @Parameters: WeixinMessageModelUtil
	  * @Return: void
	  * @Create Date: 2017年11月20日上午10:54:26
	  * @Version: V1.00 
	  * @author:来日可期
	  */
//	public void cancelAttention(String fromUserName){
//
//		if (userService.isAlreadyBinding(fromUserName)) {
//			userService.userUnbinding(fromUserName);
//		}else {
//			System.out.println("取消关注用户{}"+fromUserName+"还未绑定");
//		}
//	}
}
