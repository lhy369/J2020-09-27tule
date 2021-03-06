package com.qianfeng.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    private int id;
    private String name;
    private String gender;
    private long birthday;
    private String birthplace;
    private String mobile;
    private String email;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", birthplace='" + birthplace + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}'+'\n';
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact() {
    }

    public Contact(int id, String name, String gender, long birthday, String birthplace, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.mobile = mobile;
        this.email = email;
    }
    public int getAge(){
        long currentTime = System.currentTimeMillis();
        long a = (currentTime-birthday) / 1000 / 60 / 60 / 24 / 365;
        return (int) a;

    }
    public String getFormatBirthday(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(birthday);
    }
    public void setFormatBirthday(String formatBirthday){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(formatBirthday);
            birthday = parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

