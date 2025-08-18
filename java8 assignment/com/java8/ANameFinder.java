package com.java8;

import java.util.*;
import java.util.stream.Collectors;

public class ANameFinder {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Rahul", "Anita", "Sneha", "Alex");
        List<String> filtered = names.stream()
                                     .filter(name -> name.startsWith("A"))
                                     .collect(Collectors.toList());
        System.out.println(filtered);
    }
}
