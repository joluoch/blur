package Strathcafe;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class cairoTextView extends AppCompatTextView {

    public cairoTextView(Context context) {
        super(context);
        init();
    }

    public cairoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public cairoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
