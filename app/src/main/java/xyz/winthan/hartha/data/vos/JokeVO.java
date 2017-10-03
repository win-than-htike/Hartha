package xyz.winthan.hartha.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winthanhtike on 10/2/17.
 */

@Entity(tableName = "jokes")
public class JokeVO implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @Embedded(prefix = "c_")
    public CategoryVO category;

    public String imageUrl;

    public String jokes;

    public String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoryVO getCategory() {
        return category;
    }

    public void setCategory(CategoryVO category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJokes() {
        return jokes;
    }

    public void setJokes(String jokes) {
        this.jokes = jokes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static List<JokeVO> dummyData(){
        List<JokeVO> jokeVOList = new ArrayList<>();
        for (int i = 0; i < 17; i++){
            jokeVOList.add(new JokeVO());
        }
        return jokeVOList;
    }

}
