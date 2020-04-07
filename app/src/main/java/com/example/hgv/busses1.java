package com.example.hgv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class busses1 extends AppCompatActivity {
   public Button button;
   public Button bus10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busses1);
        button=findViewById(R.id.b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob=new Intent(busses1.this,selection.class);
                startActivity(ob);
                finish();
            }
        });
     bus10=findViewById(R.id.B10);
     bus10.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent cb = new Intent(busses1.this,MapsActivity.class);
             startActivity(cb);
             finish();
         }
     });

    }
}
