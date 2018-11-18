package com.software.engenharia.gerenc_fazenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.software.engenharia.gerenc_fazenda.Funcionario.Busca_Funcionario;

public class PrincipalActivity extends AppCompatActivity {

    private AlertDialog alterok;
    Button CadasSetor, Cadastrar, Teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        //Instanciamento dos botoes e text do layout
        Cadastrar = (Button) findViewById(R.id.btn_TesteCadastro);
        Teste =  findViewById(R.id.btn_teste);
        CadasSetor = findViewById(R.id.btn_cadastrasetor);

        CadasSetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadsetor();
            }
        });

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastrar = new Intent(PrincipalActivity.this, Cadastrar_Funcionario.class);
                startActivity(cadastrar);

            }
        });

        Teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test =  new Intent(PrincipalActivity.this, Busca_Funcionario.class);
                startActivity(test);
            }
        });
    }

    private void cadsetor(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(PrincipalActivity.this);
        alert.setMessage("Insira o nome do novo setor: ");
        alert.setTitle("Cadastro de Setor");

        alert.setView(edittext);

        alert.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

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
        builder.setTitle("Cadastrado");
        //define a mensagem
        builder.setMessage("Setor cadastrado com sucesso");

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //cria o AlertDialog
        alterok = builder.create();
        //Exibe
        alterok.show();
    }
}
