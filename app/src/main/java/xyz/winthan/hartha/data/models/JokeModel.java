package xyz.winthan.hartha.data.models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import xyz.winthan.hartha.data.db.AppDatabase;
import xyz.winthan.hartha.data.vos.JokeVO;

/**
 * Created by winthanhtike on 10/2/17.
 */

public class JokeModel extends AndroidViewModel {

    private MutableLiveData<List<JokeVO>> jokeVOListLiveData;

    private DatabaseReference mDatabaseReference;
    private DatabaseReference mJokes;

    private String JOKES = "jokes";

    private AppDatabase mAppDatabase;

    public JokeModel(Application application) {
        super(application);
        if (jokeVOListLiveData == null) jokeVOListLiveData = new MutableLiveData<>();
        if (mDatabaseReference == null) mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void initDataBase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    public void loadJokes() {

        mJokes = mDatabaseReference.child(JOKES);
        mJokes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<JokeVO> jokeVOList = new ArrayList<JokeVO>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    JokeVO joke = snapshot.getValue(JokeVO.class);
                    jokeVOList.add(joke);
                }

                long[] insertedCount = mAppDatabase.jokeDao().insertJokes(jokeVOList.toArray(new JokeVO[0]));
                Log.i("jokeInserted ==> " , insertedCount.length+"");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public LiveData<List<JokeVO>> getJokeVOListLiveData() {
        return mAppDatabase.jokeDao().getAllJokes();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        AppDatabase.destroyInstance();
    }
}
