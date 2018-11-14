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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;


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
        final String sizeFilterMore = req.getParameter("sizeFilterMore");
        final String sizeFilterLess = req.getParameter("sizeFilterLess");

        try {
            imageFilter(req, sizeFilterMore, sizeFilterLess);
        } catch (SQLException e) {
            e.printStackTrace();
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
        image.setSize(Integer.parseInt(size));
        image.setAddingDate(Timestamp.valueOf(LocalDateTime.now()));
        image.setType(type);
        try {
            imageService.addImage(image);
            images = imageService.getAllImage();
            System.out.println(Arrays.toString(images.toArray()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/");
    }

    private void imageFilter(HttpServletRequest req, String sizeFilterMore, String sizeFilterLess) throws SQLException {
        if (sizeFilterMore != null && !sizeFilterMore.isEmpty() && images != null)
            images = imageService.getImageMoreFilter(images, Integer.parseInt(sizeFilterMore));
        else if (sizeFilterLess != null && !sizeFilterLess.isEmpty() && images != null)
            images = imageService.getImageLessFilter(images, Integer.parseInt(sizeFilterLess));
        else if (req.getParameter("IsortBy") != null)
            images = imageService.getAllImageOrderBy(req.getParameter("IsortBy"));
        else
            images = imageService.getAllImage();
    }


}
