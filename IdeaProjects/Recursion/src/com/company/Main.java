package com.company;

public class Main {

    public static void main(String[] args) {
	    int result = sum(10);
        System.out.println(result);
        int total = add(5,10);
        System.out.println(total);
    }
    public static int sum(int K){
        if(K>0){
            return K +sum(K-1);

        }else{
            return 0;
        }
    }
    public static int add(int start,int stop){
        if(stop>start){
            return stop + add(start, stop-1);
        }else {
            return stop;
        }

    }

    public static void main(String[] args) {

    }
}
