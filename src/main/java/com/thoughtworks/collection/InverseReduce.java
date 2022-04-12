package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> resList = new ArrayList<Integer>();
        int i = this.random.nextInt(3);
        while (number - i > 0) {
            number -= i;
            resList.add(Integer.valueOf(number));
        }
        return resList;
    }
}
