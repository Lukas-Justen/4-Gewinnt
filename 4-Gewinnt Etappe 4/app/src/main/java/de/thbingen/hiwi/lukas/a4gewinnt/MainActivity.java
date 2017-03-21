package de.thbingen.hiwi.lukas.a4gewinnt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout[] linearLayouts = new LinearLayout[7];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayouts[0] = (LinearLayout) findViewById(R.id.linearLayout1);
        linearLayouts[1] = (LinearLayout) findViewById(R.id.linearLayout2);
        linearLayouts[2] = (LinearLayout) findViewById(R.id.linearLayout3);
        linearLayouts[3] = (LinearLayout) findViewById(R.id.linearLayout4);
        linearLayouts[4] = (LinearLayout) findViewById(R.id.linearLayout5);
        linearLayouts[5] = (LinearLayout) findViewById(R.id.linearLayout6);
        linearLayouts[6] = (LinearLayout) findViewById(R.id.linearLayout7);

        for (int j = 0; j < linearLayouts.length; j++) {
            for (int i = 0; i<6;i++) {
                ImageView image = new ImageView(this);
                image.setImageDrawable(getResources().getDrawable(R.drawable.field));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
                linearLayouts[j].addView(image, params);
            }
        }
    }
}
