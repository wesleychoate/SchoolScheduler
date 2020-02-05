package com.wac.android.schoolscheduler.utils;

import androidx.room.TypeConverter;
import java.time.LocalDate;

public class Convertors {

    @TypeConverter
    public static LocalDate toLocalDate(Long value) {
        return LocalDate.ofEpochDay(value);
    }

    @TypeConverter
    public static Long toLong(LocalDate value) {
        return value.toEpochDay();
    }

}
