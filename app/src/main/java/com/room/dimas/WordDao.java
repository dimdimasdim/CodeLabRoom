package com.room.dimas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);

    @Query("DELETE FROM WORD_TABLE")
    void  deleteAll();

    @Query("SELECT * FROM word_table ORDER BY id ASC")
    LiveData<List<Word>> getAllWord();
}
