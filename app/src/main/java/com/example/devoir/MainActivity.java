package com.example.devoir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.internal.ThemeEnforcement;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;
    private EditText ed2;
    private Button btn;

    //Life Cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.editTextTextPersonName);
        ed2=(EditText) findViewById(R.id.editTextTextPassword);
        btn=(Button) findViewById(R.id.button);



        //listener
        btn.setOnClickListener(v -> {
            loginAction(ed1.getText().toString(), ed2.getText().toString());
        });
    }


    //Actions
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

    public void setupUI(View view) {


        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(MainActivity.this);
                    return false;
                }
            });
        }


        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    //..

    void loginAction(String username, String password){
        if(password.equals("123456")){

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();

        }else {

            Toast.makeText(this, "Veuillez verifier votre mot de passe !", Toast.LENGTH_SHORT).show();

        }
    }



}