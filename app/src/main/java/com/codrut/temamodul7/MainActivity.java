package com.codrut.temamodul7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codrut.temamodul7.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChallenge1(View view) {
        Intent intent = new Intent(this, TabbedActivity.class);
        startActivity(intent);
    }
}
