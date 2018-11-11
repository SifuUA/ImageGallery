package com.okres.imageGallery.service;

import com.okres.imageGallery.model.entity.VectorImage;
import com.okres.imageGallery.model.entity.Image;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ImageUtils {

    public static Image createFirstImage(final int id, final int size, final LocalDateTime date) {
        Image image = new VectorImage();

        image.setId(id);
        image.setSize(size);
        image.setAddingDate(date);
        return image;
    }

}
