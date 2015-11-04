package com.example.a2016jkim.subclassingaview;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private MyView view1;
    private MyView view2;
    private MyView view3;
    private MyView view4;
    private int press;
    private int x;
    private int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = (MyView)findViewById(R.id.top_left);
        view1.setOnTouchListener(this);

        view2 = (MyView)findViewById(R.id.top_right);
        view2.setOnTouchListener(this);

        view3 = (MyView)findViewById(R.id.bottom_left);
        view3.setOnTouchListener(this);

        view4 = (MyView)findViewById(R.id.bottom_right);
        view4.setOnTouchListener(this);

        Button newapp = (Button) findViewById(R.id.goback);
        newapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.a2016jkim.activitylifecycle");
                startActivity(launchIntent);
            }
        }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (v==view1)
                press = 1;
            else if (v==view2)
                press = 2;
            else if (v==view3)
                press = 3;
            else if(v==view4)
                press = 4;
            return true;
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {

            Rect rectCaller = new Rect();
            v.getHitRect(rectCaller);

            int xOffset = rectCaller.left;
            int yOffset = rectCaller.top;

            x = (int) event.getX() + xOffset;
            y = (int) event.getY()+ yOffset;

            Rect rect1 = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();

            view1.getHitRect(rect1);
            view2.getHitRect(rect2);
            view3.getHitRect(rect3);
            view4.getHitRect(rect4);

            if (rect1.contains(x,y))
                view1.incrementAndUpdate(press);
            else if (rect2.contains(x,y))
                view2.incrementAndUpdate(press);
            else if (rect3.contains(x,y))
                view3.incrementAndUpdate(press);
            else if(rect4.contains(x,y))
                view4.incrementAndUpdate(press);

            return false;
        }
        return true;
    }

}