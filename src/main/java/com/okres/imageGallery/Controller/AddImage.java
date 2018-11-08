package com.okres.imageGallery.Controller;

import com.okres.imageGallery.Model.Entity.BitMapImage;
import com.okres.imageGallery.Model.Entity.VectorImage;
import com.okres.imageGallery.Model.Image;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AddImage extends HttpServlet {

    private static final String create = "/view/create.jsp";
    private Map<Integer, Image> images;
    private AtomicInteger id;

    @Override
    public void init() throws ServletException {
        images = (Map<Integer, Image>) getServletContext().getAttribute("images");
        id = new AtomicInteger(2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(create).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        final String type = req.getParameter("type");
        final String size = req.getParameter("size");
        final int id = this.id.getAndIncrement();

        Image image = (type.equalsIgnoreCase("vector")) ? new VectorImage() : new BitMapImage();

        image.setId(id);
        image.setSize(Integer.parseInt(size));
        image.setAddingdate(LocalDate.now());
        image.setType(type);
        images.put(id, image);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
