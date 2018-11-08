package com.okres.imageGallery.Service;

import com.okres.imageGallery.Model.Entity.VectorImage;
import com.okres.imageGallery.Model.Image;

import java.time.LocalDate;

public class ImageUtils {

    public static Image createFirstImage(final int id, final int size, final LocalDate date) {
        Image image = new VectorImage();

        image.setId(id);
        image.setSize(size);
        image.setAddingdate(date);
        return image;
    }
}
