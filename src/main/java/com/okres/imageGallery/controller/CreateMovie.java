package com.okres.imageGallery.controller;

import com.okres.imageGallery.model.entity.Image;
import com.okres.imageGallery.service.ImageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/create")
public class CreateMovie extends HttpServlet {
    private static final String create = "/view/create.jsp";
    private List<String> listOfrecivenImage = new ArrayList<>();
    private ImageService imageService = new ImageService();
    private List<Image> selectedImages;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listOfrecivenImage = Arrays.asList(req.getParameterValues("choosedImage"));
        selectedImages = imageService.getImageByListOfId(listOfrecivenImage);
        req.setAttribute("selectedImages", selectedImages);
        req.getRequestDispatcher(create).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}