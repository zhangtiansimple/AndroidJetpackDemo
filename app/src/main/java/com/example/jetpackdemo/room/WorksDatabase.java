package com.example.jetpackdemo.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {WorksEntity.class}, version = 1, exportSchema = false)
public abstract class WorksDatabase extends RoomDatabase {
    public abstract WorksDao getWorksDao();
}
