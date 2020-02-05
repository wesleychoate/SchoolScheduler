package com.wac.android.schoolscheduler.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.wac.android.schoolscheduler.entities.Term;

import java.util.List;

@Dao
public interface TermDao {

    @Query("SELECT * FROM terms")
    List<Term> getAllTerms();

    @Insert
    void insert(Term... terms);

    @Update
    void update(Term... terms);

    @Delete
    void delete(Term... terms);

    @Query("SELECT * FROM terms WHERE id=:id")
    Term getTerm(Integer id);

    @Query("DELETE FROM terms")
    void deleteAllTerms();
}
