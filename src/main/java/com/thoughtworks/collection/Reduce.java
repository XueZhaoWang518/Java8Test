package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;
    IntSummaryStatistics stas;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
        this.stas = this.arrayList.stream().mapToInt(x -> x).summaryStatistics();

    }

    public int getMaximum() {
        return this.stas.getMax();
    }

    public double getMinimum() {
        return this.stas.getMin();
    }

    public double getAverage() {

        //throw new NotImplementedException();
        return this.stas.getAverage();
    }

    public double getMedian() {
        int size = this.arrayList.size();
        int a = this.arrayList.stream().collect(Collectors.toList()).get(size / 2);
        int b = this.arrayList.stream().collect(Collectors.toList()).get(size / 2 - 1);
        double res = ((double) a + (double) b) / 2;
        return res;
    }

    public double getOrderedMedian() {
        int size = this.arrayList.size();
        int a = this.arrayList.stream().sorted().collect(Collectors.toList()).get(size / 2);
        int b = this.arrayList.stream().sorted().collect(Collectors.toList()).get(size / 2 - 1);
        if (size % 2 == 1) return (double) b;
        else return ((double) a + (double) b) / 2;
    }

    public int getFirstEven() {
        Optional<Integer> res = this.arrayList.stream().filter(x -> x % 2 == 0).findFirst();
        int firstEven = -1;
        if (res.isPresent()) {
            firstEven = res.get();
        }
        return firstEven;
    }

    public int getIndexOfFirstEven() {
        Optional<Integer> res = this.arrayList.stream().filter(x -> x % 2 == 0).findFirst();
        int firstEven = -1;
        if (res.isPresent()) {
            firstEven = this.arrayList.indexOf(res.get());
        }
        return firstEven;
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (this.arrayList.size() != arrayList.size()) {
            return false;
        } else {
            for (int i = 0; i < arrayList.size(); i++) {

                if (arrayList.get(i) != this.arrayList.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }


    public int getLastOdd() {
        Optional<Integer> res = this.arrayList.stream().filter(x -> x % 2 == 1).reduce((first, second) -> second);
        int lastOdd = -1;
        if (res.isPresent()) {
            lastOdd = res.get();
        }
        return lastOdd;
    }

    public int getIndexOfLastOdd() {
        Optional<Integer> res = this.arrayList.stream().filter(x -> x % 2 == 1).reduce((first, second) -> second);
        int lastOdd = -1;
        if (res.isPresent()) {
            lastOdd = this.arrayList.indexOf(res.get());
        }
        return lastOdd;
    }
}
