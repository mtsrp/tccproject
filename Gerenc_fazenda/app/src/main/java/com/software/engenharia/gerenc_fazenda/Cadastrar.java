package com.software.engenharia.gerenc_fazenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Cadastrar extends AppCompatActivity {

    Button Cadastra;
    EditText Nome, DtaAdmi, Usuario, Senha;
    RadioButton Fun, Adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);


        //Instancia e Função 'ao clicar' do Botão de Cadastro
        Cadastra = (Button) findViewById(R.id.btnCadastra);
        Cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verificar se o nome de usuário está disponivel

                //Vai pegar os dados digitados e mandar para o .php realizar o cadastro das informações no banco


            }
        });


    }
}
