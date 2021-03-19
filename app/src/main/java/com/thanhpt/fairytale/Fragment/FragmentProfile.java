package com.thanhpt.fairytale.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.thanhpt.fairytale.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentProfile extends Fragment  {
    Spinner countrySpinner, citySpinner;
    String countryString;
    public static FragmentProfile newInstance() {
        FragmentProfile fragment = new FragmentProfile();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile,container,false);
        countrySpinner = (Spinner) view.findViewById(R.id.spinner_country);
        citySpinner = (Spinner ) view.findViewById(R.id.spinner_city);

        List<String> countryList = new ArrayList<>();
        countryList.add("Viet Nam");
        countryList.add("USA");
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.my_spinner_item,countryList);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);



        final List<String> cityList = new ArrayList<>();
        countryString =  countrySpinner.getSelectedItem().toString();

        final ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.my_spinner_item,cityList);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryString =  countrySpinner.getSelectedItem().toString();

                if(countryString.equalsIgnoreCase("Viet Nam")){
                    cityList.clear();
                    cityList.add("Ha Noi");
                    cityList.add("Nghe An");
                    cityList.add("Ha Tinh");
                    cityList.add("Ho Chi Minh");
                    cityList.add("Ca Mau");
                    cityAdapter.notifyDataSetChanged();
                }else if(countryString.equalsIgnoreCase("USA")){
                    cityList.clear();
                    cityList.add("New York");
                    cityList.add("Washington");
                    cityList.add("Chicago");
                    cityAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       return view;
    }


}
