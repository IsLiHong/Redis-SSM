package com.lh.bean;


import java.io.Serializable;

/**
 * @version :1.0
 * CREATE TIME :2018/3/6 16:14
 * @authro :LH
 */

public class User implements Serializable {

    private Long id;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String name;
    private String gender;

}
