package com.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyMapper {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Sneha", "Amit", "Rahul", "Sneha", "Sneha");
        Map<String, Long> frequencyMap = names.stream()
                                              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencyMap);
    }
}
