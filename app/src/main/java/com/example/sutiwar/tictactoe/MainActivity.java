package com.example.sutiwar.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

        // 0=circle and 1= cross;
        int activePlayer = 0;


        //game memory state
        //2 = clear state

    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},
            {1,4,7},{2,5,8},{3,4,5},{0,4,8},
            {2,4,6}};

    public void dropIn(View view){

        ImageView counter = (ImageView)view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
       /**
        * -------------------placing images according to active player----------------------
         */
        if(gamestate[tappedCounter] == 2) {

            gamestate[tappedCounter] = activePlayer;
            //circle lai hatauna;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                //imageset;
                counter.setImageResource(R.drawable.circle);
                activePlayer = 1;
            }
            else {
                //arko image lyauna
                counter.setImageResource(R.drawable.cross);
                activePlayer = 0;

            }
            counter.animate().translationYBy(1000f).rotation(180).setDuration(300);
        }
            /**
             * ---------------Checking for winning player !!-----------------
             */

        for (int[] winningPosition:winningPositions)
        {
                    if((gamestate[winningPosition[0]] == gamestate[winningPosition[1]])
                      && (gamestate[winningPosition[1]] == gamestate[winningPosition[2]])
                      && (gamestate[winningPosition[0]]!=2))
            {
                System.out.println(gamestate[winningPosition[0]]);
            }
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
