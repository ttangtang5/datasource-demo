package com.tang.pojo;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-04 21:13
 * @Version 1.0
 **/
@Entity(name = "t_user")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
