package com.jssmx.manage.pojo.basic;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select replace(UUID(),'-','')")
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
