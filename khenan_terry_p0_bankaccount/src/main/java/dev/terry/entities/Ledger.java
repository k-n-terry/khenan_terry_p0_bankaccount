package dev.terry.entities;

public class Ledger{
    // fields
    private int transactionId;
    private String transactionDate;
    private String transactionAccount;
    private String sharedId;
    private double foreBalance;
    private double aftBalance;
    private double diffBalance;

    // no args constructor
    public Ledger(){
    }

    // constructor
    public Ledger(int transactionId, String transactionDate, String transactionAccount, String sharedId, double foreBalance, double aftBalance, double diffBalance){
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.transactionAccount = transactionAccount;
        this.sharedId = sharedId;
        this.foreBalance = foreBalance;
        this.aftBalance = aftBalance;
        this.diffBalance = diffBalance;
    }

    // getter
    public int getTransactionId(){
        return this.transactionId;
    }
    public String getTransactionDate(){
        return this.transactionDate;
    }
    public String getTransactionAccount(){
        return this.transactionAccount;
    }
    public String getSharedId(){
        return this.sharedId;
    }
    public double getForeBalance(){
        return this.foreBalance;
    }
    public double getAftBalance(){
        return this.aftBalance;
    }
    public double getDiffBalance(){
        return this.diffBalance;
    }

    // setter
    public void setTransactionId(int transactionId){
        this.transactionId = transactionId;
    }
    public void setTransactionDate(String transactionDate){
        this.transactionDate = transactionDate;
    }
    public void setTransactionAccount(String transactionAccount){
        this.transactionAccount = transactionAccount;
    }
    public void setSharedId(String sharedId){
        this.sharedId = sharedId;
    }
    public void setForeBalance(double foreBalance){
        this.foreBalance = foreBalance;
    }
    public void setAftBalance(double aftBalance){
        this.aftBalance = aftBalance;
    }
    public void setDiffBalance(double aftBalance){
        this.aftBalance = aftBalance;
    }
}
