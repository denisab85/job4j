package com;     // package name makes no sense 


import java.util.*;

//No javadocs provided
public class Sorter {

    public Sorter(){

    }

    // missing access modifier, must be public for testability
    Set<User> sort (List<User> list) { // no space required before () - check the whole file
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList; // possible one-liner replacement: return new TreeSet<>(list);
    }

    // missing access modifier, must be public for testability
    List<User> sortnamelength (List<User> list) { // java naming convention violated, better name would be: sortByNameLength
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        // A list is a mutable object, so either create a copy and return it, or make method void.
        // In each case the selected behavior must be stated in this method's javadoc.
        list.sort(compar);
        return list;
    }

    // missing access modifier, must be public for testability
    List<User> sortboth (List<User> list) {   // java naming convention violated: sortBoth
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}