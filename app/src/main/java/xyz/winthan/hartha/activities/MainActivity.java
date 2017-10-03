package xyz.winthan.hartha.activities;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.aungpyaephyo.shared.activities.BaseActivity;
import xyz.aungpyaephyo.shared.components.mmfont.MMFontUtils;
import xyz.aungpyaephyo.shared.components.rvset.SmartRecyclerView;
import xyz.winthan.hartha.R;
import xyz.winthan.hartha.adapters.JokeListAdapter;
import xyz.winthan.hartha.itemclicklistener.OnJokeItemClickListener;
import xyz.winthan.hartha.data.models.JokeModel;
import xyz.winthan.hartha.data.vos.JokeVO;

public class MainActivity extends BaseActivity implements OnJokeItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_jokes)
    SmartRecyclerView rvJokes;

    private JokeListAdapter mAdapter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        MMFontUtils.applyMMFontForToolbarTitle(toolbar);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting Jokes...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        mAdapter = new JokeListAdapter(this, this);
        rvJokes.setHasFixedSize(true);
        rvJokes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvJokes.setAdapter(mAdapter);

        JokeModel jokeModel = ViewModelProviders.of(this).get(JokeModel.class);
        jokeModel.initDataBase(this);
        jokeModel.loadJokes();
        jokeModel.getJokeVOListLiveData().observe(this, new Observer<List<JokeVO>>() {
            @Override
            public void onChanged(@Nullable List<JokeVO> jokeVOs) {
                progressDialog.hide();
                mAdapter.setNewData(jokeVOs);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapJoke(JokeVO jokeVO) {
        Intent jokeDetailIntent = JokeDetailActivity.newIntent(getApplicationContext(), jokeVO);
        startActivity(jokeDetailIntent);
    }
}
