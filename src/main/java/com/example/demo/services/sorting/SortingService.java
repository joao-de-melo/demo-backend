package com.example.demo.services.sorting;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SortingService {

    public List<Integer> quicksort(List<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }

        Integer pivot = input.get(0);
        List<Integer> less = input.stream()
                .skip(1)
                .filter(x -> x.compareTo(pivot) < 0)
                .collect(Collectors.toList());
        List<Integer> greater = input.stream()
                .skip(1)
                .filter(x -> x.compareTo(pivot) >= 0)
                .collect(Collectors.toList());

        return concat(quicksort(less), pivot, quicksort(greater));
    }

    private static List<Integer> concat(List<Integer> less, Integer pivot, List<Integer> greater) {
        List<Integer> result = new ArrayList<>(less);
        result.add(pivot);
        result.addAll(greater);
        return result;
    }

}
