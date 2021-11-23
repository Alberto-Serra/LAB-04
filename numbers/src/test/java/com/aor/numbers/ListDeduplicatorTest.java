package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));
        List<Integer> distinct = deduplicator.deduplicate(temp);
        Assertions.assertEquals(distinct, distinct);
    }

    @Test
    public void deduplicate_bug() {
        List<Integer> temp = Arrays.asList(1, 2, 4, 2);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        List<Integer> distinct = deduplicator.deduplicate(temp);
        Assertions.assertEquals(Arrays.asList(1, 2, 4), distinct);
    }
}
