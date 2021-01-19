package com.puzan.springhandson.model;

public enum Setting {
    SPORT("S"), MUSIC("M"), TECHNOLOGY("T");

    private String code;

    private Setting(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}