package com.turkerkizilcik.ykskocum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if(user==null){
            Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        mAuth = FirebaseAuth.getInstance();



        sharedPreferences = this.getSharedPreferences("com.turkerkizilcik.ykskocum", Context.MODE_PRIVATE);

        int pastOrNo = sharedPreferences.getInt("x" , 0);

        if(pastOrNo == 1) {
           // if () {

           // }
        } else {
            Intent intent = new Intent(MainActivity.this, OnboardingActivity.class);
            startActivity(intent);
            System.out.println("seks");
        }





    }

    
}