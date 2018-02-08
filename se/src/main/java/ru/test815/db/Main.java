package ru.test815.db;


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
        System.out.println(getId("Frank"));
//        for (String str: storage.values()) {
//            System.out.println(str);
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
