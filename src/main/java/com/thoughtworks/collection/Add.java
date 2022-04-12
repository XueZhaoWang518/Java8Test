package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Optional;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        List<Integer> array = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
        if (leftBorder < rightBorder) {
            left = leftBorder;
            right = rightBorder;
        } else {
            left = rightBorder;
            right = leftBorder;
        }
        while (left <= right) {
            array.add(left++);
        }
        int sum = array.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).orElse(0);
        return sum;
    }


    public int getSumOfOdds(int leftBorder, int rightBorder) {
        List<Integer> array = new ArrayList<Integer>();
        int left = 0;
        int right = 0;
        if (leftBorder < rightBorder) {
            left = leftBorder;
            right = rightBorder;
        } else {
            left = rightBorder;
            right = leftBorder;
        }
        while (left <= right) {
            array.add(left++);
        }
        int sum = array.stream().filter(x -> x % 2 == 1).reduce(Integer::sum).orElse(0);
        return sum;

    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = arrayList.stream().map(i -> 3 * i + 2).reduce(Integer::sum).orElse(0);
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> myList = new ArrayList<Integer>();
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int tmp = it.next();
            int res = 0;
            if (tmp % 2 == 1) {
                res = tmp * 3 + 2;
            } else {
                res = tmp;
            }
            myList.add(res);
        }
        return myList;
    }

    public Optional<Integer> getSumOfProcessedOdds(List<Integer> arrayList) {
        Optional<Integer> sum = arrayList.stream().filter(x -> x % 2 == 1).map(i -> 3 * i + 5).reduce(Integer::sum);
        return sum;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(x -> x % 2 == 0).sorted().collect(Collectors.toList());
        int size = evenList.size();
        if (size % 2 == 1) {
            return evenList.get(size / 2);
        } else {
            return (evenList.get(size / 2 - 1) + evenList.get(size / 2)) / 2;
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        IntSummaryStatistics stats = arrayList.stream().filter(x -> x % 2 == 0).mapToInt((x) -> x).summaryStatistics();
        return stats.getAverage();
    }

    public boolean isIncludedInEven(List<Integer> arrayList, Integer specialElement) {
        List<Integer> list = arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        return list.contains(specialElement);
    }

    public List<Integer> getUnrepeatedFromEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(x -> x % 2 == 0).distinct().collect(Collectors.toList());
        return evenList;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(x -> x % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream().filter(x -> x % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> myList = new ArrayList<Integer>();
        Iterator<Integer> it = arrayList.iterator();
        if (arrayList.size() <= 1) {
            return myList;
        }
        int first = it.next();
        int second = 0;
        while (it.hasNext()) {
            second = first;
            first = it.next();
            int res = (first + second) * 3;
            myList.add(res);
        }
        return myList;
    }
}
