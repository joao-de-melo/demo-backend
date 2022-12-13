package com.example.demo.services.sorting;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

class SortingServiceTest {
    private final SortingService underTest = new SortingService();

    @Test
    void handlesWithEmptyList() {
        List<Integer> result = underTest.quicksort(Collections.emptyList());

        MatcherAssert.assertThat(result, hasSize(0));
    }

    @Test
    void sortsNumbersCorrectly() {
        List<Integer> result = underTest.quicksort(Arrays.asList(3, 1, 2));

        MatcherAssert.assertThat(result, IsIterableContainingInOrder.contains(1, 2, 3));
    }
}
