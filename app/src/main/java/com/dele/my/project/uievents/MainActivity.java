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
        smallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("EVENT_HANDLE_TEST", ">>>>>> " + defaultTextSize);
                defaultTextSize = ( defaultTextSize <= 10 ) ? defaultTextSize : defaultTextSize - 10;
                theHandlerText.setTextSize(defaultTextSize);
            }
        });

        largeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultTextSize += 10;
                theHandlerText.setTextSize(defaultTextSize);
            }
        });
    }

}