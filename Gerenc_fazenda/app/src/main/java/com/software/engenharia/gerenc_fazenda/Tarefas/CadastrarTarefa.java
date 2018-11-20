package com.software.engenharia.gerenc_fazenda.Tarefas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.software.engenharia.gerenc_fazenda.PrincipalActivity;
import com.software.engenharia.gerenc_fazenda.R;


public class CadastrarTarefa extends AppCompatActivity {

    Button EnviaTarefa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tarefa);

        EnviaTarefa = findViewById(R.id.btn_CadastraTarefa);
        EnviaTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                encok();
            }
        });

    }
    private void encok(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Cadastrado");
        //define a mensagem
        builder.setMessage("Tarefa Cadastrada com Sucesso");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent principal =  new Intent(CadastrarTarefa.this, PrincipalActivity.class);
                startActivity(principal);
            }
        });

        //cria o AlertDialog
        AlertDialog tareok = builder.create();
        //Exibe
        tareok.show();
    }
}
