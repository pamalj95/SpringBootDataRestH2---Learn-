package com.springbootjpah2.project.springbootjpah2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

    @Id
    private int aId;
    private String aName;
    public String tech;

    public String gettech() {
        return tech;
    }

    public void settech(String aTech) {
        this.tech = aTech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                '}';
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getaId() {
        return aId;
    }

    public String getaName() {
        return aName;
    }
}
