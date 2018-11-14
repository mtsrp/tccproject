package com.software.engenharia.gerenc_fazenda.Funcionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.software.engenharia.gerenc_fazenda.R;

public class CentralFuncionario extends AppCompatActivity {

    Button CadasFunc, AlterFunc, BuscaFunc, DemiteFunc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_funcionario);

        BuscaFunc = findViewById(R.id.btn_RealizaBusca);
        CadasFunc = findViewById(R.id.btn_cadastrafunc);
        AlterFunc = findViewById(R.id.btn_Alterarfunc);
        DemiteFunc = findViewById(R.id.btn_DemitirFunc);


    }
}
