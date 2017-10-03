package xyz.aungpyaephyo.shared.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by aung on 6/13/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected boolean mDetachedFromWindow;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }

        itemView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                mDetachedFromWindow = false;
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                mDetachedFromWindow = true;
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    public abstract void bind(T data);

    @Subscribe
    public void onEvent(Object obj) {

    }
}
