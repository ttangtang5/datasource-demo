package com.tang.multidatasource.pojo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 17:26
 * @Version 1.0
 **/
@Entity(name = "t_user")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int age;
}
