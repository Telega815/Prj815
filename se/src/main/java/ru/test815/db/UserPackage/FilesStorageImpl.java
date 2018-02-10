package ru.test815.db.UserPackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FilesStorageImpl implements FilesStorage{

    private static final Logger LOGGER = LoggerFactory.getLogger(FilesStorage.class);

    private final JdbcTemplate jdbcTemplate;

    public FilesStorageImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FileUser findOne(int userID) {
        FileUser file = null;
        try {
            file = jdbcTemplate.queryForObject("select * from files where owner_id = ?", new Object[]{userID}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find file with id {}", userID);
        }

        return file;
    }

    @Override
    public FileUser findOne(String filename) {
        FileUser file = null;
        try {
            file = jdbcTemplate.queryForObject("select * from files where filename = ?", new Object[]{filename}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find file with name {}", filename);
        }

        return file;
    }

    public List<FileUser> FindAll(int userID){
        List<FileUser> files = null;
        try{
            files = jdbcTemplate.query("select * from files where owner_id = (?)", new Object[]{userID}, ROW_MAPPER);
        }catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find file with id {}", userID);
        }
        return files;
    }

    @Override
    public int delete(String filename) {
        return jdbcTemplate.update("delete from files where filename = ?", filename);
    }

    @Override
    public int delete(int userID) {
        return jdbcTemplate.update("delete from files where owner_id = ?", userID);
    }

    @Override
    public void saveFile(int userID, String filename) {
        jdbcTemplate.update("INSERT INTO files(owner_id, filename) VALUES(?,?)", userID, filename);
    }

    @Override
    public void saveFiles(int userID, String[] files){
        for (String file: files) {
            saveFile(userID, file);
        }
    }

}
