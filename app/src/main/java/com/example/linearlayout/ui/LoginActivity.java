package com.example.linearlayout.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.linearlayout.utils.AppConstants;
import com.example.linearlayout.R;
import com.example.linearlayout.business.UserBusiness;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private final LoginActivity.ViewHolder viewHolder = new LoginActivity.ViewHolder();
    private UserBusiness userBusiness = new UserBusiness();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        viewHolder.LinearLayoutMain = findViewById(R.id.main);
        viewHolder.editTextEmail = findViewById(R.id.edittext_email);
        viewHolder.editTextPassword = findViewById(R.id.edittext_password);
        viewHolder.buttonLogin = findViewById(R.id.button_login);
        viewHolder.buttonRegister = findViewById(R.id.button_register);

        //Para que um padding seja respeitado, é necessario alterar o codigo nos lados left(esquerda) right(direita)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left + viewHolder.LinearLayoutMain.getPaddingStart(),
                    systemBars.top,
                    systemBars.right + viewHolder.LinearLayoutMain.getPaddingEnd(),
                    systemBars.bottom);
            return insets;
        });
        viewHolder.buttonLogin.setOnClickListener(this);
        viewHolder.buttonRegister.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_login){

            String email = viewHolder.editTextEmail.getText().toString();
            String password = viewHolder.editTextPassword.getText().toString();

           if (userBusiness.isValid(email, password)){
               Bundle bundle = new Bundle();
               bundle.putString(AppConstants.EMAIL_KEY,email);

               Intent intent = new Intent(this, HomeActivity.class);
               intent.putExtras(bundle);

               startActivity(intent);
           }else {
               Toast.makeText(this,"Informe os dados!", Toast.LENGTH_SHORT).show();
           }

        } else if (v.getId() == R.id.button_register) {

        }
    }

    private static class ViewHolder{
        LinearLayout LinearLayoutMain;
        EditText editTextEmail;
        EditText editTextPassword;
        Button buttonLogin;
        Button buttonRegister;
    }
}