package com.company;

public class Main {
    private String greeting = "Hi";

    protected class inner{
        public int repeat=3;
        public void go(){
            for(int i=0;i<repeat;i++);
            System.out.println(greeting);
        }
    }
        public void callInner(){
        inner n = new inner();
        n.go();
        }

    public static void main(String[] args) {
        Main ns = new Main();
        ns.callInner();
    }
}
