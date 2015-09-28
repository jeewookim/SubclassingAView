package com.example.a2016jkim.subclassingaview;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyTextView view1 = (MyTextView)findViewById(R.id.topLeft);
        view1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               view1.incrementAndUpdate();

            }
        });

        final MyTextView view2 = (MyTextView)findViewById(R.id.bottomLeft);
        view2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               view2.incrementAndUpdate();
            }
        });

        final MyTextView view3 = (MyTextView)findViewById(R.id.topRight);
        view3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                    view3.incrementAndUpdate();


            }
        });

        final MyTextView view4 = (MyTextView)findViewById(R.id.bottomRight);
        view4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               view4.incrementAndUpdate();
            }
        });

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
}
