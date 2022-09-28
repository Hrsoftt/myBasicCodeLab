package com.company;

public class App {

    public static void main(String[] args) {
	    Plant p =new Plant();
        Tree t= new Tree();
        Plant p2= t;
        p2.grow();
        t.shedLeaves();
        p.grow();
    }
}
