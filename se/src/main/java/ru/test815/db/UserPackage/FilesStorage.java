package ru.test815.db.UserPackage;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public interface FilesStorage {
    // Маппер, превращающий строку из таблицы БД в объект класса Person
    RowMapper<UserFile> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> new UserFile(resultSet.getInt("uid"), resultSet.getInt("onwer_id"), resultSet.getString("name"));

    UserFile findOne(int userID);

    UserFile findOne(String filename);

    int delete(String filename);

    int delete(int usrID);

    void saveFile(int userID, String filename);

    void saveFiles(int userID, String[] files);
}
