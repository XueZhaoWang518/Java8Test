package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> myList = new ArrayList<>();
        if (left <= right) {
            int i = left;
            while (i <= right) {
                myList.add(i++);
            }
        } else {
            int i = left;
            while (i >= right) {
                myList.add(i--);
            }
        }
        return myList;

    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> myList = new ArrayList<>();
        if (left <= right) {
            int i = left;
            while (i <= right) {
                myList.add(i++);
            }
        } else {
            int i = left;
            while (i >= right) {
                myList.add(i--);
            }
        }
        myList = myList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        return myList;
    }

    public List<Integer> popEvenElements(int[] array) {
        List<Integer> myList = Arrays.stream(array).boxed().filter(x -> x % 2 == 0).collect(Collectors.toList());
        return myList;
    }

    public int popLastElement(int[] array) {
        List<Integer> myList = Arrays.stream(array).boxed().collect(Collectors.toList());
       return  myList.stream().reduce((first, second) -> second).orElse(0);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List commonList = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List secondList= Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        commonList.retainAll(secondList);

        return commonList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List unCommonList = Arrays.stream(firstArray).collect(Collectors.toList());
        List secondList= Arrays.stream(secondArray).collect(Collectors.toList());
        secondList.removeAll(unCommonList);
        unCommonList.addAll(secondList);

        return unCommonList;
    }
}
