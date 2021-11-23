package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    GenericListFilter filter;

    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer num : list)
            if (filter.accept(num))
                filtered.add(num);
        return filtered;
    }
}
