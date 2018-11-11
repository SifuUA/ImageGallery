package com.okres.imageGallery.controller;

import com.okres.imageGallery.model.entity.Image;
import com.okres.imageGallery.service.ImageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ImageServlet extends HttpServlet {

    //private Map<Integer, Image> images;
    private List<Image> images;
    private ImageService imageService = new ImageService();

    private static final String index = "/view/index.jsp";

    @Override
    public void init() throws ServletException {
        final Object images = getServletContext().getAttribute("images");
        try {
            this.images = imageService.getAllImage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //this.images = (ConcurrentHashMap<Integer, Image>) images;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("images", images);
        req.getRequestDispatcher(index).forward(req, resp);

    }
}
