package com.puzan.springhandson.dto;

public class DocSettingDto {

    private Long id;
    private String label;
    private int docNos;
    private String setting;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getDocNos() {
        return docNos;
    }

    public void setDocNos(int docNos) {
        this.docNos = docNos;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
