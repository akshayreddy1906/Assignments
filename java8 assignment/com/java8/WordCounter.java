package com.java8;

import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Sonal", "Prakash", "Sneha", "Vijay");
        long count = names.stream()
                          .filter(name -> name.length() > 5)
                          .count();
        System.out.println(count);
    }
}
