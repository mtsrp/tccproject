package com.software.engenharia.gerenc_fazenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cadastrar_Funcionario extends AppCompatActivity {

    private AlertDialog alerta;
    Button EnviaCadast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar__funcionario);

        EnviaCadast = findViewById(R.id.btn_cadastrafunc);

        EnviaCadast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert();
            }
        });
    }

    private void alert(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Cadastrado");
        //define a mensagem
        builder.setMessage("Usuário Cadastrado com Sucesso");
        //define um botão como positivo

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ok = new Intent(Cadastrar_Funcionario.this, PrincipalActivity.class);
                startActivity(ok);
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }
}
