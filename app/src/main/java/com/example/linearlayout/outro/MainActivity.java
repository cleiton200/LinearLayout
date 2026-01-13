package com.example.linearlayout.outro;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.linearlayout.R;

public class MainActivity extends AppCompatActivity {

//    private final ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        viewHolder.editTextEmail = findViewById(R.id.edittext_email);
//        viewHolder.editTextPassword = findViewById(R.id.edittext_password);
//        viewHolder.buttonLogin = findViewById(R.id.button_login);
//        viewHolder.buttonRegister = findViewById(R.id.button_register);
//
//        viewHolder.buttonLogin.setOnClickListener(this);
//        viewHolder.buttonRegister.setOnClickListener(this);

    }

//    @Override
//    public void onClick(View v) {
//        if(v.getId() == R.id.button_login){
//
//            String email = viewHolder.editTextEmail.getText().toString();
//            String password = viewHolder.editTextPassword.getText().toString();
//
//            if(!email.isEmpty() && !password.isEmpty()){
//                Intent intent = new Intent(this, HomeActivity.class);
//                startActivity(intent);
//            }else {
//                Toast.makeText(this,"Informe os dados!", Toast.LENGTH_SHORT).show();
//            }
//
//            //Toast.makeText(this,getString(R.string.lindao), Toast.LENGTH_SHORT).show();
//        } else if (v.getId() == R.id.button_register) {
//
//        }
//
//
//    }
//
//    private static class ViewHolder{
//        EditText editTextEmail;
//        EditText editTextPassword;
//        Button buttonLogin;
//        Button buttonRegister;
//    }
//
//

}