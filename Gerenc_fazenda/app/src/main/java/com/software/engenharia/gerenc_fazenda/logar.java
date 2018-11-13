package com.software.engenharia.gerenc_fazenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class logar extends AppCompatActivity {

    Button entra;
    EditText user, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);


        user = findViewById(R.id.txt_Usuario);
        senha = findViewById(R.id.txt_Senha);
        entra = findViewById(R.id.btn_Entrar);


        entra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                }
        });

    }
    private InputStream busca() throws IOException {
        URL url = new URL("localhost/Gerenc_fazenda/mysqlphp/logando.php?USUARIO_FUNC="+user.getText().toString()+"&SENHA_FUNC="+senha.getText().toString());
        return url.openConnection().getInputStream();
    }
}
