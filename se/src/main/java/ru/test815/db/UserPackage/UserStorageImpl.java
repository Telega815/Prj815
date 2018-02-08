package ru.test815.db.UserPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserStorageImpl implements UserStorage {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserStorage.class);

    private final JdbcTemplate jdbcTemplate;

    public UserStorageImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", ROW_MAPPER);
    }

    @Override
    public User findOne(String username) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("select * from users where name = ?", new Object[]{username}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Person with id {}", username);
        }

        return user;
    }

    @Override
    public int delete(String username) {
        return jdbcTemplate.update("delete from users where name = ?", username);
    }
}
