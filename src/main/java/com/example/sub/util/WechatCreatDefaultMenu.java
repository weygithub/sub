package com.example.sub.util;

import com.example.sub.entity.Menu;

public class WechatCreatDefaultMenu {
    public static void main(String[] args){
		WechatCommonUtil wechatCommonUtil = new WechatCommonUtil();
		WechatMenuUtil wechatMenuUtil = new WechatMenuUtil();
		WechatMenuManagerUtil wechatMenuManagerUtil = new WechatMenuManagerUtil();
		String appid = "公众号的appid";
		String appsecret = "公众号的appsecret";
		
		//获取access_token
		String accessToken = wechatCommonUtil.getAccessToken(appid, appsecret).getAccess_token();
		//获取菜单结构
		Menu menu = wechatMenuManagerUtil.getMenu();
		if (accessToken!=null) {
			//生成菜单
			boolean result = wechatMenuUtil.creatMenu(menu, accessToken);
			if (result) {
				System.out.println("菜单创建成功");
			}else {
				System.out.println("菜单创建失败");
			}
		}else {
			System.out.println("token为空");
		}	
	}
}
