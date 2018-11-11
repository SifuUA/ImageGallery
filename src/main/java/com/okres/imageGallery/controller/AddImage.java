package com.okres.imageGallery.controller;

import com.okres.imageGallery.model.entity.BitMapImage;
import com.okres.imageGallery.model.entity.ImageType;
import com.okres.imageGallery.model.entity.VectorImage;
import com.okres.imageGallery.model.entity.Image;
import com.okres.imageGallery.service.ImageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@WebServlet(urlPatterns = "/")
public class AddImage extends HttpServlet {

    private static final String create = "/view/index.jsp";
    //private Map<Integer, Image> images;
    private ImageService images;

    private AtomicInteger id;

    @Override
    public void init() throws ServletException {
        //images = (Map<Integer, Image>) getServletContext().getAttribute("images");
        images = new ImageService();
        id = new AtomicInteger(2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(create).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       /* final String type = req.getParameter("type");
        final String size = req.getParameter("size");
        final int id = this.id.getAndIncrement();

        Image image = (type.equalsIgnoreCase(ImageType.VECTOR.toString())) ?
                new VectorImage() : new BitMapImage();

       // image.setId(id);
        image.setSize(Integer.parseInt(size));
        image.setAddingDate(LocalDateTime.now());
        image.setType(type);
        //images.put(id, image);
        try {
            images.addImage(image);        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/");*/
    }
}
