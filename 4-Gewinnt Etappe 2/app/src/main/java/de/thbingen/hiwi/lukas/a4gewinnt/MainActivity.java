package de.thbingen.hiwi.lukas.a4gewinnt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout[] unsereLayouts = new LinearLayout[7];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unsereLayouts[0] = (LinearLayout) findViewById(R.id.spalte1);
        unsereLayouts[1] = (LinearLayout) findViewById(R.id.spalte2);
        unsereLayouts[2] = (LinearLayout) findViewById(R.id.spalte3);
        unsereLayouts[3] = (LinearLayout) findViewById(R.id.spalte4);
        unsereLayouts[4] = (LinearLayout) findViewById(R.id.spalte5);
        unsereLayouts[5] = (LinearLayout) findViewById(R.id.spalte6);
        unsereLayouts[6] = (LinearLayout) findViewById(R.id.spalte7);


    }

}
