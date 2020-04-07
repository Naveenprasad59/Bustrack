package com.example.hgv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class busses2 extends AppCompatActivity {
    public Button back;
    public Button bus10;
    public EditText user;
    public EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_busses2);
        getSupportActionBar().hide();
        back=findViewById(R.id.ba);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(busses2.this,selection.class);
                startActivity(in);
                finish();
            }
        });
     bus10=findViewById(R.id.Login);
     bus10.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent o10=new Intent(busses2.this,driverbus.class);
             startActivity(o10);
             finish();
         }
     });
    }
}
