package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    List<Integer> list;

    @BeforeEach
    public void helper() {
        list = Arrays.asList(1, 2, 4, 2, 5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max_bug_7263() {
        ListAggregator aggregator = new ListAggregator();
        List<Integer> bug_list = Arrays.asList(-1, -4, -5);
        int max = aggregator.max(bug_list);
        Assertions.assertEquals(-1, max);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct_bug_8726() {
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), new ListDeduplicator(), new ListSorter());

        Assertions.assertEquals(3, distinct);
    }

    @Test
    public void distinct() {
        List<Integer> temp = Arrays.asList(1, 2, 2, 0, 5, 5);

        class ListDeduplicatorTest implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter) {
                return Arrays.asList(1, 2, 0, 5);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(temp, new ListDeduplicatorTest(), new ListSorter());

        Assertions.assertEquals(4, distinct);
    }
}
