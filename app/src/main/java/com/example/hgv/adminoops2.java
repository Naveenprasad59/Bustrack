package com.example.hgv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminoops2 extends AppCompatActivity implements View.OnClickListener {
    Button insert2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminoops2);

        insert2=findViewById(R.id.insert1);
        insert2.setOnClickListener(adminoops2.this);


    }

    @Override
    public void onClick(View view) {
        if(view==insert2){
            Intent intent= new Intent(getApplicationContext(),adminoops.class);
            startActivity(intent);
        }
    }
}
