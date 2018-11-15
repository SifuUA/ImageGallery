package com.okres.imageGallery.model.entity;

import java.sql.Timestamp;

public abstract class Image {
    private int id;
    private int size;
    private Timestamp addingDate;
    private String type;

    public Image() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Timestamp getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Timestamp addingDate) {
        this.addingDate = addingDate;
    }

    public String getType() {
        return this.type;// this.getClass().getSimpleName();
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
                ", addingDate=" + addingDate +
                ", type='" + type + '\'' +
                '}';
    }
}
