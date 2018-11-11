package com.okres.imageGallery.model.dao;

import com.okres.imageGallery.model.entity.Image;

import java.sql.SQLException;
import java.util.List;

public interface VectorImageDao {

    void addImage(Image image) throws SQLException;

    List<Image> getAllImage() throws SQLException;

    Image getImageById(int id) throws SQLException;
}
