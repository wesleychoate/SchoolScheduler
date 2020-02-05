package com.wac.android.schoolscheduler.utils;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class ConvertorsTest {

    @Test
    public void toLocalDate() {
        Long feb4 = new Long(18296);
        LocalDate feb4ld = LocalDate.of(2020, 2, 4);
        LocalDate test = Convertors.toLocalDate(feb4);
        assertTrue(test.isEqual(feb4ld));
    }

    @Test
    public void testFromLocalDate() {
        Long feb4 = new Long(18296);
        LocalDate feb4ld = LocalDate.of(2020, 2, 4);
        Long test = Convertors.toLong(feb4ld);
        assertTrue(feb4.compareTo(test) == 0);
    }
}