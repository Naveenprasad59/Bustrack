package com.example.hgv;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class adminoops extends AppCompatActivity implements View.OnClickListener {
  public EditText name1;
  public EditText phone1;
  public EditText id1;
  public Button insert1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminoops);

        name1=findViewById(R.id.name1);
        phone1=findViewById(R.id.phone1);
        id1=findViewById(R.id.id1);
        insert1=findViewById(R.id.insert1);
        insert1.setOnClickListener(this);
    }

    private void addnameToShett(){
        final ProgressDialog loading = ProgressDialog.show(this,"Adding driver name","Please Wait");
        final String name = name1.getText().toString().trim();
        final String phone = phone1.getText().toString().trim();
        final String id= id1.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbwuXRGjquIJVwLVQmLkC9ok7Rcnua9YKLz_Wgr0HfRjIPSMvgM/exec", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                Toast.makeText(adminoops.this, response, Toast.LENGTH_LONG);
                Intent intent = new Intent(getApplicationContext(), adminoops.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String,String>getParams(){
                Map<String, String> parmas = new HashMap<>();

                parmas.put("action","addName");
                parmas.put("Drivername",name);
                parmas.put("phone",phone);
                parmas.put("id",id);

                return parmas;
            }
        };
    int socketTimeOut = 50000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(adminoops.this);
        queue.add(stringRequest);

    }

    @Override
    public void onClick(View view) {
       if(view == insert1){
           addnameToShett();
       }
    }
}
