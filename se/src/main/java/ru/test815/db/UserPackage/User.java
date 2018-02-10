package ru.test815.db.UserPackage;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int userID;

    private String name;

    private ArrayList<FileUser> userFiles;

    public User(int id, String name){
        this.userID = id;
        this.name = name;
    }


    //----------------------------------------------------------------------------------------
    /**
     * getters and setters for fields
     */
    public int getId() {
        return userID;
    }

    public void setId(int id) {
        this.userID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileUser> getFiles(){
        return userFiles;
    }
    //----------------------------------------------------------------------------------------

    public void addFile(FileUser userFile){
        this.userFiles.add(userFile);
    }


}
