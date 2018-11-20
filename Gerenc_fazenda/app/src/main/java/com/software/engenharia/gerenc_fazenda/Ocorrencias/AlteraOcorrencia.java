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

public class AlteraOcorrencia extends AppCompatActivity {

    Button alter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_ocorrencia);

        alter = findViewById(R.id.btn_AlteraOcorrencia2);
        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alt();
            }
        });
    }
    private void alt(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Alterar?");
        //define a mensagem
        builder.setMessage("Você realmente deseja alterar os dados?");
        //define um botão como positivo
        builder.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                altok();
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

    private void altok(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Concluido");
        //define a mensagem
        builder.setMessage("Dados Alterados com Sucesso!");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ok = new Intent(AlteraOcorrencia.this, PrincipalActivity.class);
                startActivity(ok);
            }
        });

        //cria o AlertDialog
        AlertDialog alterok = builder.create();
        //Exibe
        alterok.show();
    }
}
