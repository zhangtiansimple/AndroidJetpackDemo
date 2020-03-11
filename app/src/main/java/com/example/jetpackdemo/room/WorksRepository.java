package com.example.jetpackdemo.room;

import android.content.Context;

import androidx.room.Room;

public class WorksRepository {
    private static volatile WorksRepository instance;

    private WorksDatabase worksDatabase;
    private WorksDao worksDao;

    public WorksRepository(Context context) {
        worksDatabase = Room.databaseBuilder(context, WorksDatabase.class, "works_db").allowMainThreadQueries().build();
        worksDao = worksDatabase.getWorksDao();
    }

    public static WorksRepository getInstance(Context context) {
        if(instance == null) {
            synchronized (WorksRepository.class) {
                if (instance == null) {
                    instance = new WorksRepository(context);
                }
            }
        }
        return instance;
    }

    public WorksDao getWorksDao() {
        return worksDao;
    }
}
