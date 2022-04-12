package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flatten {

    Integer[][] array;
    public Flatten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimensional() {
        List<Integer> resList = new ArrayList<Integer>();
        int row = array.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resList.add(array[i][j]);
            }
        }
        return resList;
    }

    public List<Integer> transformToUnrepeatedOneDimensional() {
        List<Integer> resList = this.transformToOneDimensional().stream().distinct().collect(Collectors.toList());
        return resList;
    }
}
