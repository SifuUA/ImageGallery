package com.okres.imageGallery.Model;

import java.time.LocalDate;

public abstract class Image {
    private int size;
    private LocalDate addingdate;

    public Image(int size, LocalDate addingdate) {
        this.size = size;
        this.addingdate = addingdate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDate getAddingdate() {
        return addingdate;
    }

    public void setAddingdate(LocalDate addingdate) {
        this.addingdate = addingdate;
    }

    @Override
    public String toString() {
        return "Image{" +
                "size=" + size +
                ", addingdate=" + addingdate +
                '}';
    }
}
