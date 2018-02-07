package ru.test815.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.List;

public class SprStorage {
    final Settings settings = Settings.getInstance();
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public SprStorage(){
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUsername(settings.value("jdbc.username"));
        dataSource.setUrl(settings.value("jdbc.url"));
        dataSource.setPassword(settings.value("jdbc.password"));
    }

    public int getId(String name) {
        List<Integer> list = jdbcTemplate.query(
                "select * from users where name=?", new Object[] { name },
                (rs, rowNum) -> rs.getInt("uid"));
        return list.get(0);
    }

    public String[] getFilesNames(String name){
        int id = getId(name);
        List<String> list = jdbcTemplate.query(
                "select * from files where own_id=?", new Object[] { id },
                (rs, rowNum) -> rs.getString("fNames"));
        if (null != list.get(0)){
             return list.get(0).split("/");
        }
        return null;
    }

    public void writeFilesToDB(String user, String filename){
        int id = getId(user);
        jdbcTemplate.update(
                "UPDATE files SET fNames =\'"+getFilesNames(user)+filename+"\'/ WHERE own_id = \'"+ id +"\' IF EXISTS "
        )
    }
}
