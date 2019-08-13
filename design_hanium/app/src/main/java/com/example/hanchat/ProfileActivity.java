package com.example.hanchat;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    EditText editText_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editText_id = findViewById(R.id.editText_id);
        editText_id.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String user_id = editText_id.getText().toString();
                setOnClipBoard(user_id);
                Toast.makeText(getApplicationContext(), "Long click to copy ID", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    public void setOnClipBoard(String user_id) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Test Clipboard", user_id);
        clipboardManager.setPrimaryClip(clipData);
    }
}