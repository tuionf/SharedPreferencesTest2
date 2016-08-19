package com.example.tuionf.sharedpreferencestest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity  {


    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private CheckBox reCheckBox;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        reCheckBox = (CheckBox) findViewById(R.id.checkboxbox) ;

        // 获取SharedPreferences对象的三种办法
        //第一种 context 的getSharedPreferences方法 (文件名，操作模式)
        //mSharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        //第二种  Activity 的 getPreferences(MODE_PRIVATE)
        //第三种  PreferenceManager.getDefaultSharedPreferences(context)
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        //此处的mSharedPreferences一定要记得在此之前初始化
        boolean is = mSharedPreferences.getBoolean("isRem",false);

        if (is ) {
            //选择了记住密码的话，把账号和密码设置到输入框
            String account = mSharedPreferences.getString("account","");
            String password = mSharedPreferences.getString("password","");
            mEmailView.setText(account);
            mPasswordView.setText(password);
            reCheckBox.setChecked(true);
        }

        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String account = mEmailView.getText().toString();
                String password = mPasswordView.getText().toString();

                if (account.equals("tuionf@163.com") && password.equals("123456")){
                    if (reCheckBox.isChecked()){

                       mEditor =  mSharedPreferences.edit();
                        mEditor.putString("account",account);
                        mEditor.putString("password",password);
                        mEditor.putBoolean("isRem",true);
                        mEditor.commit();
                    }

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"账号或者密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    }


