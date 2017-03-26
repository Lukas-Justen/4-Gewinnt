package de.thbingen.hiwi.lukas.th4_gewinnt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.buttonStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent startIntent = new Intent(this,MainActivity.class);
        startActivity(startIntent);
    }
}
