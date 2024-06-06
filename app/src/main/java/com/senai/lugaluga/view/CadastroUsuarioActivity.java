package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;
import com.senai.lugaluga.controller.UsuarioController;
import com.senai.lugaluga.model.Usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private Spinner spinnerUf;

    private TextInputLayout input_cpf, input_nome, input_data, input_cep,
                            input_cidade, input_logradouro, input_numero,
                            input_complemento, input_bairro, input_email, input_senha;

    private TextInputLayout inputCpf;

    private TextInputLayout inputCep;

    private TextInputLayout inputData;

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Cadastro");
        setSupportActionBar(myToolbar);

        inputCpf = findViewById(R.id.input_cpf);

        inputCep = findViewById(R.id.input_cep);

        inputData = findViewById(R.id.input_data);

        input_nome = findViewById(R.id.input_nome);

        input_logradouro = findViewById(R.id.input_logradouro);

        input_complemento = findViewById(R.id.input_complemento);

        input_email = findViewById(R.id.input_email);

        input_senha = findViewById(R.id.input_senha);

        input_numero = findViewById(R.id.input_numero);

        input_bairro = findViewById(R.id.input_bairro);

        input_cidade = findViewById(R.id.input_cidade);

        botao = findViewById(R.id.btn_cadastrar);


        inputData.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskDATA = "##/##/####";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*","");
                String mask = maskDATA;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }

                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() <
                            old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputData.getEditText().setText(mascara);
                inputData.getEditText().setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputCep.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCEP = "#####-###";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*","");
                String mask = maskCEP;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }

                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() <
                            old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputCep.getEditText().setText(mascara);
                inputCep.getEditText().setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        inputCpf.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCPF = "###.###.###-##";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*","");
                String mask = maskCPF;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }

                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length()
                            < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputCpf.getEditText().setText(mascara);
                inputCpf.getEditText().setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        spinnerUf = (Spinner) findViewById(R.id.spinner_uf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUf.setAdapter(adapter);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                UsuarioController crud = new UsuarioController(getApplicationContext());
                Usuario usuario = new Usuario();
                usuario.setNome(input_nome.getEditText().getText().toString());
                usuario.setCpf(inputCpf.getEditText().getText().toString());
                usuario.setData(inputData.getEditText().getText().toString());
                usuario.setCep(inputCep.getEditText().getText().toString());
                usuario.setCidade(input_cidade.getEditText().toString());
                usuario.setUf(spinnerUf.getSelectedItem().toString());
                usuario.setLogradouro(input_logradouro.getEditText().getText().toString());
                usuario.setNumero(input_numero.getEditText().getText().toString());
                usuario.setComplemento(input_complemento.getEditText().getText().toString());
                usuario.setBairro(input_bairro.getEditText().getText().toString());
                usuario.setEmail(input_email.getEditText().getText().toString());
                usuario.setSenha(input_senha.getEditText().getText().toString());

                String resultado;

                resultado = crud.insereDados(usuario.getNome(), usuario.getCpf(),usuario.getData(),
                        usuario.getCep(), usuario.getCidade(),
                        usuario.getLogradouro(),usuario.getNumero(),usuario.getComplemento(),
                        usuario.getBairro(),0,usuario.getEmail(),usuario.getSenha(), usuario.getUf());

                Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_LONG).show();
            }
        });
    }
}