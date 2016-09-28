package com.config;

import com.controller.BlogController;
import com.controller.IndexController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.model.Blog;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		PropKit.use("a_little_config.txt");
		me.setDevMode(true);
		me.setBaseUploadPath("/Upload");
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/",IndexController.class);
		me.add("/blog",BlogController.class);

	}
	
	public static C3p0Plugin createC3p(){
		return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
	}
	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin c3p=createC3p();
		me.add(c3p);
		ActiveRecordPlugin arp=new ActiveRecordPlugin(c3p);
		me.add(arp);
		arp.addMapping("blog", Blog.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new com.intercepter.Intercepter());
		
	}

	@Override
	public void configHandler(Handlers me) {
		//me.add(new ContextPathHandler("basePath"));
		me.add(new ContextPathHandler("basePath"));

	}
	
	public void  afterJFinalStart(){
		System.out.println(" afterJFinalStart()");
	}
	
	public void  beforeJFinalStart(){
		System.out.println(" beforeJFinalStart()");
	}
	
}
