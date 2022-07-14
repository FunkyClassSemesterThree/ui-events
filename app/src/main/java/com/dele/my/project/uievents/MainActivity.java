package com.dele.my.project.uievents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int defaultTextSize = 20;
    private TextView theHandlerText;

    private Button smallBtn, largeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // buttons
        smallBtn = findViewById(R.id.smallTextBtn);
        largeBtn = findViewById(R.id.largeTextBtn);

        // textview
        theHandlerText = findViewById(R.id.theEventHandler);
        theHandlerText.setTextSize(defaultTextSize);

        handleEvents();
    }

    private void handleEvents() {
        handleSmallBtn();
        handleLargeBtn();
    }

    private void handleSmallBtn() {
        smallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("EVENT_HANDLE_TEST", ">>>>>> " + defaultTextSize);
                handleTextChange(false, 10, 10);
            }
        });

        smallBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.i("EVENT_HANDLE_TEST_LONGER", ">>>>>> " + defaultTextSize);
                handleTextChange(false, 2, 5);
                return false;
            }
        });
    }

    private void handleLargeBtn() {
        largeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultTextSize += 10;
                theHandlerText.setTextSize(defaultTextSize);
                handleTextChange(true, 10, 0);
            }
        });
    }

    private void handleTextChange(boolean isIncrement, int number, int testNumber) {
        if (isIncrement) {
            defaultTextSize += number;
        }
        else {
            defaultTextSize = ( defaultTextSize <= testNumber ) ? defaultTextSize : defaultTextSize - number;
        }
        theHandlerText.setTextSize(defaultTextSize);
    }

}