package de.thbingen.hiwi.lukas.a4gewinnt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Lukas Justen on 17.03.2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout[] linearLayouts = new LinearLayout[7];
    private ImageView[][] imageViews = new ImageView[7][6];
    private Game game = new Game();

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

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6; i++) {
                ImageView image = new ImageView(this);
                image.setImageDrawable(getResources().getDrawable(R.drawable.field));
                imageViews[j][i] = image;
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
                linearLayouts[j].addView(image, params);
            }
            linearLayouts[j].setTag(j);
            linearLayouts[j].setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        LinearLayout linearLayout = (LinearLayout) view;

        int column = (Integer) linearLayout.getTag();
        int row = game.insert(column);

        if (row >= 0) {
            if (game.getPlayerTurn() == Game.Player.P1) {
                imageViews[column][row].setImageDrawable(getResources().getDrawable(R.drawable.stone_red));
            } else {
                imageViews[column][row].setImageDrawable(getResources().getDrawable(R.drawable.stone_yellow));
            }

            if (game.checkWin()) {
                Toast.makeText(this, "Spieler " + game.getPlayerTurn().name() + " hat gewonnen", Toast.LENGTH_LONG).show();
                finish();
            }

            game.nextPlayer();
        }
    }

}
