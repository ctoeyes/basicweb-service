package com.ctoeyes.basicwebservice.pojo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "basicweb", catalog = "")
public class AccountEntity {
    private Integer uid;
    private String accountName;
    private String status;
    private String mailbox;
    private String mobile;
    private Timestamp regtime;
    private String password;
    private Timestamp lastloginTime;
    private String lastloginIp;
    private String identifyCode;
    private String token;

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "mailbox")
    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "regtime")
    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "lastlogin_time")
    public Timestamp getLastloginTime() {
        return lastloginTime;
    }

    public void setLastloginTime(Timestamp lastloginTime) {
        this.lastloginTime = lastloginTime;
    }

    @Basic
    @Column(name = "lastlogin_ip")
    public String getLastloginIp() {
        return lastloginIp;
    }

    public void setLastloginIp(String lastloginIp) {
        this.lastloginIp = lastloginIp;
    }

    @Basic
    @Column(name = "identify_code")
    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return uid == that.uid &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(status, that.status) &&
                Objects.equals(mailbox, that.mailbox) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(regtime, that.regtime) &&
                Objects.equals(password, that.password) &&
                Objects.equals(lastloginTime, that.lastloginTime) &&
                Objects.equals(lastloginIp, that.lastloginIp) &&
                Objects.equals(identifyCode, that.identifyCode) &&
                Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, accountName, status, mailbox, mobile, regtime, password, lastloginTime, lastloginIp, identifyCode, token);
    }
}
