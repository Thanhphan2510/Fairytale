package com.thanhpt.fairytale.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.thanhpt.fairytale.API.ApiManager;
import com.thanhpt.fairytale.API.MainApplication;
import com.thanhpt.fairytale.Activity.ForgotPassActivity;
import com.thanhpt.fairytale.Activity.MainAfterSignupActivity;
import com.thanhpt.fairytale.Item.User;
import com.thanhpt.fairytale.R;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    TextView skipview, forgotpassview;
    EditText nameedt, passedt;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_signin);
        skipview = (TextView) findViewById(R.id.skipview);
        signin = (Button) findViewById(R.id.signin_button);
        forgotpassview = (TextView) findViewById(R.id.forgotpass_textview);
        nameedt = (EditText) findViewById(R.id.name_signin);
        passedt = (EditText) findViewById(R.id.password_signin);

        skipview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(getApplicationContext(),MainAfterSignupActivity.class);
//                startActivity(intent);
//                finish();
                String username = nameedt.getText().toString().trim();
                String password = passedt.getText().toString().trim();
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("email", username);
                    jsonObject.put("password", password);
                    jsonObject.put("platform", "");
                }catch (JSONException e){

                }
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
                Log.d("asd",jsonObject.toString());
                ApiManager.getInstance().loginUser(body, new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        Log.d("thanh", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {
                        Toast.makeText(SignInActivity.this,
                                "Error is " + t.getMessage()
                                , Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        forgotpassview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ForgotPassActivity.class);
                startActivity(intent);

            }
        });



    }
}
