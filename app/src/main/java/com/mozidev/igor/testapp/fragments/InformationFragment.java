package com.mozidev.igor.testapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.mozidev.igor.testapp.R;
import com.mozidev.igor.testapp.activities.MainActivity;

/**
 * Created by igor on 25.08.15.
 */
public class InformationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_information, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = (TextView)view.findViewById(R.id.textView);
        tv.setText((String) getActivity().getIntent().getExtras().get(MainActivity.EXTRA_COUNTRY_NAME));
        Button returnButton = (Button)view.findViewById(R.id.returnButton);
        Button deleteButton = (Button)view.findViewById(R.id.deleteButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().setResult(MainActivity.RESULT_CODE, getActivity().getIntent());
                getActivity().finish();
            }
        });
    }
}
