package com.wac.android.schoolscheduler;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.wac.android.schoolscheduler.dao.CourseDao;
import com.wac.android.schoolscheduler.dao.TermDao;
import com.wac.android.schoolscheduler.entities.Course;
import com.wac.android.schoolscheduler.entities.Term;
import com.wac.android.schoolscheduler.utils.Convertors;

@Database(entities = { Term.class, Course.class }, version = 1)
@TypeConverters({Convertors.class})
public abstract class ScheduleDatabase extends RoomDatabase {

    private static final String DB_NAME = "scheduleDatabase.db";
    private static volatile ScheduleDatabase instance;

    static synchronized ScheduleDatabase getInstance(Context context) {
        if (instance == null)
            instance = create(context);
        return instance;
    }

    private static ScheduleDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                ScheduleDatabase.class,
                DB_NAME).build();
    }

    public abstract TermDao getTermDao();
    public abstract CourseDao getCourseDao();
}
