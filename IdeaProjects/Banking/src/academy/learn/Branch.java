package academy.learn;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName,double initialTransaction){
        if(findCustomer(customerName)==null){
            this.customers.add(new Customer(customerName,initialTransaction));
            return true;
        }return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer !=null){
            existingCustomer.addTransaction(transaction);
            return true;
        }return false;
    }

    private Customer findCustomer(String customerName){
        for (int i=0; i<this.customers.size(); i++){
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)){
                return checkedCustomer;
            }
        }return null;
    }
//    private int findCustomerIndex(Customer name){
//        return this.customers.indexOf(name);
//    }
//
//    public String findCustomer(String name){
//        for (int i = 0; i<this.customers.size(); i++){
//            Customer customer = this.customers.get(i);
//            if (customer.getName().equals(name)){
//                return this.customers.get(i).getName();
//            }return null;
//        }
//
//    }
}
