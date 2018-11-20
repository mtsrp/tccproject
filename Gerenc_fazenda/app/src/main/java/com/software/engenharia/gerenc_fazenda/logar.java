package com.software.engenharia.gerenc_fazenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.software.engenharia.gerenc_fazenda.Funcionario.CentralFuncionario;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class logar extends AppCompatActivity {

    Button entra;
    EditText user, senha;
    TextView erra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);


        user = findViewById(R.id.txt_Usuar);
        senha = findViewById(R.id.txt_Senha);
        entra = findViewById(R.id.btn_Entrar);
        erra = findViewById(R.id.txt_erroUser);


        entra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equals("Matheus")&&senha.getText().toString().equals("senha")){
                    Intent loga = new Intent(logar.this, PrincipalActivity.class);
                    startActivity(loga);
                }else if(user.getText().toString().equals("Charisse")&&senha.getText().toString().equals("senha")){
                    Intent loga = new Intent(logar.this, InicioFuncionario.class);
                    startActivity(loga);
                }else{
                    erra.setVisibility(View.VISIBLE);
                }

            }
        });

    }
    private InputStream busca() throws IOException {
        URL url = new URL("localhost/Gerenc_fazenda/mysqlphp/logando.php?USUARIO_FUNC="+user.getText().toString()+"&SENHA_FUNC="+senha.getText().toString());
        return url.openConnection().getInputStream();
    }
}
