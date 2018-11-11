package com.software.engenharia.gerenc_fazenda.Funcionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.software.engenharia.gerenc_fazenda.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Busca_Funcionario extends AppCompatActivity {

    EditText nome_func;
    Button realizaBusca;
    String nomebusca="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca__funcionario);

        nome_func = findViewById(R.id.txt_Nome);
        realizaBusca = findViewById(R.id.btn_RealizaBusca);

        realizaBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    buscaFunc();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private InputStream buscaFunc() throws IOException{
        nomebusca = nome_func.getText().toString().replace(" ", "_");
        URL url = new URL(".php?nome_artista="+nomebusca);
        return url.openConnection().getInputStream();
    }
}
