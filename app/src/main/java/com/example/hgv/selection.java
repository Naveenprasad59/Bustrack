package com.example.hgv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class selection extends AppCompatActivity {
    public ImageButton stu;
    public ImageButton dri;
    public TextView admin;
    public TextView oopsadmin;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_selection);
        getSupportActionBar().hide();
        stu=findViewById(R.id.student);

    stu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent st = new Intent(selection.this,busses1.class);
            startActivity(st);
            finish();
        }
    });
        dri=findViewById(R.id.driver);
    dri.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent dr = new Intent(selection.this,busses2.class);
            startActivity(dr);
            finish();
        }
    });
    admin=findViewById(R.id.admin);
    admin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent ad = new Intent(selection.this,admin.class);
            startActivity(ad);
            Toast.makeText(selection.this,"Admin Page",Toast.LENGTH_LONG).show();
            finish();
        }
    });




    }
}
