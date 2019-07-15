package com.deleir.alc_1_challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class ActivityC extends AppCompatActivity {
    private ProgressBar mProgressLoading;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Toolbar myToolbar = findViewById(R.id.my_toolbar2);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle(getString(R.string.my_profile));

        myToolbar.setTitleTextColor(getResources().getColor(R.color.toolbarText));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.my_pic);
    }
}
