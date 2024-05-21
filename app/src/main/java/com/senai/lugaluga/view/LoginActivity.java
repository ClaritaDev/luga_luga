package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;

    private TextInputLayout inputEmail, inputSenha;

    private TextView fazerCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Login");
        setSupportActionBar(myToolbar);

        inputEmail = findViewById(R.id.outlinedTextField);
        inputSenha = findViewById(R.id.imput_senha);
        buttonLogin = findViewById(R.id.button_logar);
        fazerCadastro = findViewById(R.id.fazerCadastro);

        Intent intent = new Intent(this, MainActivity2.class);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaEmailSenha()) {
                    startActivity(intent);
                }
            }
        });

        Intent intentCadastro = new Intent(this,CadastroUsuarioActivity.class);

        fazerCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCadastro);
            }
        });
    }

    public boolean validaEmailSenha(){
        if (inputEmail.getEditText() != null && inputEmail.getEditText().getText().toString().equals("")){
            inputEmail.setError("Informe o email");
            return false;
        }

        if (inputSenha.getEditText() != null && inputSenha.getEditText().getText().toString().equals("")){
            inputSenha.setError("Informe a senha");
            return false;
        }

        return true;
    }
}