package edu.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dt")
    private java.sql.Date paymentDate;
    private Integer merchantId;
    private Integer customerId;
    private String goods;
    @Column(name = "chargePaid")
    private Double chargePaid;
    @Column(name = "sumPaid")
    private Double sum;


    Payment() {  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Double getChargePaid() {
        return chargePaid;
    }

    public void setChargePaid(Double chargePaid) {
        this.chargePaid = chargePaid;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", merchantId=" + merchantId +
                ", customerId=" + customerId +
                ", goods='" + goods + '\'' +
                ", chargePaid=" + chargePaid +
                ", sum=" + sum +
                '}';
    }
}