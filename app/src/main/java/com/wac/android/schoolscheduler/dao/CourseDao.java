package com.wac.android.schoolscheduler.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.wac.android.schoolscheduler.entities.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert
    void insert(Course... courses);

    @Update
    void update(Course... courses);

    @Delete
    void delete(Course... courses);

    @Query("SELECT * FROM courses WHERE id=:id")
    Course getCourse(Integer id);

    @Query("SELECT * FROM courses")
    List<Course> getAllCourses();

    @Query("SELECT * FROM courses WHERE termId=:termId")
    List<Course> getCoursesForTerm(final int termId);
}
