package ru.test815.db;


import java.io.File;

public class Main {
    public Main(){}
    public static void main(String[] args){

        //JdbcStorage storage = new JdbcStorage();
        /*
        storage.add("Frank");
        storage.add("Mike");
        storage.add("Lisa");
        */
        Settings settings = Settings.getInstance();
        System.out.println(getId("Frank"));
//        for (String str: storage.values()) {
//            System.out.println(str);
//        }
         new File(settings.getRepository("Frank")).mkdirs();
        //storage.close();
    }

    public static int getId(String name){
        SprStorage storage = new SprStorage();
        int resp = storage.getId(name);
        return resp;
    }

    public static void write(String str){
        JdbcStorage storage = new JdbcStorage();
        if (str != null)
            storage.add(str);
        storage.close();
    }


}
