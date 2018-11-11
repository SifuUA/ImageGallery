package com.okres.imageGallery.controller;

import com.okres.imageGallery.model.entity.Image;
import com.okres.imageGallery.service.ImageUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ImageContextListener implements ServletContextListener {

    private Map<Integer, Image> images;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext = servletContextEvent.getServletContext();

        images = new ConcurrentHashMap<>();
        servletContext.setAttribute("images", images);
        final Image image = ImageUtils.createFirstImage(1, 22, LocalDateTime.now());
        this.images.put(image.getId(), image);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //images = null;
    }
}
