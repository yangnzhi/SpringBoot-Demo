package com.youngnzhi.springboot.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private String id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    private Date createDate;

    private String type;
}