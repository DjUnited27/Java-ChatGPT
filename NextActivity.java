package com.example.chatgptprojectappv11;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    private Button mButtonList;
    private Button mButtonBirthdayList;

    private static final String TAG = "NextActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Log.d(TAG, "onCreate: NextActivity created");

        mButtonList = findViewById(R.id.button_go_to_list);
        mButtonList.setText(R.string.go_to_list);
        mButtonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NextActivity.this, ListActivity.class));
            }
        });

        mButtonBirthdayList = findViewById(R.id.button_add_birthday_date);
        mButtonBirthdayList.setText("Add a new Birthday date");
        mButtonBirthdayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NextActivity.this, BirthdayListActivity.class));
            }
        });
    }
}
