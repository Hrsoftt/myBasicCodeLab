package com.company;

public class NestedClasses3 {
    interface SaleToday{
        int dollarsOff();

    }
    public int pay(){
        return admission(5,new SaleToday(){
            public int dollersOff(){
                return 3;
            }
        });
    }
    public int admission(int basePrice,SaleToday sale){
        return basePrice-sale.dollarsOff();

    }
    public static void main(String[]args){
        SaleToday s=new SaleToday() {
            @Override
            public int dollarsOff() {
                return 0;
            }
        };
    }
}
