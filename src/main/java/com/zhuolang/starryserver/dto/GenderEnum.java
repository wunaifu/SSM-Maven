package com.zhuolang.starryserver.dto;

public enum GenderEnum {

    WOMAN(0, "女"), MAN(1, "男");

    private int code;
    private String label;


    GenderEnum(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static String getGenderEnum(int code) {
        for(GenderEnum genderEnum : GenderEnum.values()) {
            if(genderEnum.getCode() == code) {
                return genderEnum.getLabel();
            }
        }
        return GenderEnum.MAN.getLabel();
    }
}
