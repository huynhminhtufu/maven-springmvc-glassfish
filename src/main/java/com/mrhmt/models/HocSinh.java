package com.mrhmt.models;

public class HocSinh {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HocSinh() {
    }

    public HocSinh(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public HocSinh(String name) {
        this.name = name;
    }
}
