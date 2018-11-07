package com.okres;

import com.okres.imageGallery.Model.Entity.BitMapImage;
import com.okres.imageGallery.Model.Entity.VectorImage;
import com.okres.imageGallery.Model.Image;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Image image = new BitMapImage(12, LocalDate.now());
        Image image1 = new VectorImage(99, LocalDate.now());

        System.out.println(image);
        System.out.println(image1);
    }
}
