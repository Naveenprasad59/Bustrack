package com.example.hgv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class admin extends AppCompatActivity {

   public Button insert;
   private ListView driverlistview;
   private EditText driversedit;
    public EditText names;
    public TextView current;
    String drivers;
   // private String[] driversnamelist={"Murugan--------234567823---243","Suresh---------7635363738---423","Ramesh---------6536384763---987"};

    private ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().hide();

        list.add("Murugan--------234567823---243");
        list.add("Suresh---------7635363738---423");


        insert=(Button)findViewById(R.id.insert);
        driverlistview=(ListView)findViewById(R.id.driverlistview);

        names=(EditText)findViewById(R.id.insertname);


        final ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drivers=names.getText().toString();
                list.add(drivers);
                savearraylist();
                adapter.notifyDataSetChanged();
                names.setText("");
                Toast.makeText(admin.this,"Inserted",Toast.LENGTH_LONG).show();

            }
        });
        driverlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,final int j, long l) {
                AlertDialog.Builder msgbox = new AlertDialog.Builder(admin.this);
                msgbox.setTitle("Deletion");
                msgbox.setMessage("Are you sure you want to Remove this Driver");


                msgbox.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        list.remove(j);
                        savearraylist();
                        adapter.notifyDataSetChanged();
                        Toast.makeText(admin.this,"deleted",Toast.LENGTH_SHORT).show();
                    }

                });
                msgbox.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                msgbox.setCancelable(true);
                msgbox.create().show();

            }
        });

        driverlistview.setAdapter(adapter);



        loadarraylist(getApplicationContext());
    }
    private void savearraylist(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt("no.of.drivers",list.size());

        for (int i =0;i<list.size();i++){
            editor.remove("drivers"+i);
            editor.putString("drivers"+i,list.get(i));
        }
        editor.commit();
    }
    private void loadarraylist(Context context){
        SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(context);
        list.clear();
        int size = sharedPreferences2.getInt("no.of.drivers",0);

        for (int i=0;i<size;i++){
            list.add(sharedPreferences2.getString("drivers"+i,null));
        }
    }
}
