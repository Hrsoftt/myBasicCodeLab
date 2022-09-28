package com.company;

public interface Walk {
    public default int getSpeed(){
        return 5;
    }
}
