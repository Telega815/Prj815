package ru.test815.db.UserPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class PwdStorageImpl implements PwdStorage{

    private static final Logger LOGGER = LoggerFactory.getLogger(PwdStorage.class);

    private final JdbcTemplate jdbcTemplate;

    public PwdStorageImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PwdData getPwdData(int userID) {
        PwdData pwd = null;
        try {
            pwd = jdbcTemplate.queryForObject("select * from passwords where owner_id = ?", new Object[]{userID}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find pwd with id {}", userID);
        }
        return pwd;
    }

    @Override
    public PwdData writePwd(int userID, String salt, String password) {
        jdbcTemplate.update("INSERT INTO passwords(owner_id, salt, pwd) VALUES (?, ?, ?)", userID, salt, password);
        return getPwdData(userID);
    }

}
