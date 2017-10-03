package xyz.winthan.hartha.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import xyz.aungpyaephyo.shared.adapters.BaseRecyclerAdapter;
import xyz.winthan.hartha.itemclicklistener.OnJokeItemClickListener;
import xyz.winthan.hartha.data.vos.JokeVO;
import xyz.winthan.hartha.holders.JokeViewHolder;
import xyz.winthan.hartha.R;

/**
 * Created by winthanhtike on 10/2/17.
 */

public class JokeListAdapter extends BaseRecyclerAdapter<JokeViewHolder, JokeVO> {

    private OnJokeItemClickListener itemClickListener;

    public JokeListAdapter(Context context, OnJokeItemClickListener itemClickListener) {
        super(context);
        this.itemClickListener = itemClickListener;
    }

    @Override
    public JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_joke, parent, false);
        return new JokeViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(JokeViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

}
