//package academy.learn;
//
//import java.util.ArrayList;
//
//public class Customer {
//    private String name;
//    private ArrayList<Double> transactions;
//
//    public Customer(String name, double initialTransaction) {
//        this.name = name;
//        this.transactions = new ArrayList<>();
//        addTransaction(initialTransaction);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public ArrayList<Double> getTransactions() {
//        return transactions;
//    }
//
//    public void addTransaction(double transaction){
//        this.transactions.add(transaction);
//    }
//}



package com.company;

system 

public class Person {
    static int id = Main.people.size();
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;

    Person(String name, String surname, String phoneNumber, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        id++;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getEmail() {
        return email;
    }

    String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "\n\nName: " + getName() + "\nSurname: " + getSurname() + "\nPhone number: " + getPhoneNumber() + "\nEmail: " +
                getEmail() + "\nAddress: " + getAddress();
    }
}


//    My code works as I want it to, but I would like someone to look at it and help me improve it.