package com.mozidev.igor.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.*;

public class MainActivity extends Activity {

    public static final int REQUEST_CODE_DELETE = 8001;
    public static final int RESULT_CODE = 8002;
    public static final String EXTRA_COUNTRY_POSITION = "extra_country_position";
    public static final String EXTRA_COUNTRY_NAME = "extra_country_name";

    ListView lw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent i = new Intent(this, CountryActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lw = (ListView)findViewById(R.id.listView);
        lw.setAdapter(new SimpleListAdapter(this, R.layout.item_country, getCountries()));
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra(EXTRA_COUNTRY_POSITION, position);
                i.putExtra(EXTRA_COUNTRY_NAME, ((SimpleListAdapter)lw.getAdapter()).getItem(position));
                startActivityForResult(i, REQUEST_CODE_DELETE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CODE && requestCode == REQUEST_CODE_DELETE) {
            ((SimpleListAdapter)lw.getAdapter()).removeItem(data.getExtras().getInt(EXTRA_COUNTRY_POSITION));
        }
    }

    private List<String> getCountries(){
        ArrayList<String> countries = new ArrayList<>();
        String[] isoCountryCodes = Locale.getISOCountries();
        for (String countryCode : isoCountryCodes) {
            Locale locale = new Locale("", countryCode);
            String countryName = locale.getDisplayCountry();
            countries.add(countryName);
        }
        Collections.sort(countries);
        return countries;
    }
}
