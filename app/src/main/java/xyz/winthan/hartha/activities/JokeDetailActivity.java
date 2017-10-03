package xyz.winthan.hartha.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.aungpyaephyo.shared.activities.BaseActivity;
import xyz.aungpyaephyo.shared.components.mmfont.MMFontUtils;
import xyz.winthan.hartha.R;
import xyz.winthan.hartha.data.vos.JokeVO;

public class JokeDetailActivity extends BaseActivity {

    private static final String JOKE = "JOKE";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_joke_desc)
    TextView tvJokeDesc;

    @BindView(R.id.tv_joke_title)
    TextView tvJokeTitle;

    public static Intent newIntent(Context context, JokeVO jokeVO) {
        Intent jokeDetailIntent = new Intent(context, JokeDetailActivity.class);
        jokeDetailIntent.putExtra(JOKE, jokeVO);
        return jokeDetailIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        MMFontUtils.applyMMFontForToolbarTitle(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        if (getIntent().getExtras() != null) {

            JokeVO joke = (JokeVO) getIntent().getSerializableExtra(JOKE);

            if (joke != null) {

                tvJokeDesc.setText(joke.getJokes());
                tvJokeTitle.setText(joke.getTitle());

            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_joke_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
