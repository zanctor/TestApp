package com.mozidev.igor.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by igor on 19.08.15.
 */
public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText((String)getIntent().getExtras().get(MainActivity.EXTRA_COUNTRY_NAME));
        Button returnButton = (Button)findViewById(R.id.returnButton);
        Button deleteButton = (Button)findViewById(R.id.deleteButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(MainActivity.RESULT_CODE, getIntent());
                finish();
            }
        });
    }
}
