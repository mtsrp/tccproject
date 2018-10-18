package com.equipe.qshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class QSHOW extends Activity {
	
	//Declaração das váriavéis dos objetos presentes na tela de pesquisa, "QSHOW".
	Button Buscar;
	EditText txtBusca;
	ListView Lista;
	public static String busca;
		
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qshow);      
        
        //Instanciação dos objetos do botão e da caixa de texto da segunda tela do projeto.
        Buscar = (Button)findViewById(R.id.btnbuscar); 
        txtBusca = (EditText) findViewById(R.id.txtBuscar);        
        
        /*Ação de troca do "_" presente no banco de dados, pelo " " e inicialização da activity de resultado,
         ao clique feito pelo usuário no botão "BUSCAR".*/
         
        Buscar.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				busca=txtBusca.getText().toString().replace(" ", "_");
				
				Intent R1 = new Intent(QSHOW.this, Resultado.class);
				startActivity(R1);
			}
		});
    
   
    }
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.qshow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	

}
