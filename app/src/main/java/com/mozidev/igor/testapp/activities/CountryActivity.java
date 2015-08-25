package com.mozidev.igor.testapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.mozidev.igor.testapp.R;
import com.mozidev.igor.testapp.fragments.InformationFragment;


/**
 * Created by igor on 19.08.15.
 */
public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        InformationFragment informationFragment = new InformationFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.information_container, informationFragment).commit();
    }
}
