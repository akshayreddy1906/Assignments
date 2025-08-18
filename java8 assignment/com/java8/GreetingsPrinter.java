package com.java8;

@FunctionalInterface
interface MessagePrinter {
    void print(String msg);
}

public class GreetingsPrinter {
    static void showMessage(MessagePrinter printer) {
        printer.print("Hello from Java 8!");
    }

    public static void main(String[] args) {
        showMessage(message -> System.out.println(message));
    }
}
