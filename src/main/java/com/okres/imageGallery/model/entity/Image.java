package com.okres.imageGallery.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Image {
    private int id;
    private int size;
    private LocalDateTime addingDate;
    private String type;

    public Image() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(LocalDateTime addingDate) {
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
