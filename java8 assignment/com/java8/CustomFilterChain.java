package com.java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomFilterChain {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Anna", "Sonia", "Anita", "Pooja", "Rama");

        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> endsWitha = name -> name.endsWith("a");

        List<String> filtered = names.stream()
                                     .filter(startsWithA.and(endsWitha))
                                     .collect(Collectors.toList());

        System.out.println(filtered);
    }
}
