package xyz.aungpyaephyo.shared.components.mmfont.views;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.text.Html;
import android.util.AttributeSet;

import xyz.aungpyaephyo.shared.components.mmfont.MMFontUtils;


/**
 * Created by beta on 9/7/17.
 */

public class MMSpinner extends AppCompatSpinner{
    public MMSpinner(Context context) {
        super(context);
    }

    public MMSpinner(Context context, int mode) {
        super(context, mode);
    }

    public MMSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void setPrompt(CharSequence prompt) {
        if(!MMFontUtils.isSupportUnicode()){
            super.setPrompt(Html.fromHtml(MMFontUtils.uni2zg(prompt.toString())));
        }else{
            super.setPrompt(Html.fromHtml(prompt.toString()));
        }
    }
}
