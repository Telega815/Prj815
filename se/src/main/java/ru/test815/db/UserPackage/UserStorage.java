package ru.test815.db.UserPackage;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public interface UserStorage {

    // Маппер, превращающий строку из таблицы БД в объект класса Person
    RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> new User(resultSet.getInt("uid"), resultSet.getString("name"));

    List<User> findAll();

    User findOne(String username);

    User writeOne(String username);

    int delete(String username);
}
