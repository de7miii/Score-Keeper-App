package com.example.basketballscoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int INITIAL_QRTR_TIME = 720000; // 12 minutes
    private final int INITIAL_SHOT_CLOCK_TIME = 24000; // 24 seconds

    private Team homeTeam;
    private Team awayTeam;
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
    private Button mStartPauseBtn;

    private CountDownTimer qrtrTimeTimer;
    private int currentQrtr = 1;

    private CountDownTimer shotClockTimer;

    private boolean isStarted = false;

    private int mShotClockTimeLeftInMilli = INITIAL_SHOT_CLOCK_TIME;
    private int mQrtrTimeLeftInMilli = INITIAL_QRTR_TIME;

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
        Button twoPointHomeBtn = findViewById(R.id.two_point_home_btn);
        Button threePointHomeBtn = findViewById(R.id.three_point_home_btn);
        Button freeThrowHomeBtn = findViewById(R.id.free_throw_home_btn);
        Button foulHomeBtn = findViewById(R.id.foul_home_btn);
        Button twoPointAwayBtn = findViewById(R.id.two_point_away_btn);
        Button threePointAwayBtn = findViewById(R.id.three_point_away_btn);
        Button freeThrowAwayBtn = findViewById(R.id.free_throw_away_btn);
        Button foulAwayBtn = findViewById(R.id.foul_away_btn);
        mStartPauseBtn = findViewById(R.id.start_btn);
        Button resetBtn = findViewById(R.id.reset_btn);

        initializeData();

        twoPointHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateHomeTeamScore(2);
            }
        });
        threePointHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateHomeTeamScore(3);
            }
        });
        freeThrowHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateHomeTeamScore(1);
            }
        });
        foulHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateHomeTeamFouls(1);
            }
        });

        twoPointAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateAwayTeamScore(2);
            }
        });
        threePointAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateAwayTeamScore(3);
            }
        });
        freeThrowAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateAwayTeamScore(1);
            }
        });
        foulAwayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarted)
                updateAwayTeamFouls(1);
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        updateQrtrText(currentQrtr);

        // Change millisInFuture (the first argument in CountDownTimer() ) to 5000 (5s) for testing.

        mStartPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isStarted){
                    startTimers();
                }else{
                    pauseTimers();
                }
            }
        });
    }

    public void updateQrtrText(int qrtr){
        switch (qrtr){
            case 1:
                firstQrtr.setTextColor(Color.RED);
                secondQrtr.setTextColor(Color.BLACK);
                thirdQrtr.setTextColor(Color.BLACK);
                fourthQrtr.setTextColor(Color.BLACK);
                break;
            case 2:
                firstQrtr.setTextColor(Color.BLACK);
                secondQrtr.setTextColor(Color.RED);
                thirdQrtr.setTextColor(Color.BLACK);
                fourthQrtr.setTextColor(Color.BLACK);
                break;
            case 3:
                firstQrtr.setTextColor(Color.BLACK);
                secondQrtr.setTextColor(Color.BLACK);
                thirdQrtr.setTextColor(Color.RED);
                fourthQrtr.setTextColor(Color.BLACK);
                break;
            case 4:
                firstQrtr.setTextColor(Color.BLACK);
                secondQrtr.setTextColor(Color.BLACK);
                thirdQrtr.setTextColor(Color.BLACK);
                fourthQrtr.setTextColor(Color.RED);
                break;
            default:
                firstQrtr.setTextColor(Color.BLACK);
                secondQrtr.setTextColor(Color.BLACK);
                thirdQrtr.setTextColor(Color.BLACK);
                fourthQrtr.setTextColor(Color.BLACK);
                break;
        }
    }


    private void initializeData(){
        homeTeam = new Team("Home");
        awayTeam = new Team("Away");
    }

    private void updateHomeTeamScore(int points){
        if (points == 0){
            homeTeam.setScore(0);
        }else {
            homeTeam.scorePoints(points);
        }
        StringBuilder score = new StringBuilder();
        score.append(homeTeam.getScore());
        homeScore.setText(score);
    }

    private void updateAwayTeamScore(int points){
        if (points == 0){
            awayTeam.setScore(0);
        }else {
            awayTeam.scorePoints(points);
        }
        StringBuilder score = new StringBuilder();
        score.append(awayTeam.getScore());
        awayScore.setText(score);
    }

    private void updateHomeTeamFouls(int foulPoint){
        if (foulPoint == 0){
            homeTeam.setFouls(0);
        }else{
            homeTeam.commitFoul();
        }
        StringBuilder foulsString = new StringBuilder();
        foulsString.append(homeTeam.getFouls());
        homeFouls.setText(foulsString);
    }

    private void updateAwayTeamFouls(int foulPoint){
        if (foulPoint == 0){
            awayTeam.setFouls(0);
        }else{
            awayTeam.commitFoul();
        }
        StringBuilder foulsString = new StringBuilder();
        foulsString.append(awayTeam.getFouls());
        awayFouls.setText(foulsString);
    }

    private void startTimers(){
        isStarted = true;
        mStartPauseBtn.setText(R.string.pause_btn_text);
        qrtrTimeTimer = new CountDownTimer(mQrtrTimeLeftInMilli,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mQrtrTimeLeftInMilli = (int) millisUntilFinished;
                updateQrtrTimeTimerText();
            }

            @Override
            public void onFinish() {
                if (currentQrtr < 4){
                    currentQrtr += 1;
                    updateQrtrText(currentQrtr);
                    start();
                }else{
                    reset();
                }
            }
        }.start();

        shotClockTimer = new CountDownTimer(mShotClockTimeLeftInMilli, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mShotClockTimeLeftInMilli = (int) millisUntilFinished;
                updateShotClockTimerText();
            }

            @Override
            public void onFinish() {
                start();
            }
        }.start();
    }

    private void pauseTimers(){
        isStarted = false;
        mStartPauseBtn.setText(R.string.start_btn_text);
        qrtrTimeTimer.cancel();
        shotClockTimer.cancel();
    }

    private void updateShotClockTimerText(){
        int shotClockSeconds = mShotClockTimeLeftInMilli /1000;
        StringBuilder time = new StringBuilder();
        time.append(":");
        if (shotClockSeconds < 10){
            time.append(0);
            time.append(shotClockSeconds);
        }else{
            time.append(shotClockSeconds);
        }
        shotClk.setText(time);
    }

    private void updateQrtrTimeTimerText(){
        int minutes = mQrtrTimeLeftInMilli/60000 ;
        int seconds = mQrtrTimeLeftInMilli%60000/1000;
        StringBuilder time = new StringBuilder();
        time.append(minutes);
        time.append(":");
        if (seconds<10){
            time.append(0);
            time.append(seconds);
        }else{
            time.append(seconds);
        }
        qrtrTime.setText(time);
    }

    private void reset(){
        isStarted = false;
        updateHomeTeamScore(0);
        updateHomeTeamFouls(0);
        updateAwayTeamScore(0);
        updateAwayTeamFouls(0);
        currentQrtr = 1;
        updateQrtrText(currentQrtr);
        qrtrTimeTimer.cancel();
        mQrtrTimeLeftInMilli = INITIAL_QRTR_TIME;
        updateQrtrTimeTimerText();
        shotClockTimer.cancel();
        mShotClockTimeLeftInMilli = INITIAL_SHOT_CLOCK_TIME;
        updateShotClockTimerText();
        mStartPauseBtn.setText(R.string.start_btn_text);
    }
}
