package dev.terry.entities;

public class Savings {
    private String sharedId;
    private double savingsBalance;

    // no args constructor
    public Savings(){
    }

    // constructor
    public Savings(String sharedId, double savingsBalance){
        this.sharedId = sharedId;
        this.savingsBalance = savingsBalance;
    }

    // getter
    public String getSharedId(){
        return this.sharedId;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    // setter
    public void setSharedId(String sharedId){
        this.sharedId = sharedId;
    }
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
}
