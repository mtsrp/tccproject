package com.software.engenharia.gerenc_fazenda.Funcionario;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.software.engenharia.gerenc_fazenda.AlteraFunc;
import com.software.engenharia.gerenc_fazenda.PrincipalActivity;
import com.software.engenharia.gerenc_fazenda.R;

public class CentralFuncionario extends AppCompatActivity {

    Button AlterFunc, DemiteFunc, Sair;
    TextView situa, permi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_funcionario);

        Sair = findViewById(R.id.btn_Sair);
        AlterFunc = findViewById(R.id.btn_Alterarfunc);
        DemiteFunc = findViewById(R.id.btn_DemitirFunc);


        permi = findViewById(R.id.txt_permis);
        situa = findViewById(R.id.txt_situacao);

        Sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(CentralFuncionario.this, PrincipalActivity.class);
                startActivity(principal);
            }
        });
        DemiteFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demis();
            }
        });
        AlterFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alter = new Intent(CentralFuncionario.this, AlteraFunc.class);
                startActivity(alter);
            }
        });
    }

    private void demis(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(CentralFuncionario.this);
        alert.setMessage("Insira a data de demissão do funcionário:");
        alert.setTitle("Demissão");

        alert.setView(edittext);

        alert.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                situa.setText("Situação: Desligado da Empresa");
                permi.setText("Permissões: Sem permissões");
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
        builder.setTitle("Demissão");
        //define a mensagem
        builder.setMessage("Funcionário desativado");

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
}
