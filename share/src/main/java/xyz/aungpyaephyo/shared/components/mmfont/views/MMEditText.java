package xyz.aungpyaephyo.shared.components.mmfont.views;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Html;
import android.util.AttributeSet;

import xyz.aungpyaephyo.shared.components.mmfont.MMFontUtils;


/**
 * Created by aung on 8/15/17.
 */

public class MMEditText extends AppCompatEditText {

    public MMEditText(Context context) {
        super(context);
    }

    public MMEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MMEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode())
            MMFontUtils.setMMFont(this);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!MMFontUtils.isSupportUnicode()) {
            super.setText(Html.fromHtml(MMFontUtils.mmText(text, MMFontUtils.TEXT_UNICODE, true, true)), type);
        } else {
            super.setText(Html.fromHtml(text.toString()), type);
        }
    }
}
