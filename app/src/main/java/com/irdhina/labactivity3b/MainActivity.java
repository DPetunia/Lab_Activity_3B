package com.irdhina.labactivity3b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends Activity  {
    Button simpan,panggil;
    TextView papar;
    EditText add;

    String data;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpan=(Button)findViewById(R.id.save);
        panggil=(Button)findViewById(R.id.load);

        add=(EditText)findViewById(R.id.address);
        papar=(TextView)findViewById(R.id.view);
        simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                data=add.getText().toString();
                try {
                    FileOutputStream fOut = openFileOutput(file, Context.MODE_PRIVATE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"FILE SAVED!!",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        panggil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp="";
                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    papar.setText(temp);
                    Toast.makeText(getBaseContext(),"FILE READ!!",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }
            }
        });
    }
}
