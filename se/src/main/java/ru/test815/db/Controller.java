package ru.test815.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.test815.db.UserPackage.*;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;

public class Controller {
    private UserStorage userStorage;
    private FilesStorage filesStorage;
    private PwdStorage pwdStorage;
    private JdbcTemplate jdbcTemplate;
    private Settings settings;
    private static final Controller INSTANCE = new Controller();

    private Controller(){
        jdbcTemplate = new JdbcTemplateFactory().getJdbcTemplate();
        userStorage = new UserStorageImpl(jdbcTemplate);
        filesStorage = new FilesStorageImpl(jdbcTemplate);
        pwdStorage = new PwdStorageImpl(jdbcTemplate);
        settings = Settings.getInstance();
    }

    public static Controller getInstance() {
        return INSTANCE;
    }

    public void writeParts(User user, Collection<Part> parts) throws IOException{
        String file = null;
        for (Part part: parts) {
            file = part.getSubmittedFileName();
            if (file == null){
                file = "commentary.txt";
            }
            part.write(settings.getRepository("Frank") + file);
            filesStorage.saveFile(user.getId(), file);
        }
    }

    public boolean login(String login, String password){
        User user = userStorage.findOne(login);
        PwdData pwdData = pwdStorage.getPwdData(user.getId());
        return BCrypt.checkpw(password+pwdData.getSalt()+settings.value("Jdbc.s2"), pwdData.getPwd());
    }

    public void registration(String login, String password){
        User user = userStorage.writeOne(login);
        String salt = SaltGenerator.getSalt(15);
        pwdStorage.writePwd(user.getId(), salt, BCrypt.hashpw(password+salt+settings.value("Jdbc.s2"), BCrypt.gensalt()));
    }
}
