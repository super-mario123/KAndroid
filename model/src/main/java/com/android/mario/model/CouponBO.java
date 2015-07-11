package com.android.mario.model;

import java.io.Serializable;

/**
 * @version 1.0
 * Created by Administrator on 2015/7/10.
 */
public class CouponBO implements Serializable {

    private int id;               //卷id
    private String name;          //卷名称
    private String introduce;     //卷简介
    private int modelType;        //卷类型：1，现金卷 2，抵扣卷 3，折扣卷
    private double faceValue;     //现金卷面值
    private double estimateAmount;//现金卷的售价
    private double debitAmount;   //抵扣卷的抵扣金额
    private double discount;      //抵扣卷的折扣率
    private double miniAmount;    //抵扣卷和折扣卷的最小使用金额

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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public double getEstimateAmount() {
        return estimateAmount;
    }

    public void setEstimateAmount(double estimateAmount) {
        this.estimateAmount = estimateAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMiniAmount() {
        return miniAmount;
    }

    public void setMiniAmount(double miniAmount) {
        this.miniAmount = miniAmount;
    }
}
