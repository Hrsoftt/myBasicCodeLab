package academy.learn;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> myBranch;

    public Bank(String name ) {
        this.name = name;
        this.myBranch = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        if (findBranch(branchName)==null){
            this.myBranch.add(new Branch(branchName));
            return true;
        }return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branch branch = findBranch(branchName);
        if (branch !=null){
            return branch.newCustomer(customerName,initialTransaction);
        }return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch = findBranch(branchName);
        if (branch!=null){
            return branch.addCustomerTransaction(customerName,transaction);
        }return false;
    }

    private Branch findBranch(String branchName){
        for (int i=0; i<this.myBranch.size(); i++){
            Branch checkedBranch = this.myBranch.get(i);
            if (checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        }return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if (branch !=null){
            System.out.println("Customers details for branch"+ branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i=0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName()+ " [" + i + "]");
                if (showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions =branchCustomer.getTransactions();
                    for (int j=0; j<transactions.size(); j++){
                        System.out.println("[" + (i+1) + "] Amount" + transactions.get(j));
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }















}
