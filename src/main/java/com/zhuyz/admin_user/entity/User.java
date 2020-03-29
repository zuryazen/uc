package com.zhuyz.admin_user.entity;

public class User {

    private int id;
    private String name;
    private String password;
    private String address;
    private String email;
    // 是否启用  0:否   1:是
    private int isSwitch;

    public User() {
    }


    public User(int id, String name, String password, String address, String email, int isSwitch) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.isSwitch = isSwitch;
    }

    public int getId() {
        return id;
    }

    public int getIsSwitch() {
        return isSwitch;
    }

    public void setIsSwitch(int isSwitch) {
        this.isSwitch = isSwitch;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
