package com.itheima.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    // 省略构造函数、getter和setter
}
