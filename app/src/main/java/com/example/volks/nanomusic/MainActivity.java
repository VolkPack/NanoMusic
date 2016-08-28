package com.example.volks.nanomusic;

import android.content.Intent;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button discover = (Button) findViewById(R.id.discover_button);
        Button popular = (Button) findViewById(R.id.po_button_button);
        Button purchased = (Button) findViewById(R.id.purchased);

        discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Spinner list = (Spinner) findViewById(R.id.genere_select);
                if(list.getSelectedItem().toString().contains("Select Genre"))
                {
                    Toast.makeText(getApplicationContext(), R.string.select_genre_toast, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent discoverMusic = new Intent(MainActivity.this, DiscoverMusic.class);
                    discoverMusic.putExtra("TO_SEND_GENRE", list.getSelectedItem().toString());
                    startActivity(discoverMusic);
                }

            }
        });

        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner list = (Spinner) findViewById(R.id.genere_select);
                if(list.getSelectedItem().toString().contains("Select Genre"))
                {
                    Toast.makeText(getApplicationContext(), R.string.select_genre_toast, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent popularMusic = new Intent(MainActivity.this, PopularMusic.class);
                    popularMusic.putExtra("EXTRA_GENRE", list.getSelectedItem().toString());
                    startActivity(popularMusic);
                }
            }
        });

        purchased.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                    Intent purcahsedSongs = new Intent(MainActivity.this, OwnedMusic.class);
                    startActivity(purcahsedSongs);
            }
        });
    }


}
