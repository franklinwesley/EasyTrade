package com.example.huawei.easytrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.huawei.easytrade.Data.MySQLiteOpenHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextLogin;
    private EditText editTextPhone;
    private ImageView imageViewPhoto;
    private Button buttonCreateAccount;
    private MySQLiteOpenHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new MySQLiteOpenHelper(this.getApplicationContext());

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        buttonCreateAccount = (Button) findViewById(R.id.buttonCreate);

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String email = editTextEmail.getText().toString();
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();
                String photo = imageViewPhoto.toString();

                dbHelper.insertUser(name, phone, email, login, password, photo);
            }
        });

    }
}
