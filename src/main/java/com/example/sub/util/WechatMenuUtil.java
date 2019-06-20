package com.example.sub.util;

import com.example.sub.entity.Menu;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatMenuUtil {
    Logger logger = LoggerFactory.getLogger(WechatMenuUtil.class);
	 @Autowired
	 private HttpRequestUtil httpRequestUtil;
 
	 /**
	 * @Parameters: menu 菜单实例
	 * 				accessToken 凭证
	 * @Return: true false
	 * @Return: 
	 * @Create Date: 2018年9月22日上午7:45:53
	 * @Version: V1.00
	 * @author:
	 */
	public boolean creatMenu(Menu menu, String accessToken){
		boolean result = false;
		String url = WechatConstants.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		//将菜单对象转换成JSON字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		//发起POST请求创建菜单
		JSONObject jsonObject = httpRequestUtil.httpsRequest(url, "POST", jsonMenu);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0== errorCode) {
				result = true;
			} else {
				result = false;
				logger.error("创建菜单失败 errcode：{} errmsg：{} ",errorCode,errorMsg);	
			}
		}
		return result;
	 }
	/**
	 * 
	 * @Description: 查询菜单
	 * @Parameters: 
	 * @Return: 
	 * @Create Date: 2018年3月13日下午2:24:02
	 * @Version: V1.00
	 * @author:
	 */
	public String getMenu(String accessToken){
		String result = null;
		String requestUrl = WechatConstants.MENU_GET_URL.replace("ACCESS_TOKEN", accessToken);
		//发起GET请求查询菜单
		JSONObject jsonObject = httpRequestUtil.httpsRequest(requestUrl, "GET", null);
		
		if (null != jsonObject) {
			result = jsonObject.toString();
		}
		return result;
	}
	/**
	 * 
	 * @Description: 删除菜单
	 * @Parameters: 
	 * @Return: 
	 * @Create Date: 2018年3月13日下午2:31:15
	 * @Version: V1.00
	 * @author:
	 */
	public boolean deleteMenu(String accessToken){
		boolean result = false;
		String requestUrl = WechatConstants.MENU_DELETE_URL.replace("ACCESS_TOKEN", accessToken);
		//发起GET请求删除菜单
		JSONObject jsonObject = httpRequestUtil.httpsRequest(requestUrl, "GET", null);
		
		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0== errorCode) {
				result = true;
			} else {
				result = false;
				logger.error("创建菜单失败 errcode：{} errmsg：{} ",errorCode,errorMsg);	
			}
		}
		return result;
	}
}
