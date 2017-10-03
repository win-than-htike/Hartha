package xyz.aungpyaephyo.shared.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import xyz.aungpyaephyo.shared.R;
import xyz.aungpyaephyo.shared.views.items.SpinnerViewItem;

/**
 * Created by aung on 11/8/16.
 */

public class SpinnerAdapter extends BaseAdapter implements ThemedSpinnerAdapter {

    private List<String> mData;
    private final Helper mDropDownHelper;

    public SpinnerAdapter(Context context, List<String> data) {
        mData = data;
        mDropDownHelper = new Helper(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int id) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mDropDownHelper.getDropDownViewInflater().inflate(R.layout.view_item_spinner, viewGroup, false);
        }

        if (view instanceof SpinnerViewItem) {
            SpinnerViewItem viSpinner = (SpinnerViewItem) view;
            viSpinner.bindData(getItem(position));
        }

        return view;
    }

    @Override
    public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
        mDropDownHelper.setDropDownViewTheme(theme);
    }

    @Nullable
    @Override
    public Resources.Theme getDropDownViewTheme() {
        return mDropDownHelper.getDropDownViewTheme();
    }

    public int getPosition(String timeslot) {
        return mData.indexOf(timeslot);
    }
}
