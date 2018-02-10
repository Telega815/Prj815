package ru.test815.db.UserPackage;

public class PwdData {

    private String salt;
    private String pwd;
    private int owner_id;
    private int pwdID;

    public PwdData(int pwdID, int owner_id, String salt, String pwd) {
        this.salt = salt;
        this.pwd = pwd;
        this.owner_id = owner_id;
        this.pwdID = pwdID;
    }


    public String getSalt() {
        return salt;
    }

    public String getPwd() {
        return pwd;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public int getPwdID() {
        return pwdID;
    }
}
