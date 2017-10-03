package xyz.aungpyaephyo.shared.components.mmfont.views;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

/**
 * Created by beta on 9/5/17.
 */

public class MMCheckBox extends AppCompatCheckBox {
    public MMCheckBox(Context context) {
        super(context);
    }

    public MMCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MMCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    protected void onFinishInflate() {
//        super.onFinishInflate();
//        if(!isInEditMode())
//            MMFontUtils.setMMFont(this);
//    }

//    @Override
//    public void setText(CharSequence text, BufferType type) {
//        if(!MMFontUtils.isSupportUnicode()){
//            super.setText(Html.fromHtml(MMFontUtils.mmText(text,MMFontUtils.TEXT_UNICODE,true,true)));
//        }else{
//            super.setText(Html.fromHtml(text.toString()), type);
//        }
//    }
}
