package com.software.engenharia.gerenc_fazenda.Tarefas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.software.engenharia.gerenc_fazenda.R;

public class BuscaTarefa extends AppCompatActivity {

    Button busTarefa, tar1, tar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_tarefa);

        tar1 = findViewById(R.id.btn_tar01);
        tar2 = findViewById(R.id.btn_tar02);
        busTarefa = findViewById(R.id.btn_RealizaBuscaTarefa);
        busTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tar1.setVisibility(View.VISIBLE);
                tar2.setVisibility(View.VISIBLE);
            }
        });
        tar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent busTarefa = new Intent(BuscaTarefa.this, Tarefa.class);
                startActivity(busTarefa);
            }
        });
    }
}
