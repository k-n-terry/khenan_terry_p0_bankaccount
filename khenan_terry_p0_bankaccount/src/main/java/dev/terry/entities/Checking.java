package dev.terry.entities;

public class Checking {
    private String sharedId;
    private double checkingBalance;

    // no args constructor
    public Checking(){
    }

    // constructor
    public Checking(String sharedId, double checkingBalance){
        this.sharedId = sharedId;
        this.checkingBalance = checkingBalance;
    }

    // getter
    public String getSharedId(){
        return this.sharedId;
    }
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    // setter
    public void setSharedId(String sharedId){
        this.sharedId = sharedId;
    }
    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }
}
