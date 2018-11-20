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

public class Tarefa extends AppCompatActivity {

    Button alteTarefa, ClncluiTarefa, SairTarefa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        SairTarefa = findViewById(R.id.btn_Sair3);
        ClncluiTarefa = findViewById(R.id.btn_ConcluirTarefa);
        alteTarefa = findViewById(R.id.btn_AlterarTarefa);

        alteTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alTarefa = new Intent(Tarefa.this, AlteraTarefa.class);
                startActivity(alTarefa);
            }
        });

        ClncluiTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exclui();
            }
        });

        SairTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(Tarefa.this, PrincipalActivity.class);
                startActivity(principal);
            }
        });
    }
    private void exclui(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Concluir?");
        //define a mensagem
        builder.setMessage("Você realmente deseja definir a Tarefa como Concluida?\nA tarefa será REMOVIDA da lista de Tarefas.");
        //define um botão como positivo
        builder.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                excluiok();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        AlertDialog alerta = builder.create();
        //Exibe
        alerta.show();
    }

    private void excluiok(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Concluido");
        //define a mensagem
        builder.setMessage("A tarefa foi removida com sucesso!");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ok = new Intent(Tarefa.this, PrincipalActivity.class);
                startActivity(ok);
            }
        });

        //cria o AlertDialog
        AlertDialog alterok = builder.create();
        //Exibe
        alterok.show();
    }
}
