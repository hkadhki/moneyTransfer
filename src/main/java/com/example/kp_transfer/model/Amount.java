package com.example.kp_transfer.model;

public class Amount {
    private int value;
    private Currency currency;

    public Amount(int value, Currency currency){
        this.currency = currency;
        this.value = value;
    }
    public Amount(){}

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
