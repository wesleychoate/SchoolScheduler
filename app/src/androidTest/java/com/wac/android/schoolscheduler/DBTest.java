package com.wac.android.schoolscheduler;

import androidx.room.Room;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;

import com.wac.android.schoolscheduler.entities.Course;
import com.wac.android.schoolscheduler.entities.Term;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.util.List;

@RunWith(AndroidJUnit4ClassRunner.class)
public class DBTest {
    static private ScheduleDatabase sdb;

    @BeforeClass
    public static void initDb() {
        sdb = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(),
                ScheduleDatabase.class).build();
    }

    @AfterClass
    public static void closeDb() {
        sdb.close();;
    }

    @Test
    public void insertSavesData() {
        Term testTerm = new Term("Test 1",
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 2, 29));
        sdb.getTermDao().insert(testTerm);

        List<Term> terms = sdb.getTermDao().getAllTerms();
        assert(!terms.isEmpty());
    }

    @Test
    public void testDeleteAllTerms() {
        Term testTerm = new Term("Test 2",
                LocalDate.of(2020, 3, 1),
                LocalDate.of(2020, 3, 31));
        Term testTerm2 = new Term("Test 3",
                LocalDate.of(2020, 4, 1),
                LocalDate.of(2020, 4, 30));
        sdb.getTermDao().insert(testTerm, testTerm2);

        sdb.getTermDao().deleteAllTerms();
        List<Term> termsPostDelete = sdb.getTermDao().getAllTerms();

        assert(termsPostDelete.isEmpty());
    }

    @Ignore
    @Test
    public void testRefInt() {
        Term testTerm = new Term("Test 2",
                LocalDate.of(2020, 3, 1),
                LocalDate.of(2020, 3, 31));
        Term testTerm2 = new Term("Test 3",
                LocalDate.of(2020, 4, 1),
                LocalDate.of(2020, 4, 30));
        sdb.getTermDao().insert(testTerm, testTerm2);

        List<Term> terms = sdb.getTermDao().getAllTerms();

        Course testCourse = new Course("Mobile App Dev",
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 31),
                "In progress", terms.get(0).getId());

        sdb.getCourseDao().insert(testCourse);
        System.out.println("This should not blow up.");

        Course getIt = sdb.getCourseDao().getCourse(1);
        System.out.println("This should not blow up. " + getIt);

        Term getItMore = sdb.getTermDao().getTerm(2);
        System.out.println("This should not blow up either. " + getItMore);

        sdb.getTermDao().delete(terms.get(0));
        System.out.println("This should blow up!");
    }
}