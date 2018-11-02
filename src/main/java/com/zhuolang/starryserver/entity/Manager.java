package com.zhuolang.starryserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhuolang.starryserver.util.DateUtils;
import com.zhuolang.starryserver.util.ExcelField;

import java.util.Date;

public class Manager {

    private String idCode;

    private String address;

    private String userName;

    private String nickName;

    private String age;

    private Date birth;

    @ExcelField(title="ID", align=2, sort=1)
    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    @ExcelField(title="地址", align=2, sort=2)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ExcelField(title="姓名", align=2, sort=3)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ExcelField(title="昵称", align=2, sort=4)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @ExcelField(title="年龄", align=2, sort=5)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @JsonFormat(pattern = "mm/dd/YYYY")
    @ExcelField(title="生日", align=2, sort=6)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "idCode='" + idCode + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age='" + age + '\'' +
                ", birth=" + DateUtils.formatDate(birth,"yyyy-MM-dd") +
                '}';
    }
}
