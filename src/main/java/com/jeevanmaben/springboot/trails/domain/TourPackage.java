package com.jeevanmaben.springboot.trails.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TourPackage {
    @Id
    private String code;

    @Column
    private String name;

    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }

    protected TourPackage(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
