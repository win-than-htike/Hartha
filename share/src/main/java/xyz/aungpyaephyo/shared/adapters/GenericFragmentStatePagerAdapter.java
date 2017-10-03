package xyz.aungpyaephyo.shared.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import xyz.aungpyaephyo.shared.Shared;


/**
 * Created by aung on 7/20/16.
 */
public class GenericFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mFragmentTitles;

    public GenericFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragmentTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(Shared.TAG, "Pager Title - " + mFragmentTitles.get(position));
        return mFragmentTitles.get(position);
    }

    public void addTab(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    public void addTab(Fragment fragment) {
        mFragments.add(fragment);
        mFragmentTitles.add("Dummy Page Title");
    }

    public List<String> getPageTitles() {
        return mFragmentTitles;
    }

    public Fragment getFragment(int position) {
        return mFragments.get(position);
    }

    public void removeAllTabs() {
        mFragments.clear();
        mFragmentTitles.clear();
    }
}
