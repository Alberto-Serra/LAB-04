package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisbleByFilterTest {
    GenericListFilter filter;

    @BeforeEach
    public void helper() {
        filter = new DivisibleByFilter(8);
    }

    @Test
    public void trueDivibleAccpet() {
        Assertions.assertTrue(filter.accept(4));
    }

    @Test
    public void falseDivisbleAccpet() {
        Assertions.assertFalse(filter.accept(3));
    }
}
