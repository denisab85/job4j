package com;     // package name makes no sense 


import java.util.*;

//No javadocs provided
public class Convert {

    public Convert(){

    }

    //Converts array to list
    List<Integer> makeList(int[][] array) {   // missing access modifier, must be public for testability
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }


    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);

        // 2 extra empty lines inside method
        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {        // can be simplified by iterating through the list in the for-each style
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;         // unnecessary assignment, java int arrays are initialized to 0's
            }
        }
        return array;
    }
}