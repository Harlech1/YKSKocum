package com.turkerkizilcik.ykskocum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.turkerkizilcik.ykskocum.databinding.ActivityMainscreenBinding;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;

    FirebaseDatabase database;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        //database = FirebaseDatabase.getInstance("https://ykskocum-7ba62-default-rtdb.firebaseio.com/");
        //databaseReference = database.getReference("Chats");


        sharedPreferences = this.getSharedPreferences("com.turkerkizilcik.ykskocum", Context.MODE_PRIVATE);

        int pastOrNo = sharedPreferences.getInt("x" , 0);
        int nameExists = sharedPreferences.getInt("y", 0);

        if(pastOrNo == 1) {
            if (user == null || nameExists != 1) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        } else {
            Intent intent = new Intent(MainActivity.this, OnboardingActivity.class);
            startActivity(intent);
        }

    }

    public void doShit (View view) {
        //databaseReference.child("Profiles").child()

        //databaseReference.setValue("hey");
    }



}