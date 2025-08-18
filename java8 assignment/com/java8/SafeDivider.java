package com.java8;
import java.util.Optional;

public class  SafeDivider{
    public static void main(String[] args) {
        System.out.println(safeDivide(10, 2).orElse("Not Allowed"));
        System.out.println(safeDivide(10, 0).orElse("Not Allowed"));
    }

    static Optional<String> safeDivide(int a, int b) {
        if (b == 0) {
            return Optional.empty();
        } else {
            return Optional.of(String.valueOf(a / b));
        }
    }
}
