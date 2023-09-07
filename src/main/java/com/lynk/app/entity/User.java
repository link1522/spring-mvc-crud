package com.lynk.app.entity;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String address;
    private String phone;

    public User() {
    }

    public User(Integer id, String name, String password, String address, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User {\n  id = " + id + ",\n  name = " + name + ",\n  password = " + password + ",\n  address = "
                + address + ",\n  phone = " + phone + "\n}";
    }
}
