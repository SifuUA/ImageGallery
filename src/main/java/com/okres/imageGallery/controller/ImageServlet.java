package com.okres.imageGallery.controller;

import com.okres.imageGallery.model.entity.Image;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ImageServlet extends HttpServlet {

    private Map<Integer, Image> images;

    private static final String index = "/view/index.jsp";

    @Override
    public void init() throws ServletException {
        final Object images = getServletContext().getAttribute("images");

        this.images = (ConcurrentHashMap<Integer, Image>) images;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("images", images.values());
        req.getRequestDispatcher(index).forward(req, resp);

    }
}
