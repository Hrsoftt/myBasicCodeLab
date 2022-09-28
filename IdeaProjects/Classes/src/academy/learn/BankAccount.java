package academy.learn;

public class BankAccount {
    private long accountNumber;
    private int balance;
    private String customersName;
    private String email;
    private int phoneNumber;

    public BankAccount(){
        this(123, 2,"Default name","Default address",
                2344);
    }

    public BankAccount(long accountNumber,int balance,String customersName,String email,
                       int phoneNumber){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.customersName=customersName;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public void setAccountNumber(long accountNumber){
        this.accountNumber=accountNumber;
    }
    public void setBalance(int balance){
        this.balance=balance;
    }
    public void setCustomersName(String customersName){
        this.customersName=customersName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public long getAccountNumber(){
        return accountNumber;
    }
    public int getBalance(){
        return balance;
    }
    public String getCustomersName(){
        return customersName;
    }
    public String getEmail(){
        return email;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void depositFunds(double funds){
      balance+=funds;
        System.out.println("Deposit of "+funds + " Balance: "+balance);
    }
    public void withdrawFunds(double amount){
        if(balance>amount){
            balance-=amount;
            System.out.println("Withdrawal of: "+amount+" Remaining balance: "+balance);
        }else {
        System.out.println("Insufficient funds");}
    }
}
