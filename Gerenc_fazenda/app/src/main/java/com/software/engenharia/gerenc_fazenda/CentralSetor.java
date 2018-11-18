package com.software.engenharia.gerenc_fazenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CentralSetor extends AppCompatActivity {

    Button AlteraSet, ExcluiSet, SairSet;
    TextView nomeSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_setor);

        AlteraSet = findViewById(R.id.btn_AlterarSetor);
        ExcluiSet = findViewById(R.id.btn_ExcluirSetor);
        SairSet = findViewById(R.id.btn_Sair2);
        nomeSet = findViewById(R.id.txt_NSetor);

         AlteraSet.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 altSetor();
             }
         });

         ExcluiSet.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 exclui();
             }
         });
        SairSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(CentralSetor.this, PrincipalActivity.class);
                startActivity(principal);
            }
        });
    }
    private void altSetor(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(CentralSetor.this);
        alert.setMessage("Edite o nome do setor:");
        alert.setTitle("Editar dados Setor");

        edittext.setText("Celeiro");
        alert.setView(edittext);

        alert.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                nomeSet.setText("Nome Setor: "+edittext.getText().toString());
                alter();

            }
        });

        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // what ever you want to do with No option.
            }
        });

        alert.show();
    }
    private void alter(){

        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Dados Alterados");
        //define a mensagem
        builder.setMessage("Os dados foram alterados com sucesso");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //cria o AlertDialog
        AlertDialog alterok = builder.create();
        //Exibe
        alterok.show();
    }

    private void exclui(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Excluir?");
        //define a mensagem
        builder.setMessage("Você realmente deseja excluir o setor?");
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
        builder.setTitle("Excluido");
        //define a mensagem
        builder.setMessage("O setor foi excluido com sucesso");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ok = new Intent(CentralSetor.this, PrincipalActivity.class);
                startActivity(ok);
            }
        });

        //cria o AlertDialog
        AlertDialog alterok = builder.create();
        //Exibe
        alterok.show();
    }
}