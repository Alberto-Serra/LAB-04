package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void filter() {
        List<Integer> list = Arrays.asList(1, -5, 3, -4, 6, -8);
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        ListFilterer filterer = new ListFilterer(filter);
        List<Integer> filtered = filterer.filter(list);
        Assertions.assertFalse(list.equals(filtered));
    }

    @Test
    public void positiveFilter() {

        List<Integer> list = Arrays.asList(1, -5, 3, -4, 6, -8);
        GenericListFilter filter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(filter);
        List<Integer> filtered = filterer.filter(list);
        Assertions.assertEquals(Arrays.asList(1, 3, 6),filtered);
    }

    @Test
    public void divisibleFilter() {
        List<Integer> list = Arrays.asList(1, -5, 3, -4, 6, -8);
        GenericListFilter filter = new DivisibleByFilter(12);
        ListFilterer filterer = new ListFilterer(filter);
        List<Integer> filtered = filterer.filter(list);
        Assertions.assertEquals(Arrays.asList(1,3,-4,6),filtered);
    }
}
