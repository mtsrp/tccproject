package com.software.engenharia.gerenc_fazenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.software.engenharia.gerenc_fazenda.Funcionario.CentralFuncionario;

public class PrincipalActivity extends AppCompatActivity {

    Button Logar, Cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //Instanciamento dos botoes e text do layout
        Logar = (Button) findViewById(R.id.btn_Login);
        Cadastrar = (Button) findViewById(R.id.btn_TesteCadastro);

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastrar = new Intent(PrincipalActivity.this, com.software.engenharia.gerenc_fazenda.Cadastrar.class);
                startActivity(cadastrar);
                setContentView(R.layout.cadastrar);

            }
        });
        Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log =  new Intent(PrincipalActivity.this, CentralFuncionario.class);
                startActivity(log);
                setContentView(R.layout.activity_central_funcionario);
            }
        });
    }
}
