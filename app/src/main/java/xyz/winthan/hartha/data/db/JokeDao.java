package xyz.winthan.hartha.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.winthan.hartha.data.vos.JokeVO;

/**
 * Created by winthanhtike on 10/3/17.
 */

@Dao
public interface JokeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertJoke(JokeVO jokes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertJokes(JokeVO... jokes);

    @Query("SELECT * FROM jokes")
    LiveData<List<JokeVO>> getAllJokes();

    @Query("SELECT * FROM jokes WHERE title = :title")
    LiveData<JokeVO> getSingleJoke(String title);

    @Query("DELETE FROM jokes")
    void deleteAll();

}
