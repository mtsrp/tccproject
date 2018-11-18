package com.software.engenharia.gerenc_fazenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuscaSetor extends AppCompatActivity {

    Button buscaSetor, setor01, setor02, setor03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_setor);

        buscaSetor = findViewById(R.id.btn_RealizaBusca2);
        setor01 = findViewById(R.id.btn_setor1);
        setor02 = findViewById(R.id.btn_setor2);
        setor03 = findViewById(R.id.btn_setor3);

        buscaSetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setor01.setVisibility(View.VISIBLE);
                setor02.setVisibility(View.VISIBLE);
                setor03.setVisibility(View.VISIBLE);
            }
        });

        setor01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seto = new Intent(BuscaSetor.this, CentralSetor.class);
                startActivity(seto);
            }
        });

    }
}
