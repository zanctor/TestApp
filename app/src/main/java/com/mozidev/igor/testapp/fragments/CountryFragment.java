package com.mozidev.igor.testapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.mozidev.igor.testapp.R;
import com.mozidev.igor.testapp.SimpleListAdapter;
import com.mozidev.igor.testapp.activities.CountryActivity;
import com.mozidev.igor.testapp.activities.MainActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by igor on 25.08.15.
 */
public class CountryFragment extends Fragment {

    private ListView lw;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lw = (ListView)view.findViewById(R.id.listView);
        final Intent i = new Intent(getActivity(), CountryActivity.class);
        lw.setAdapter(new SimpleListAdapter(getActivity(), R.layout.item_country, getCountries()));
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra(MainActivity.EXTRA_COUNTRY_POSITION, position);
                i.putExtra(MainActivity.EXTRA_COUNTRY_NAME, ((SimpleListAdapter) lw.getAdapter()).getItem(position));
                startActivityForResult(i, MainActivity.REQUEST_CODE_DELETE);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == MainActivity.RESULT_CODE && requestCode == MainActivity.REQUEST_CODE_DELETE) {
            ((SimpleListAdapter)lw.getAdapter()).removeItem(data.getExtras().getInt(MainActivity.EXTRA_COUNTRY_POSITION));
        }
    }

    //getting the list of all the countries
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
