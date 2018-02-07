package ru.test815.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcStorage {
    private final Connection connection;

    public JdbcStorage(){
        final Settings settings = Settings.getInstance();
        try {
            Class.forName(settings.value("jdbc.driver_class"));    //загружаем драйвер
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public Collection<String> values(){
        final List<String> users = new ArrayList<String>();
        try (
            final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from users")) {
            while (rs.next()) {
                users.add(rs.getString("name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public int add(String name) {
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into users (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            try (ResultSet generateKeys = statement.getGeneratedKeys()) {
                if (generateKeys.next()) {
                    return generateKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Couldn't create new user");
    }

    public int getId(String name) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from users where name=(?)")) {
            statement.setString(1, name);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("uid");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Couldn't find user");
    }


    public void close(){
        // closing connection
        try{
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
