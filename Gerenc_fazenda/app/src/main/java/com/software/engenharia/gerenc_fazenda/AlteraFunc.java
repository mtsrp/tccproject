package com.software.engenharia.gerenc_fazenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlteraFunc extends AppCompatActivity {

    private AlertDialog alerta, alterok;
    Button altera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_func);

        altera = findViewById(R.id.btnAltera);
        altera.setOnClickListener(new View.OnClickListener() {
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
        builder.setTitle("Alterar Dados?");
        //define a mensagem
        builder.setMessage("Você realmente deseja alterar os dados?");
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
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    private void alter(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Dados Alterados");
        //define a mensagem
        builder.setMessage("Dados Alterados com Sucesso");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ok = new Intent(AlteraFunc.this, PrincipalActivity.class);
                startActivity(ok);
            }
        });

        //cria o AlertDialog
        alterok = builder.create();
        //Exibe
        alterok.show();
    }
}
