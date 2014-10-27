package com.springapp.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by MCB on 10/18/2014.
 */
//public class WebInitializer extends WebMvcConfigurerAdapter implements WebApplicationInitializer {
//
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(Config.class);
//        ctx.setServletContext(servletContext);
//
//        Dynamic dispatcherServlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//        dispatcherServlet.addMapping("/");
//        //dispatcherServlet.addMapping("/games");
//        dispatcherServlet.setLoadOnStartup(1);
//    }
//}

