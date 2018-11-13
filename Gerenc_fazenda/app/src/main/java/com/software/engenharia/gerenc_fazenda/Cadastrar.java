package com.software.engenharia.gerenc_fazenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Cadastrar extends AppCompatActivity {

    Button cadastra;
    EditText Nome, DtaAdmi, Usuario, Senha;
    RadioGroup rd_permissoes;
    int permissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);


        //Instancia e Função 'ao clicar' do Botão de Cadastro
        cadastra = findViewById(R.id.btnCadastra);
        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pega o valor do Raddio Button permissoes
                permissao = permissao();

                //Verificar se o nome de usuário está disponivel


                //Vai pegar os dados digitados e mandar para o .php realizar o cadastro das informações no banco


            }
        });

    }


    //Pega o item do RaddioButtom de Permissoes e seta na variavel permissoes
    public int permissao() {
        int permissaoSelect=0;
        rd_permissoes = findViewById(R.id.rdngroup_Permissoes);
        switch (rd_permissoes.getCheckedRadioButtonId()) {
            case R.id.rdn_Funcionario:
                permissaoSelect = 1;
                break;


            case R.id.rdn_Adm:
                permissaoSelect = 2;
                break;
        }
        return permissaoSelect;
    }

}
