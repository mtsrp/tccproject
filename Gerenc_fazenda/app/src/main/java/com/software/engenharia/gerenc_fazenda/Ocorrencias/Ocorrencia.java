package com.software.engenharia.gerenc_fazenda.Ocorrencias;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.software.engenharia.gerenc_fazenda.PrincipalActivity;
import com.software.engenharia.gerenc_fazenda.R;

public class Ocorrencia extends AppCompatActivity {

    Button AlteraDados, Sair4, ExcluiOcorr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocorrencia);

        AlteraDados = findViewById(R.id.btn_AlterarOcorrencia);
        Sair4 = findViewById(R.id.btn_Sair4);
        ExcluiOcorr = findViewById(R.id.btn_ExcluirOcorrencia);

        AlteraDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Altocorre = new Intent(Ocorrencia.this, AlteraOcorrencia.class);
                startActivity(Altocorre);
            }
        });

        ExcluiOcorr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert();
            }
        });

        Sair4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(Ocorrencia.this, PrincipalActivity.class);
                startActivity(principal);
            }
        });


    }
    private void alert(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Excluir Ocorrência?");
        //define a mensagem
        builder.setMessage("Você realmente deseja excluir esta Ocorrência?");
        //define um botão como positivo
        builder.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alter();
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

    private void alter(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Excluido");
        //define a mensagem
        builder.setMessage("Dados Excluidos com Sucesso");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ok = new Intent(Ocorrencia.this, PrincipalActivity.class);
                startActivity(ok);
            }
        });

        //cria o AlertDialog
        AlertDialog alterok = builder.create();
        //Exibe
        alterok.show();
    }
}
