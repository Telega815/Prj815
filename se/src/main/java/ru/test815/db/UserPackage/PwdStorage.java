package ru.test815.db.UserPackage;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public interface PwdStorage {

    RowMapper<PwdData> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> new PwdData(resultSet.getInt("pid"), resultSet.getInt("owner_id"), resultSet.getString("salt"), resultSet.getString("pwd"));

    public PwdData getPwdData(int userID);

    public PwdData writePwd(int userID, String salt, String password);
}
