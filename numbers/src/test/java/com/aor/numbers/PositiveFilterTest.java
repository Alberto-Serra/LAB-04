package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    GenericListFilter filter;

    @BeforeEach
    public void helper() {
        filter = new PositiveFilter();
    }

    @Test
    public void truePositiveAccpet() {
        Assertions.assertTrue(filter.accept(5));
    }

    @Test
    public void falsePositiveAccpet() {
        Assertions.assertFalse(filter.accept(-2));
    }
}
