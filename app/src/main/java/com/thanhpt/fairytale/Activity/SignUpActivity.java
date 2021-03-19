package com.thanhpt.fairytale.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.thanhpt.fairytale.API.ApiManager;
import com.thanhpt.fairytale.R;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    Button signupbtn;
    TextView skipview;
    TextView skipdialogview;
    AlertDialog alertDialog;
    TextView signinview;
    TextView termconditionview;
    EditText nameEdt, emailEdt, passEdt, confirmPassEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        setContentView(R.layout.activity_signup);
        signupbtn = (Button) findViewById(R.id.signup_button);
        skipview = (TextView) findViewById(R.id.skipview);
        termconditionview = (TextView) findViewById(R.id.term_condition_textview);
        signinview = (TextView) findViewById(R.id.sign_in_textview);
        nameEdt = (EditText) findViewById(R.id.name_signup);
        emailEdt = (EditText) findViewById(R.id.email_signup);
        passEdt = (EditText) findViewById(R.id.password_signup);
        confirmPassEdt = (EditText) findViewById(R.id.confirm_pass_signup);



        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                String name = nameEdt.getText().toString().trim();
                String email = emailEdt.getText().toString().trim();
                String password = passEdt.getText().toString().trim();
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject.put("name", name);
                    jsonObject.put("email", email);
                    jsonObject.put("password", password);
                    jsonObject.put("city_id", 10);
                    jsonObject.put("type", 2);

                }catch (JSONException e){
                }
                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(JSON, jsonObject.toString());

                ApiManager.getInstance().signUpUser(body, new Callback<JsonElement>() {
                    @Override
                    public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                        Log.d("sign up", response.body().toString());

                    }

                    @Override
                    public void onFailure(Call<JsonElement> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this,
                                "Error is " + t.getMessage()
                                , Toast.LENGTH_LONG).show();

                    }
                });






            }
        });

        skipview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainAfterSignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        termconditionview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TermConditionsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signinview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);

            }
        });


    }
    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        builder.setView(layoutInflater.inflate(R.layout.dialog_signup,null));
        alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        skipdialogview = (TextView) alertDialog.findViewById(R.id.skipdialog_view);
        skipdialogview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainAfterSignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button continute = (Button) alertDialog.findViewById(R.id.continute_dialog);
        continute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivedUserActivity.class);
                startActivity(intent);
                //finish();
            }
        });
    }

}
