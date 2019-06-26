package Strathcafe;

import android.content.Context;
import android.graphics.Typeface;

import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;



public class cairoEditText extends AppCompatEditText {


    public cairoEditText(Context context) {
        super(context);
        init();
    }

    public cairoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public cairoEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Cairo-Regular.ttf");
            setTypeface(tf);
        }
    }

}
