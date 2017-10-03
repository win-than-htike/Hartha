package xyz.winthan.hartha.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import xyz.winthan.hartha.data.vos.JokeVO;

/**
 * Created by winthanhtike on 10/3/17.
 */

@Database(entities = {JokeVO.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "JOKE.DB";

    private static AppDatabase INSTANCE;

    public abstract JokeDao jokeDao();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
