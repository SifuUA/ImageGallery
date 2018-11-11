package com.okres.imageGallery.service;

import com.okres.imageGallery.model.dao.VectorImageDao;
import com.okres.imageGallery.model.entity.BitMapImage;
import com.okres.imageGallery.model.entity.Image;
import com.okres.imageGallery.model.entity.ImageType;
import com.okres.imageGallery.model.entity.VectorImage;
import com.okres.imageGallery.model.jdbc.DbConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ImageService extends DbConnection implements VectorImageDao {

    private final Connection connection = getConnection();

    private static final String ADD_IMAGE = "INSERT INTO IMAGES(TYPE, SIZE, DATE)" +
            "VALUES(?,?,?)";
    private static final String SELECT_ALL_IMAGE = "SELECT * FROM IMAGES";
    private static final String SELECT_BY_ID = "SELECT * FROM IMAGES WHERE ID=?";


    @Override
    public void addImage(Image image) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(ADD_IMAGE);

            preparedStatement.setString(1, image.getType());
            preparedStatement.setInt(2, image.getSize());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(image.getAddingDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
    }

    @Override
    public List<Image> getAllImage() throws SQLException {

        List<Image> imageList = new ArrayList<>();
        Statement statement = null;
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
        } finally {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        return imageList;
    }

    @Override
    public Image getImageById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Image image = null;

        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            image = getImage(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
        return image;
    }

    private Image getImage(ResultSet resultSet) throws SQLException {
        Image image;
        int id = resultSet.getInt("ID");
        String type = resultSet.getString("TYPE");
        int size = resultSet.getInt("SIZE");
        Date date = resultSet.getDate("date");

        if (type.equalsIgnoreCase(ImageType.BITMAP.toString())) {
            image = new BitMapImage();
        } else
            image = new VectorImage();
        image.setId(id);
        image.setType(type);
        image.setSize(size);
        image.setAddingDate(LocalDateTime.from(date.toLocalDate()));
        return image;
    }
}
