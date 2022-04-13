package dev.terry.entities;

public class Account{
    // fields
    private String mainId;
    private String sharedId;
    private String firstName;
    private String lastName;
    private String accountPin;
    private boolean shareState;
    private boolean savingsState;
    private boolean checkingState;

    // no args constructor
    public Account(){
    }

    // constructor
    public Account(
        String mainId,
        String sharedId,
        String firstName,
        String lastName,
        String accountPin,
        boolean shareState,
        boolean savingsState,
        boolean checkingState){

        this.mainId = mainId;
        this.sharedId = sharedId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountPin = accountPin;
        this.shareState = shareState;
        this.savingsState = savingsState;
        this.checkingState = checkingState;
    }

    // getter
    public String getMainId(){
        return this.mainId;
    }
    public String getSharedId(){
        return this.sharedId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAccountPin(){
        return this.accountPin;
    }
    public boolean getShareState(){
        return this.shareState;
    }
    public boolean getSavingsState(){
        return this.savingsState;
    }
    public boolean getCheckingState(){
        return this.checkingState;
    }

    // setter
    public void setMainId(String mainId){
        this.mainId = mainId;
    }
    public void setSharedId(String sharedId){
        this.sharedId = sharedId;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAccountPin(String accountPin){
        this.accountPin = accountPin;
    }
    public void setShareState(boolean shareState){
        this.shareState = shareState;
    }
    public void setSavingsState(boolean savingsState){
        this.savingsState = savingsState;
    }
    public void setCheckingState(boolean checkingState){
        this.checkingState = checkingState;
    }

    @Override
    public String toString() {
        return "Account{\n" +
                "\tmain_id=" + this.mainId +"\n"+
                "\tshared_id=" + this.sharedId +"\n"+
                "\tfirst_name=" + this.firstName +"\n"+
                "\tlast_name=" + this.lastName +"\n"+
                "\taccount_pin=" + this.accountPin +"\n"+
                "\tshare_state=" + this.shareState +"\n"+
                "\tsavings_state=" + this.savingsState +"\n"+
                "\tchecking_state=" + this.checkingState +"\n"+
                '}';
    }
}
