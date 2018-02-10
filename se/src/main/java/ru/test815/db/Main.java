package ru.test815.db;


import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.test815.db.UserPackage.PwdStorage;
import ru.test815.db.UserPackage.PwdStorageImpl;
import ru.test815.db.UserPackage.UserStorage;
import ru.test815.db.UserPackage.UserStorageImpl;

import java.io.File;

public class Main {
    public static void main(String[] args){

        //JdbcStorage storage = new JdbcStorage();
        /*
        storage.add("Frank");
        storage.add("Mike");
        storage.add("Lisa");
        */
//        String salt = BCrypt.gensalt();
//        Settings settings = Settings.getInstance();
//        System.out.println(salt);//+settings.value("Jdbc.s2")
//
        System.out.println(new SaltGenerator().getSalt(20));
        System.out.println(new SaltGenerator().getSalt(20));
        System.out.println(new SaltGenerator().getSalt(10));
        System.out.println(new SaltGenerator().getSalt(10));

        System.out.println(new PwdStorageImpl(new JdbcTemplateFactory().getJdbcTemplate()).getPwdData(1).getSalt());

//        System.out.println(BCrypt.hashpw("123456", salt));
//        System.out.println(Controller.getInstance().login("Frank", "123456"));
//        for (String str: storage.values()) {
//        }
         //new File(settings.getRepository("Frank")).mkdirs();
        //storage.close();
    }

    public static int getId(String name){
        UserStorage storage = new UserStorageImpl(new JdbcTemplateFactory().getJdbcTemplate());
        return storage.findOne(name).getId();
    }

    public static void write(String str){
        JdbcStorage storage = new JdbcStorage();
        if (str != null)
            storage.add(str);
        storage.close();
    }


}
