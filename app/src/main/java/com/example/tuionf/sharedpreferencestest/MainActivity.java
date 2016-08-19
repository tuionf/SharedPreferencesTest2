package com.example.tuionf.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button saveBtn;
    private Button reBtn;
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = (Button) findViewById(R.id.saveBtn);
        reBtn = (Button) findViewById(R.id.reBtn);
        mEditText = (EditText) findViewById(R.id.et);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过Context的getSharedPreferences方法获得sharedPreferences 对象
                SharedPreferences sharedPreferences =  getSharedPreferences("spdata",MODE_PRIVATE);
                //通过sharedPreferences.edit()获得editor对象
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name","tuionf");
                editor.putBoolean("man",true);
                editor.putInt("age",23);
                editor.putString("city","beijing");
                editor.commit();

                Toast.makeText(MainActivity.this,"数据已存储",Toast.LENGTH_SHORT).show();


            }
        });

        reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("spdata",MODE_PRIVATE);
                String name = sharedPreferences.getString("name","null");
                boolean man = sharedPreferences.getBoolean("man",true);
                int age = sharedPreferences.getInt("age",12);
                String city = sharedPreferences.getString("city","taiyuan");

                mEditText.setText("name:"+name+"---man:"+man+"---age:"+age+"---city:"+city);
            }
        });
    }
}
