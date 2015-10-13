package com.example.a2016jkim.subclassingaview;

/**
 * Created by 2016jkim on 10/13/2015.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View{

    public MyView(Context context, AttributeSet attrs){
        super(context, attrs);
        setUpAttributes(attrs);
        setupPaint();
    }
    private int tl;
    private int tr;
    private int bl;
    private int br;
    private Paint paintShape;

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("" + tl, 20, 20, paintShape);
        canvas.drawText(""+tr, 170, 20, paintShape);
        canvas.drawText(""+bl, 20, 170, paintShape);
        canvas.drawText(""+br, 170, 170, paintShape);
    }

    private void setUpAttributes(AttributeSet attrs){
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MyView, 0, 0);
        try {
            tl = a.getInt(R.styleable.MyView_initialValue, 0);
            tr = a.getInt(R.styleable.MyView_initialValue, 0);
            bl = a.getInt(R.styleable.MyView_initialValue, 0);
            br = a.getInt(R.styleable.MyView_initialValue, 0);
        }
        finally {
            a.recycle();
        }
    }

    public void incrementAndUpdate(int iPresser) {

        if(iPresser==1)
            tl++;
        else if(iPresser==2)
            tr++;
        else if(iPresser==3)
            bl++;
        else if(iPresser==4)
            br++;
        postInvalidate();
    }

    private void setupPaint() {
        paintShape = new Paint();
        paintShape.setStyle(Paint.Style.FILL);
        paintShape.setTextSize(25);
    }



}