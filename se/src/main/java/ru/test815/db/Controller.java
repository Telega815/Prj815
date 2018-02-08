package ru.test815.db;

import ru.test815.db.UserPackage.*;

public class Controller {
    private static UserStorage userStorage = new UserStorageImpl(new JdbcTemplateFactory().getJdbcTemplate());
    private static FilesStorage filesStorage = new FilesStorageImpl(new JdbcTemplateFactory().getJdbcTemplate());

    public static void writeFile(User user, String file){
        filesStorage.saveFile(user.getId(), file);
    }
}
