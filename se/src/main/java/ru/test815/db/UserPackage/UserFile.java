package ru.test815.db.UserPackage;

public class UserFile {

    private int fileID;

    private int ownerID;

    private String filename;

    public UserFile(int fileID, int ownerID, String filename){
        this.fileID = fileID;
        this.ownerID = ownerID;
        this.filename = filename;
    }

    public int getFileID() {
        return fileID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getFilename() {
        return filename;
    }
}
