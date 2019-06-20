package com.example.sub.util;

import com.example.sub.entity.Button;
import com.example.sub.entity.ClickButton;
import com.example.sub.entity.Menu;
import com.example.sub.entity.ViewButton;

public class WechatMenuManagerUtil {
    /**
	 * @Description: 定义菜单结构
	 * @Parameters: 
	 * @Return: 
	 * @Create Date: 2018年9月28日下午5:36:08
	 * @Version: V1.00
	 * @author:
	 */
	public Menu getMenu(){
		ClickButton firstClickButton = new ClickButton();
		firstClickButton.setName("功能图文");
		firstClickButton.setKey("function");
		firstClickButton.setType("click");
		
		ViewButton firstViewButton = new ViewButton();
		firstViewButton.setName("联系我们");
		firstViewButton.setType("view");
		firstViewButton.setUrl("");
		
		Menu menu = new Menu();
		Button[] boButtons = {firstClickButton,firstViewButton};
		menu.setButton(boButtons);
		
		return menu;
	}
}
