package com.okres.imageGallery.Model;

import java.time.LocalDate;

public abstract class Image {
    private int id;
    private int size;
    private LocalDate addingdate;
    private String type;

    public Image() {
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

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", size=" + size +
                ", addingdate=" + addingdate +
                ", type='" + type + '\'' +
                '}';
    }
}
