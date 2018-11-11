package com.software.engenharia.gerenc_fazenda.Funcionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.software.engenharia.gerenc_fazenda.R;
import com.software.engenharia.gerenc_fazenda.Resultado;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Busca_Funcionario extends AppCompatActivity {

    EditText txt_nome_func;
    Button realizaBusca;
    public static String busca;
    private ListView listax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca__funcionario);

        txt_nome_func = findViewById(R.id.txt_BuscaFunc);
        realizaBusca = findViewById(R.id.btn_RealizaBusca);


        realizaBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                busca = txt_nome_func.getText().toString().replace(" ", "_");
                Intent resu = new Intent(Busca_Funcionario.this, Resultado.class);
                startActivity(resu);
            }
        });



    }

}
