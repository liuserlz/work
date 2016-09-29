package com.controller;

import java.util.ArrayList;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.json.Json;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.model.Blog;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BlogController extends Controller {
	public void index(){
		
		Page<Blog> page=Blog.dao.paginate(1, 3, "select * ", "from blog");
		setAttr("list", page.getList());
		
		System.out.println(JsonKit.toJson(page.getList()).toString());
		render("/blog.html");
	}
	public void add(){
//		String title=this.getPara("title");
//		String content=this.getPara("content");
//		System.out.println(new Blog().set("title", title).set("content", content).save());
		Blog blog=this.getModel(Blog.class);
		blog.save();
		render("/blog.html");
	}
}
