package com.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.model.Blog;
import com.model.User;

public class IndexController extends Controller {
	public void index(){
	    
		render("/login.html");
		
	}
	public void login(){
	    String uname=getPara("uname");
	    String pwd=getPara("pwd");
	    User u=User.dao.findFirst("select * from tb_user where uname="+uname+" and pwd="+pwd);
	    System.out.println(u.getStr("name"));
	    System.out.println(uname+pwd);
	    render("/index.html");
	}
}
