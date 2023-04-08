package com.example.chatgptprojectappv11;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "birthdays.txt" ;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordInput = findViewById(R.id.password_input);
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if password is correct
                String password = passwordInput.getText().toString();
                if (password.equals("7920")) {
                    // If password is correct, start next activity
                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    startActivity(intent);
                } else {
                    // If password is incorrect, show error message
                    Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void readFiles() {
        File file = new File(getApplicationContext().getFilesDir(), FILE_NAME);
        if (file.exists()) {
            try {
                FileInputStream fis = openFileInput(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<PersonInfo> mPersonInfo = (List<PersonInfo>) ois.readObject();
                ois.close();
                fis.close();
                ArrayAdapter<Object> mAdapter;
                mAdapter = null;
                mAdapter.notifyDataSetChanged();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeToFile(List<PersonInfo> personInfoList) {
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personInfoList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<PersonInfo> getSavedData() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<PersonInfo> data = (ArrayList<PersonInfo>) ois.readObject();
            ois.close();
            fis.close();
            if (data == null) {
                return new ArrayList<>();
            }
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
