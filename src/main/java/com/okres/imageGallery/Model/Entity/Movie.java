package com.okres.imageGallery.Model.Entity;

import com.okres.imageGallery.Model.Image;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Movie {

    private Map<Integer, Image> imageList = new ConcurrentHashMap<>();

    private static Movie ourInstance = new Movie();

    public static Movie getInstance() {
        return ourInstance;
    }

    private Movie() {
    }

    public void addImageToMovie(int id, Image image) {
        this.imageList.put(id, image);
    }

    public void deleteImageFromMovie(Image image) {
        this.imageList.remove(image);
    }

    public Map<Integer, Image> getAllImage() {
        return this.imageList;
    }
}
