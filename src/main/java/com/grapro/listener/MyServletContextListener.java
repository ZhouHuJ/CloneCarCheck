package com.grapro.listener;

import com.grapro.javacvcamera.JavaCVCamera;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new Thread(new JavaCVCamera()).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
