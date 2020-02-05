package com.wac.android.schoolscheduler.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "courses",
        foreignKeys = @ForeignKey(entity = Term.class, parentColumns = "id", childColumns = "termId", onDelete = ForeignKey.RESTRICT))
public class Course {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private Integer termId;

    public Course(String title, LocalDate startDate, LocalDate endDate, String status, Integer termId) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.termId = termId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public Integer getTermId() {
        return termId;
    }
}
