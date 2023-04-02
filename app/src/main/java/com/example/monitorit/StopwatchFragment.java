package com.example.monitorit;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Locale;

public class StopwatchFragment extends Fragment {

    private TextView mTextView;
    private ImageView mStartImage, mPauseImage, mResetImage;

    private Handler mHandler = new Handler();
    private boolean mTimerRunning;
    private long mStartTime, mTimeElapsed;

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mTimeElapsed = System.currentTimeMillis() - mStartTime;
            updateTimer(mTimeElapsed);
            mHandler.postDelayed(this, 1000);
        }
    };
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        mTextView = view.findViewById(R.id.textView);
        mStartImage = view.findViewById(R.id.start);
        mPauseImage = view.findViewById(R.id.pause);
        mResetImage = view.findViewById(R.id.reset);

        mStartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        mPauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });

        mResetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        return view;
    }

    private void startTimer() {
        if (!mTimerRunning) {
            mStartTime = System.currentTimeMillis();
            mHandler.post(mRunnable);
            mTimerRunning = true;
        }
    }

    private void pauseTimer() {
        if (mTimerRunning) {
            mHandler.removeCallbacks(mRunnable);
            mTimeElapsed = System.currentTimeMillis() - mStartTime;
            updateTimer(mTimeElapsed);
            mTimerRunning = false;
        }
    }

    private void resetTimer() {
        mHandler.removeCallbacks(mRunnable);
        mTimeElapsed = 0;
        updateTimer(mTimeElapsed);
        mTimerRunning = false;
    }

    private void updateTimer(long timeElapsed) {
        int seconds = (int) (timeElapsed / 1000);
        int minutes = seconds / 60;
        int hours = minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;

        String time = String.format(Locale.getDefault(), "%d : %02d : %02d", hours, minutes, seconds);
        mTextView.setText(time);
    }

}
