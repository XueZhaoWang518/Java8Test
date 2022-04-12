package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(x -> 3 * x).collect(Collectors.toList());

    }

    public List<String> mapLetter() {
        return this.array.stream().map(x -> letters[x - 1]).collect(Collectors.toList());
    }

    public String conversion(Integer currentElement) {
        StringBuffer result = new StringBuffer();
        if (currentElement <= 26) {
            result.append(letterList.get(currentElement - 1));
        } else {

            int firstIndex = currentElement / 26;
            int secondIndex = currentElement % 26;

            if (secondIndex == 0) {
                secondIndex = 26;
                firstIndex--;
            }

            String mapLetter = letterList.get(firstIndex - 1) + letterList.get(secondIndex - 1);
            result.append(mapLetter);
        }
        return result.toString();
    }

    public List<String> mapLetters() {
        return this.array.stream().map(x -> conversion(x)).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        //throw new NotImplementedException();
        return this.array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        //throw new NotImplementedException();
        return this.array.stream().sorted().collect(Collectors.toList());
    }
}
