package com.software.engenharia.gerenc_fazenda.Funcionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.software.engenharia.gerenc_fazenda.AlteraFunc;
import com.software.engenharia.gerenc_fazenda.R;
import com.software.engenharia.gerenc_fazenda.Resultado;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Busca_Funcionario extends AppCompatActivity {

    EditText txt_nome_func;
    Button realizaBusca, vini, chay;
    ImageView img1, img2;
    public static String busca;
    private ListView listax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca__funcionario);

        txt_nome_func = findViewById(R.id.txt_BuscaFunc);
        realizaBusca = findViewById(R.id.btn_RealizaBusca);

        vini = findViewById(R.id.btn_vini);
        chay = findViewById(R.id.btn_chay);


        realizaBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (txt_nome_func.getText().toString()){
                    case "Vinicius":
                        vini.setVisibility(View.VISIBLE);
                        chay.setVisibility(View.INVISIBLE);
                        break;
                    case "Charisse":
                        chay.setVisibility(View.VISIBLE);
                        vini.setVisibility(View.INVISIBLE);
                        break;
                    case "":
                        vini.setVisibility(View.VISIBLE);
                        chay.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });

        vini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent alter = new Intent(Busca_Funcionario.this, CentralFuncionario.class);
                startActivity(alter);
            }
        });

    }

}
