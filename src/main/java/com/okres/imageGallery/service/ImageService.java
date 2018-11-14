package com.okres.imageGallery.service;

import com.okres.imageGallery.model.dao.VectorImageDao;
import com.okres.imageGallery.model.entity.BitMapImage;
import com.okres.imageGallery.model.entity.Image;
import com.okres.imageGallery.model.entity.ImageType;
import com.okres.imageGallery.model.entity.VectorImage;
import com.okres.imageGallery.model.jdbc.DbConnection;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ImageService extends DbConnection implements VectorImageDao {

    private final Connection connection = getConnection();

    private static final String ADD_IMAGE = "INSERT INTO images(type, size, date)" +
            "VALUES(?,?,?)";
    private static final String SELECT_ALL_IMAGE = "SELECT * FROM images";
    private static final String SELECT_BY_ID = "SELECT * FROM images WHERE id=?";
    private static final String SELECT_ALL_IMAGE_ORDERBY_TYPE = "SELECT * FROM images ORDER BY type";
    private static final String SELECT_ALL_IMAGE_ORDERBY_DATE = "SELECT * FROM images ORDER BY date";
    private static final String SELECT_ALL_IMAGE_ORDERBY_SIZE = "SELECT * FROM images ORDER BY size";


    @Override
    public void addImage(Image image) throws SQLException {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(ADD_IMAGE);

            preparedStatement.setString(1, image.getType());
            preparedStatement.setInt(2, image.getSize());
            preparedStatement.setTimestamp(3, image.getAddingDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Image> getAllImage() throws SQLException {

        List<Image> imageList = new CopyOnWriteArrayList<>();
        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_IMAGE);

            while (resultSet.next()) {
                Image image;

                image = getImage(resultSet);
                imageList.add(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    public Image getImageById(int id) throws SQLException {
        PreparedStatement preparedStatement;
        Image image = null;

        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                image = getImage(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    private Image getImage(ResultSet resultSet) throws SQLException {
        Image image;
        int id = resultSet.getInt("ID");
        String type = resultSet.getString("TYPE");
        int size = resultSet.getInt("SIZE");
        Timestamp date = resultSet.getTimestamp("date");

        if (type.equalsIgnoreCase(ImageType.BITMAP.toString())) {
            image = new BitMapImage();
        } else
            image = new VectorImage();
        image.setId(id);
        image.setType(type);
        image.setSize(size);
        image.setAddingDate(date);
        return image;
    }

    public List<Image> getAllImageOrderBy(String sortType) throws SQLException {
        List<Image> imageList = new CopyOnWriteArrayList<>();
        ResultSet resultSet;
        Image image;

        try {
            resultSet = getResultSet(sortType);
            while (resultSet.next()) {
                image = getImage(resultSet);
                imageList.add(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageList;
    }

    private ResultSet getResultSet(String sortType) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        if (sortType.equalsIgnoreCase("type"))
            preparedStatement = connection.prepareStatement(SELECT_ALL_IMAGE_ORDERBY_TYPE);
        else if (sortType.equalsIgnoreCase("size"))
            preparedStatement = connection.prepareStatement(SELECT_ALL_IMAGE_ORDERBY_SIZE);
        else
            preparedStatement = connection.prepareStatement(SELECT_ALL_IMAGE_ORDERBY_DATE);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public List<Image> getImageByListOfId(List<String> listOfrecivenImage) {
        List<Image> resList = new CopyOnWriteArrayList<>();

        for (String id : listOfrecivenImage) {
            try {
                resList.add(getImageById(Integer.parseInt(id)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resList;
    }

    public List<Image> getImageMoreFilter(List<Image> images, Integer sizeFilter) {
        return images.stream().filter(image -> image.getSize() > sizeFilter).
                collect(Collectors.toList());
    }

    public List<Image> getImageLessFilter(List<Image> images, int size) {
        return images.stream().filter(image -> image.getSize() < size)
                .collect(Collectors.toList());
    }
}