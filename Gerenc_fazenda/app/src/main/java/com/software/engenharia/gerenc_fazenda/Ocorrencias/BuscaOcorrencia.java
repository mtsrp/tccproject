package com.software.engenharia.gerenc_fazenda.Ocorrencias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.software.engenharia.gerenc_fazenda.R;

public class BuscaOcorrencia extends AppCompatActivity {

    RadioButton setor, tudo;
    EditText idSet;
    Button buscOcor, ocor1, ocor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_ocorrencia);
        idSet = findViewById(R.id.txt_BuscaSetId);
        setor = findViewById(R.id.rdn_Setor);
        tudo = findViewById(R.id.rdn_Tudo);
        buscOcor = findViewById(R.id.btn_RealizaBusca3);
        ocor1 = findViewById(R.id.btn_Ocorre1);
        ocor2 = findViewById(R.id.btn_Ocorre2);
        setor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idSet.setVisibility(View.VISIBLE);
            }
        });
        tudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idSet.setVisibility(View.INVISIBLE);
            }
        });
        buscOcor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocor1.setVisibility(View.VISIBLE);
                ocor2.setVisibility(View.VISIBLE);
            }
        });

        ocor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iniocorre = new Intent(BuscaOcorrencia.this, Ocorrencia.class);
                startActivity(iniocorre);
            }
        });
    }
}
