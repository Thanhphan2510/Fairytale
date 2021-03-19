package com.thanhpt.fairytale.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.thanhpt.fairytale.API.ApiManager;
import com.thanhpt.fairytale.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivedUserActivity extends AppCompatActivity {
    Spinner countrySpinner, citySpinner;
    String countryString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_actived_user);
        countrySpinner = (Spinner) findViewById(R.id.spinner_country_actived_user);
        citySpinner = (Spinner ) findViewById(R.id.spinner_city_actived_user);

       ApiManager.getInstance().getCoutry(new Callback<JsonElement>() {
           @Override
           public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
               if (response.isSuccessful()) {
                   if (response.body() != null) {
                       Log.i("onSuccess", response.body().toString());
                       String jsonresponse = response.body().toString();
                       addCoutry(jsonresponse);
//                        JsonObject body = response.body().getAsJsonObject();
//                       JsonArray data = body.get("data").getAsJsonArray();
//                       int status = body.get("status").getAsInt();
                   } else {
                       Log.i("onEmptyResponse", "Returned empty response");
                       }
               }
           }

           @Override
           public void onFailure(Call<JsonElement> call, Throwable t) {
               Toast.makeText(ActivedUserActivity.this,
                       "Error is " + t.getMessage()
                       , Toast.LENGTH_LONG).show();

           }
       });


//
//        final List<String> cityList = new ArrayList<>();
//        countryString =  countrySpinner.getSelectedItem().toString();
//
//        final ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(this, R.layout.my_spinner_item,cityList);
//        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        citySpinner.setAdapter(cityAdapter);
//        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                countryString =  countrySpinner.getSelectedItem().toString();
//
//                if(countryString.equalsIgnoreCase("Viet Nam")){
//                    cityList.clear();
//                    cityList.add("Ha Noi");
//                    cityList.add("Nghe An");
//                    cityList.add("Ha Tinh");
//                    cityList.add("Ho Chi Minh");
//                    cityList.add("Ca Mau");
//                    cityAdapter.notifyDataSetChanged();
//                }else if(countryString.equalsIgnoreCase("USA")){
//                    cityList.clear();
//                    cityList.add("New York");
//                    cityList.add("Washington");
//                    cityList.add("Chicago");
//                    cityAdapter.notifyDataSetChanged();
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("country_id",10);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType,jsonObject.toString());

        ApiManager.getInstance().getCityByCountry( new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
             //   Log.d("city_phan",response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
  }

    private void addCoutry(String response){

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            if(obj.optString("status").equals("200")){

                ArrayList<String> retroModelArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    retroModelArrayList.add(dataobj.getString("country_name"));

                }

                ArrayAdapter<String> countryAdapter
                        = new ArrayAdapter<String>(this, R.layout.my_spinner_item,retroModelArrayList);

                countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                countrySpinner.setAdapter(countryAdapter);
            }else {
                Toast.makeText(ActivedUserActivity.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void addAllCity(String response){
        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            if(obj.optString("status").equals("200")){

                ArrayList<String> retroModelArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    retroModelArrayList.add(dataobj.getString("country_name"));

                }

                ArrayAdapter<String> countryAdapter
                        = new ArrayAdapter<String>(this, R.layout.my_spinner_item,retroModelArrayList);

                countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                countrySpinner.setAdapter(countryAdapter);
            }else {
                Toast.makeText(ActivedUserActivity.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
