package com.example.demo.entity;

import com.example.demo.model.TimestampDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.sql.Timestamp;
public class User {
    private Integer userId;
    private String userName;

    public User() {
    }

    private String password;
    private String realName;
    private Integer sex;
    private String mail;
    private String telephone;
    private Integer integral;
    private String question;
    private String answer;
    private Integer authority;
    private Integer status;
    @JsonIgnore
    private Timestamp creationTime;
    @JsonIgnore
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", integral=" + integral +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", authority=" + authority +
                ", status=" + status +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public User(Integer userId, String userName, String password, String realName, Integer sex, String mail, String telephone, Integer integral, String question, String answer, Integer authority, Integer status, Timestamp creationTime, Timestamp updateTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.mail = mail;
        this.telephone = telephone;
        this.integral = integral;
        this.question = question;
        this.answer = answer;
        this.authority = authority;
        this.status = status;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
