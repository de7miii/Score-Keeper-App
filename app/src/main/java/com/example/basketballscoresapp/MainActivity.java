package com.example.basketballscoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView qrtrTime;
    private TextView shotClk;
    private TextView homeScore;
    private TextView awayScore;
    private TextView homeFouls;
    private TextView awayFouls;
    private TextView firstQrtr;
    private TextView secondQrtr;
    private TextView thirdQrtr;
    private TextView fourthQrtr;
    private Button twoPointHomeBtn;
    private Button threePointHomeBtn;
    private Button freeThrowHomeBtn;
    private Button foulHomeBtn;
    private Button twoPointAwayBtn;
    private Button threePointAwayBtn;
    private Button freeThrowAwayBtn;
    private Button foulAwayBtn;
    private Button resetBtn;
    private int homeTeamScore = 0;
    private int homeTeamFouls = 0;
    private int awayTeamScore = 0;
    private int awayTeamFouls = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qrtrTime = findViewById(R.id.quarter_time_text);
        shotClk = findViewById(R.id.shot_clock_text);
        homeScore = findViewById(R.id.home_team_score);
        awayScore = findViewById(R.id.away_team_score);
        homeFouls = findViewById(R.id.home_team_fouls);
        awayFouls = findViewById(R.id.away_team_fouls);
        firstQrtr = findViewById(R.id.first_qrtr_text);
        secondQrtr = findViewById(R.id.second_qrtr_text);
        thirdQrtr = findViewById(R.id.third_qrtr_text);
        fourthQrtr = findViewById(R.id.fourth_qrtr_text);
        twoPointHomeBtn = findViewById(R.id.two_point_home_btn);
        threePointHomeBtn = findViewById(R.id.three_point_home_btn);
        freeThrowHomeBtn = findViewById(R.id.free_throw_home_btn);
        foulHomeBtn = findViewById(R.id.foul_home_btn);
        twoPointAwayBtn = findViewById(R.id.two_point_away_btn);
        threePointAwayBtn = findViewById(R.id.three_point_away_btn);
        freeThrowAwayBtn = findViewById(R.id.free_throw_away_btn);
        foulAwayBtn = findViewById(R.id.foul_away_btn);
        resetBtn = findViewById(R.id.reset_btn);
    }

    private void updateShotClock(){
        // TODO: 10/3/2019 update the shot clock text and reset it every 24s or when a shot is taken
    }
    private void updateQrtrTimeClock(){
        // TODO: 10/3/2019 update the quarter 12 minute timer in sync with the shot clock
    }
    private void updateCurrentQrtr(){
        // TODO: 10/3/2019 update the selected quarter every 12 minutes
    }
    private void updateHomeTeamScore(int points){
        // TODO: 10/3/2019 update the home team score according to the button clicked
    }
    private void updateHomeTeamFouls(){
        // TODO: 10/3/2019 update home team fouls counter and every foul after the 5th fouls count as 2 free throws
    }
    private void updateAwayTeamScore(int points){
        // TODO: 10/3/2019 update the away team score according to the button clicked
    }
    private void updateAwayTeamFouls(){
        // TODO: 10/3/2019 update away team fouls counter and every foul after the 5th fouls count as 2 free throws
    }
    private void reset(){
        // TODO: 10/3/2019 reset the game score, fouls, and clock
    }
}
