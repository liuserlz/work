package com.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.JFinal;
import com.jfinal.json.Json;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

public class MyController extends Controller {
	public void index() {

		render("/index.html");
	}

	public void upload() {
		System.out.println(PathKit.getWebRootPath() + "/upload");
		List<UploadFile> list = this.getFiles();
		getAllFile();
		render("/success.html");

	}

	public void success() {
		getAllFile();
		render("/success.html");
	}

	public void getAllFile() {
		File file = new File(PathKit.getWebRootPath() + "\\upload");
		List<String> list=new ArrayList<String>();
		Map<String, String> map=new HashMap<String,String>();
		if (file.isDirectory()) {
			for (String fileName : file.list()) {
				
				map.put(fileName, PathKit.getWebRootPath() + "\\upload\\"+fileName);
				list.add(PathKit.getWebRootPath() + "\\upload\\"+fileName);
			}
		}
		setAttr("fileList", map);
	}
}
