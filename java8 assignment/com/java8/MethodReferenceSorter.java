package com.java8;

import java.util.*;

public class MethodReferenceSorter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul", "Amit", "Sneha", "Priya", "Vijay");
        Collections.sort(names, String::compareTo);
        System.out.println(names);
    }
}
