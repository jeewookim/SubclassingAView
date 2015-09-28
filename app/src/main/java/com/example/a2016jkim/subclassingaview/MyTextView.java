package com.example.a2016jkim.subclassingaview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 2016jkim on 9/23/2015.
 */
public class MyTextView extends TextView {

    private int mValue;
    //constructor
    public MyTextView(Context context, AttributeSet attrs) {

        super(context,attrs);
        setupAttributes(attrs);
        setText(mValue+"");
    }

    //Accesses the xml
    private void setupAttributes(AttributeSet attrs) {
                // Obtain a typed array of attributes
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MyTextView, 0, 0);
                // Extract custom attributes into member variables
                try {
                        mValue = a.getInt(R.styleable.MyTextView_initialValue, 0);
                }
                finally {
                    // TypedArray objects are shared and must be recycled.
                    a.recycle();
                }
            }

    //increment and update the view
    public void incrementAndUpdate(){
        mValue++;
        setText(mValue+"");
    }
}