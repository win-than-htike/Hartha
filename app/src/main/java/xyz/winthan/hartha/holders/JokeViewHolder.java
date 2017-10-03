package xyz.winthan.hartha.holders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import xyz.aungpyaephyo.shared.views.holders.BaseViewHolder;
import xyz.winthan.hartha.R;
import xyz.winthan.hartha.itemclicklistener.OnJokeItemClickListener;
import xyz.winthan.hartha.data.vos.JokeVO;

/**
 * Created by winthanhtike on 10/2/17.
 */

public class JokeViewHolder extends BaseViewHolder<JokeVO> {

    @BindView(R.id.tv_joke_title)
    TextView tvJokeTitle;

    @BindView(R.id.tv_category)
    TextView tvCategory;

    private OnJokeItemClickListener itemClickListener;

    private JokeVO jokeVO;

    public JokeViewHolder(View itemView, OnJokeItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void bind(JokeVO data) {
        this.jokeVO = data;

        tvJokeTitle.setText(data.getTitle());
        tvCategory.setText(data.getCategory().getName());
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (itemClickListener != null) itemClickListener.onTapJoke(jokeVO);
    }
}
