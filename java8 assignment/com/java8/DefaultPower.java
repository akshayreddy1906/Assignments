package com.java8;

interface Power {
    void show();

    default void info() {
        System.out.println("Default Method Called");
    }
}

public class DefaultPower implements Power {
    public void show() {
        System.out.println("Abstract Method Called");
    }

    public static void main(String[] args) {
        DefaultPower obj = new DefaultPower();
        obj.show();
        obj.info();
    }
}
