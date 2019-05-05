package edu.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity(name="merchant")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String bankName;
    private String swift;
    private String account;
    private Double charge;
    private Integer period;
    private Double minSum;
    private Double needToSend;
    private Double sent;
    private java.sql.Date lastSent;

    public Merchant() { }

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getMinSum() {
        return minSum;
    }

    public void setMinSum(Double minSum) {
        this.minSum = minSum;
    }

    public Double getNeedToSend() {
        return needToSend;
    }

    public void setNeedToSend(Double needToSend) {
        this.needToSend = needToSend;
    }

    public Double getSent() {
        return sent;
    }

    public void setSent(Double sent) {
        this.sent = sent;
    }

    public Date getLastSent() {
        return lastSent;
    }

    public void setLastSent(Date lastSent) {
        this.lastSent = lastSent;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", swift='" + swift + '\'' +
                ", account='" + account + '\'' +
                ", charge=" + charge +
                ", period=" + period +
                ", minSum=" + minSum +
                ", needToSend=" + needToSend +
                ", sent=" + sent +
                ", lastSent=" + lastSent +
                '}';
    }
}
