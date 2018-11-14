package com.software.engenharia.gerenc_fazenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

<<<<<<< Updated upstream
=======
import com.koushikdutta.ion.Ion;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.acl.Permission;

>>>>>>> Stashed changes
public class Cadastrar extends AppCompatActivity {

    Button cadastra;
    EditText Nome, DtaAdmi, Usuario, Senha, Setor, DtaDemi;
    RadioGroup rd_permissoes;
    int permissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        Nome = findViewById(R.id.txt_Nome);
        DtaAdmi = findViewById(R.id.txt_DtaAdimi);
        Usuario = findViewById(R.id.txt_Usuario);
        Senha = findViewById(R.id.txt_Senha);
        Setor = findViewById(R.id.txt_idSetor);
        DtaDemi = findViewById(R.id.txt_demis)
        permissao=permissao();

        //Instancia e Função 'ao clicar' do Botão de Cadastro
        cadastra = findViewById(R.id.btnAltera);
        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "cadastrando.php?NOME_FUNC="+Nome.getText().toString()+"&USUARIO_FUNC="+Usuario.getText().toString()+"&DTADMI_FUNC="+DtaAdmi.getText().toString()+"&DTDEMIS_FUNC="+DtaDemi.getText().toString()+"&SENHA_FUNC="+Senha.getText().toString()+"&PERMISSOES_FUNC=1&ID_SETOR=1");

                Ion.with(Cadastrar.this)
                        .load(url);
                        .asJsonObject()
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
