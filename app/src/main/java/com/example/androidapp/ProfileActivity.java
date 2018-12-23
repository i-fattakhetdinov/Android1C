package com.example.androidapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private EditText editTextField;
    private TextView textViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextField = findViewById(R.id.edit_text);
        textViewDate = findViewById(R.id.text_view_date);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", editTextField.getText().toString());
        outState.putString("date", textViewDate.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            editTextField.setText(savedInstanceState.getString("text"));
            textViewDate.setText(savedInstanceState.getString("date"));
        }
    }

    public void setDate(View view) {
        Intent intent = new Intent(view.getContext(), DateSetterActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {return;}
        String dateString = data.getStringExtra("date");
        textViewDate.setText(dateString);
    }
}
