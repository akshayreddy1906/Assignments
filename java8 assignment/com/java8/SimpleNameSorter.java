package com.java8;
import java.util.*;

public class SimpleNameSorter {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Akshay");
        names.add("Sanjay");
        names.add("Sneha");
        names.add("Priya");
        names.add("Vijay");
        Collections.sort(names, (n1, n2) -> n1.compareTo(n2));

        System.out.println("Sorted names: " + names);
    }
}
