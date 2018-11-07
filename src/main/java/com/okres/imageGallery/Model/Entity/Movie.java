package com.okres.imageGallery.Model.Entity;

import com.okres.imageGallery.Model.Image;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private List<Image> imageList = new ArrayList<>();

    private static Movie ourInstance = new Movie();

    public static Movie getInstance() {
        return ourInstance;
    }

    private Movie() {
    }

    public void addImageToMovie(Image image) {
        this.imageList.add(image);
    }

    public void deleteImageFromMovie(Image image) {
        this.imageList.remove(image);
    }
}
