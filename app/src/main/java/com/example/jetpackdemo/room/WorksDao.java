package com.example.jetpackdemo.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WorksDao {
    @Insert
    void insert(WorksEntity... worksEntities);

    @Update
    void update(WorksEntity... worksEntities);

    @Delete
    void delete(WorksEntity... worksEntities);

    @Query("SELECT * FROM works")
    List<WorksEntity> getWorks();

    @Query("DELETE from works")
    void deleteAll();

    @Query("SELECT * FROM works")
    DataSource.Factory<Integer, WorksEntity> getWorksForPaging();
}
