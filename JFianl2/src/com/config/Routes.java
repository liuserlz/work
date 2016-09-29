package com.config;

import com.controller.IndexController;

public class Routes extends com.jfinal.config.Routes {

	@Override
	public void config() {
		add("/",IndexController.class);

	}

}
