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

public class CadastraOcorrencia extends AppCompatActivity {

    Button gera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_ocorrencia);

        gera = findViewById(R.id.btn_GeraOcorrencia);

        gera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alter();
            }
        });
    }
    private void alter(){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Cadastrado");
        //define a mensagem
        builder.setMessage("Ocorrência Gerada com Sucesso");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent principal =  new Intent(CadastraOcorrencia.this, PrincipalActivity.class);
                startActivity(principal);
            }
        });

        //cria o AlertDialog
        AlertDialog cadrok = builder.create();
        //Exibe
        cadrok.show();
    }
}
