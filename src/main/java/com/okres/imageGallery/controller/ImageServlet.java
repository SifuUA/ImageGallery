package com.okres.imageGallery.controller;

import com.okres.imageGallery.model.entity.BitMapImage;
import com.okres.imageGallery.model.entity.Image;
import com.okres.imageGallery.model.entity.ImageType;
import com.okres.imageGallery.model.entity.VectorImage;
import com.okres.imageGallery.service.ImageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(urlPatterns = "/")
public class ImageServlet extends HttpServlet {

    private List<Image> images;
    private ImageService imageService = new ImageService();
    private static final String index = "/view/index.jsp";

    @Override
    public void init() throws ServletException {
        try {
            this.images = imageService.getAllImage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("IsortBy") != null) {
            try {
                images = imageService.getAllImageOrderBy(req.getParameter("IsortBy"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("images", images);
        req.getRequestDispatcher(index).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String type = req.getParameter("type");
        final String size = req.getParameter("size");

        Image image = (type.equalsIgnoreCase(ImageType.VECTOR.toString())) ?
                new VectorImage() : new BitMapImage();

        // image.setId(id);
        image.setSize(Integer.parseInt(size));
        image.setAddingDate(LocalDateTime.now());
        image.setType(type);
        //images.put(id, image);
        try {
            imageService.addImage(image);
            images = imageService.getAllImage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/");
    }
}
