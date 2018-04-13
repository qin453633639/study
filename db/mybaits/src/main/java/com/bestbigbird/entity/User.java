package com.bestbigbird.entity;

import java.io.Serializable;

/**
 * Created by qinwei on 2018/3/23.
 */
public class User  implements Serializable{
    private Integer age;
    private Integer id;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
