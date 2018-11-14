package com.software.engenharia.gerenc_fazenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.software.engenharia.gerenc_fazenda.Funcionario.Busca_Funcionario;
import com.software.engenharia.gerenc_fazenda.Funcionario.tab;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Resultado extends AppCompatActivity {
    //Declaração das váriaves dos objetos presentes na tela de resultados da busca, "Resultado".
    String row1, row2, row3;
    public static String nomex="", datax="", usuariox="";
    private CardArrayAdapter cardArrayAdapter;
    private ListView listax ;
    int k=0;

    String[] tabela = new String[] {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Instanciação dos objetos presentes na lista utilizada na tela de resultado.
        listax = (ListView) findViewById(R.id.list);
        listax.addHeaderView(new View(this));
        listax.addFooterView(new View(this));

        /*Caso o artista/cidade pesquisado pelo usuário, não esteja no banco de dados,
        uma mensagem será retornada no lugar da listview.*/
        TextView emptyView = (TextView) findViewById(R.id.textView1);
        listax.setEmptyView(emptyView);

        //Instanciação do visual da lista, herdado da classe CardArrayAdapter.
        cardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.row_personalizada);

		/*Caso haja conexão com internet, serão buscados os dados do artista ou da cidade, buscados na primeira tela,
		 no banco de dados. Se não, uma mensagem será exibida na tela.*/
        try{
            getDados();
        }catch(Exception e){
            Toast toast = Toast.makeText(getApplicationContext(), "ERRO, verifique sua conexão com a internet e tente novamente.", Toast.LENGTH_SHORT);
            toast.show();
        }

		/*Ação feita ao clique do usuário na listax (ListView), que pega o conteúdo da row_personalizada,
		de acordo com o item clicado pelo usúario, e os seta nas váriaves row1, row2, row3, que darão os dados
		do nome do Artista, Data do show e nome da Cidade desse show, e posteriormente, chamará a próxima classe.
        listax.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                row1 = ((TextView)view.findViewById(R.id.line1)).getText().toString();
                row2 = ((TextView)view.findViewById(R.id.line2)).getText().toString();
                row3 = ((TextView)view.findViewById(R.id.line3)).getText().toString();

                artistax=row1.replace(" ", "_");
                datax=row2;
                cidadex=row3.replace("São Paulo", "Sao Paulo");

                Intent a1 = new Intent(Resultado.this, Artista.class);
                startActivity(a1);
            }
        }); */

    }

    //Método de busca do artista no PHP.
    private InputStream busca() throws IOException {
        URL url = new URL("localhost/func_busca.php?nome_func=Mat");
        return url.openConnection().getInputStream();
    }


    //Onde será feita a busca dos dados do Artista pesquisado no XML.
    private void getDados() {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(busca(), null);

            if (xpp != null) {
                int eventType = xpp.getEventType();
                String atual = null;
                String nome_fun = "", dataadm = "", userfunc = "";

                while (eventType != XmlPullParser.END_DOCUMENT) {

                    if (eventType == XmlPullParser.START_TAG) {
                        atual = xpp.getName();
                    }
                    if (eventType == XmlPullParser.END_TAG) {
                        atual = "";
                    }
                    if (eventType == XmlPullParser.TEXT) {
                        if ("NOME_FUNC".equals(atual)) {
                            nome_fun = xpp.getText();
                            k++;
                        }

                        if ("DTADMI_FUNC".equals(atual)) {
                            userfunc = xpp.getText();
                            k++;
                        }
                        if ("USUARIO_FUNC".equals(atual)) {
                            dataadm = xpp.getText();
                            k++;
                        }

                    }
                    eventType = xpp.next();

                    if (k == 4) {

                        tab card = new tab(nome_fun, dataadm, userfunc);
                        cardArrayAdapter.add(card);

                        nome_fun = "";
                        userfunc = "";
                        dataadm = "";
                        k = 0;
                    }
                }

            }

            listax.setAdapter(cardArrayAdapter);
        } catch (Exception e) {

        }
    }
    
}

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.resultado, menu);
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
    }*/
