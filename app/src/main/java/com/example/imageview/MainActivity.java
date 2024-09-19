package com.example.imageview;

import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private int gamesPlayed = 0;
    private String[] imageNames = {
            "five_of_clubs", "ten_of_clubs", "seven_of_spades", "two_of_clubs", "nine_of_hearts",
            "ace_of_diamonds", "eight_of_clubs", "four_of_hearts", "ten_of_diamonds",
            "king_of_diamonds", "three_of_hearts", "jack_of_clubs", "queen_of_clubs", "six_of_clubs",
            "four_of_spades", "ten_of_spades", "five_of_hearts", "king_of_clubs", "four_of_diamonds",
            "six_of_spades", "jack_of_diamonds", "three_of_diamonds", "queen_of_hearts", "six_of_diamonds",
            "ace_of_hearts", "five_of_spades", "seven_of_hearts", "ace_of_spades", "nine_of_spades",
            "three_of_clubs", "six_of_hearts", "eight_of_spades", "queen_of_diamonds", "two_of_spades",
            "seven_of_diamonds", "jack_of_spades", "eight_of_diamonds", "king_of_hearts", "two_of_diamonds",
            "queen_of_spades", "eight_of_hearts", "nine_of_diamonds", "three_of_spades", "seven_of_clubs",
            "ten_of_hearts", "jack_of_hearts", "ace_of_clubs", "two_of_hearts", "four_of_clubs",
            "five_of_diamonds", "nine_of_clubs", "king_of_spades"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button randomButton = findViewById(R.id.randomButton);
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamesPlayed++;
                Set<Integer> usedIndices = new HashSet<>();
                for (int i = 1; i <= 5; i++) {
                    int randomIndex;
                    do {
                        randomIndex = (int) (Math.random() * imageNames.length);
                    } while (usedIndices.contains(randomIndex));
                    usedIndices.add(randomIndex);
                    int imageId = getResources().getIdentifier(imageNames[randomIndex], "drawable", getPackageName());
                    BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(imageId);
                    switch (i) {
                        case 1:
                            imageView1.setImageDrawable(drawable);
                            break;
                        case 2:
                            imageView2.setImageDrawable(drawable);
                            break;
                        case 3:
                            imageView3.setImageDrawable(drawable);
                            break;
                        case 4:
                            imageView4.setImageDrawable(drawable);
                            break;
                        case 5:
                            imageView5.setImageDrawable(drawable);
                            break;
                    }
                }
            }
        });
    }
}