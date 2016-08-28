package com.example.volks.nanomusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PopularMusic extends AppCompatActivity {

    boolean playFlag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_music);
        Intent intent = getIntent();
        String genre_provided;


        Button buy_now = (Button) findViewById(R.id.purchase_songs);
        ImageButton dislike = (ImageButton) findViewById(R.id.dislike);
        ImageButton play_pause = (ImageButton) findViewById(R.id.play_pause);
        ImageButton skip = (ImageButton) findViewById(R.id.skip);
        ImageButton like = (ImageButton) findViewById(R.id.like);
        TextView genre = (TextView)findViewById(R.id.pop_genre_here);

        genre_provided = intent.getStringExtra("EXTRA_GENRE");
        if(genre_provided != null) {
            genre.setText(genre_provided);
        }

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buySongs = new Intent(PopularMusic.this, PurchaseMusic.class);
                TextView title = (TextView) findViewById(R.id.pop_title_here);
                TextView artist = (TextView) findViewById(R.id.pop_artist_here);
                Intent getGenre = getIntent();
                String title_song = title.getText().toString();
                String artist_song = artist.getText().toString();
                String genre_song = getGenre.getStringExtra("EXTRA_GENRE");
                buySongs.putExtra("SONG_TITLE_EXTRA",title_song);
                buySongs.putExtra("SONG_ARTIST_EXTRA", artist_song);
                buySongs.putExtra("SONG_GENRE_EXTRA", genre_song);
                startActivity(buySongs);
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), R.string.dislike_dummy_text, Toast.LENGTH_SHORT).show();
            }
        });

        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(playFlag)
                {
                    Toast.makeText(getApplicationContext(), R.string.pause_dummy_text, Toast.LENGTH_SHORT).show();
                    playFlag = false;
                }
                else
                {
                    Toast.makeText(getApplicationContext(), R.string.play_dummy_text, Toast.LENGTH_SHORT).show();
                    playFlag = true;
                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), R.string.skip_dummy_text, Toast.LENGTH_SHORT).show();
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), R.string.like_dummy_text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
