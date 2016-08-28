package com.example.volks.nanomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PurchaseMusic extends AppCompatActivity {

    boolean clickedFlag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_music);

        TextView songDetails = (TextView) findViewById(R.id.song_detail);
        Intent extras = getIntent();
        StringBuilder detailsBuilder = new StringBuilder(256);
        detailsBuilder.append(extras.getStringExtra("SONG_TITLE_EXTRA"));
        detailsBuilder.append(" By: ");
        detailsBuilder.append(extras.getStringExtra("SONG_ARTIST_EXTRA"));
        detailsBuilder.append(" In Category: ");
        detailsBuilder.append(extras.getStringExtra("SONG_GENRE_EXTRA"));
        songDetails.setText(detailsBuilder.toString());
        final Button buyMeNow = (Button) findViewById(R.id.purchase_this);

        buyMeNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), R.string.song_bought, Toast.LENGTH_LONG).show();
                buyMeNow.setClickable(false);
                buyMeNow.setEnabled(false);
                buyMeNow.setText(R.string.disabled_button_text);
            }
        });

    }
}
