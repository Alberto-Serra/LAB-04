package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    List<Integer> list;
    List<Integer> expected;

    @BeforeEach
    public void helper() {
        list = Arrays.asList(1, 2, 4, 2, 5);
        expected = Arrays.asList(1, 2, 4, 5);
    }

    @Test
    public void deduplicate() {
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> temp = Arrays.asList(1, 2, 4, 2);
        class ListSorterTest implements GenericListSorter {

            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4);
            }
        }
        List<Integer> distinct = deduplicator.deduplicate(temp, new ListSorterTest());
        Assertions.assertEquals(distinct, distinct);
    }

    @Test
    public void deduplicate_bug() {
        List<Integer> temp = Arrays.asList(1, 2, 4, 2);
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(temp, new ListSorter());

        Assertions.assertEquals(Arrays.asList(1, 2, 4), distinct);
    }
}
