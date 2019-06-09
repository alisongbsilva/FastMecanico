package com.example.fastmecanico;

import android.app.Application;

import com.google.firebase.firestore.FirebaseFirestore;

public class AppStarter extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }
}