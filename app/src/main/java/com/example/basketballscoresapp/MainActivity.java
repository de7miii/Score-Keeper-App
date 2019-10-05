package com.example.basketballscoresapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Team homeTeam;
    private Team awayTeam;
//    private TextView qrtrTime;
//    private TextView shotClk;
    private TextView homeScore;
    private TextView awayScore;
    private TextView homeFouls;
    private TextView awayFouls;
//    private TextView firstQrtr;
//    private TextView secondQrtr;
//    private TextView thirdQrtr;
//    private TextView fourthQrtr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        qrtrTime = findViewById(R.id.quarter_time_text);
//        shotClk = findViewById(R.id.shot_clock_text);
        homeScore = findViewById(R.id.home_team_score);
        awayScore = findViewById(R.id.away_team_score);
        homeFouls = findViewById(R.id.home_team_fouls);
        awayFouls = findViewById(R.id.away_team_fouls);
//        firstQrtr = findViewById(R.id.first_qrtr_text);
//        secondQrtr = findViewById(R.id.second_qrtr_text);
//        thirdQrtr = findViewById(R.id.third_qrtr_text);
//        fourthQrtr = findViewById(R.id.fourth_qrtr_text);
        Button twoPointHomeBtn = findViewById(R.id.two_point_home_btn);
        Button threePointHomeBtn = findViewById(R.id.three_point_home_btn);
        Button freeThrowHomeBtn = findViewById(R.id.free_throw_home_btn);
        Button foulHomeBtn = findViewById(R.id.foul_home_btn);
        Button twoPointAwayBtn = findViewById(R.id.two_point_away_btn);
        Button threePointAwayBtn = findViewById(R.id.three_point_away_btn);
        Button freeThrowAwayBtn = findViewById(R.id.free_throw_away_btn);
        Button foulAwayBtn = findViewById(R.id.foul_away_btn);
        Button resetBtn = findViewById(R.id.reset_btn);

        initilizeData();

        twoPointHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHomeTeamScore(2);
            }
        });
        threePointHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHomeTeamScore(3);
            }
        });
        freeThrowHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHomeTeamScore(1);
            }
        });
        foulHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeTeam.commitFoul();
                homeFouls.setText(Integer.toString(homeTeam.getFouls()));
            }
        });

        twoPointAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAwayTeamScore(2);
            }
        });
        threePointAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAwayTeamScore(3);
            }
        });
        freeThrowAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAwayTeamScore(1);
            }
        });
        foulAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awayTeam.commitFoul();
                awayFouls.setText(Integer.toString(awayTeam.getFouls()));
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    private void initilizeData(){
        homeTeam = new Team("Home");
        awayTeam = new Team("Away");
    }

    private void updateHomeTeamScore(int points){
        // TODO: 10/3/2019 update the home team score according to the button clicked
        homeTeam.scorePoints(points);
        homeScore.setText(Integer.toString(homeTeam.getScore()));
    }

    private void updateAwayTeamScore(int points){
        // TODO: 10/3/2019 update the away team score according to the button clicked
        awayTeam.scorePoints(points);
        awayScore.setText(Integer.toString(awayTeam.getScore()));
    }
    private void reset(){
        // TODO: 10/3/2019 reset the game score, fouls, and clock
        homeTeam.setScore(0);
        homeScore.setText(Integer.toString(homeTeam.getScore()));
        homeTeam.setFouls(0);
        homeFouls.setText(Integer.toString(homeTeam.getFouls()));
        awayTeam.setScore(0);
        awayScore.setText(Integer.toString(awayTeam.getScore()));
        awayTeam.setFouls(0);
        awayFouls.setText(Integer.toString(awayTeam.getFouls()));
    }
}
