package com.mozidev.igor.testapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.mozidev.igor.testapp.R;
import com.mozidev.igor.testapp.fragments.CountryFragment;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_DELETE = 8001;
    public static final int RESULT_CODE = 8002;
    public static final String EXTRA_COUNTRY_POSITION = "extra_country_position";
    public static final String EXTRA_COUNTRY_NAME = "extra_country_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountryFragment countryFragment = new CountryFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, countryFragment).commit();
    }
}
