package com.software.engenharia.gerenc_fazenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    Button Logar, Cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //Instanciamento dos botoes e text do layout
        Logar = (Button) findViewById(R.id.btn_Login);
        Cadastrar = (Button) findViewById(R.id.btn_TesteCadastro);
        Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logar = new Intent(PrincipalActivity.this, Login.class);
                startActivity(logar);


            }
        });
    }
}
