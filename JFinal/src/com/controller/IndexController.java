package com.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.model.Blog;

public class IndexController extends Controller {
	public void index(){
		render("/index.html");
		
	}
	public void upload(){
		System.out.println("uploadfile");
		UploadFile file=getFile(getPara("file"));
		render("/index.html");
	}
}
