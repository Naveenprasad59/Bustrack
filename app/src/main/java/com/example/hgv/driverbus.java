package com.example.hgv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class driverbus extends AppCompatActivity {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverbus);
     button=findViewById(R.id.button);
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             Intent ob = new Intent(driverbus.this,MapsActivity.class);
             startActivity(ob);
             finish();

         }
     });
    }
}
