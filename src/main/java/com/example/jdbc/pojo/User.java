package com.example.jdbc.pojo;

public class User {
    private int  id;
    private String  password;
    private String name;
    private String admin;
    private String picture;
    private String birthday;
    private String sex;
    private String education;
    private String identity;
    private String phone;
    private String mail;
    private String wordKey;

    public User() {}

    public User(int id, String password, String name, String admin, String picture, String birthday, String sex, String education, String identity, String phone, String mail, String wordKey) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.admin = admin;
        this.picture = picture;
        this.birthday = birthday;
        this.sex = sex;
        this.education = education;
        this.identity = identity;
        this.phone = phone;
        this.mail = mail;
        this.wordKey = wordKey;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWordKey() {
        return wordKey;
    }

    public void setWordKey(String wordKey) {
        this.wordKey = wordKey;
    }
}
