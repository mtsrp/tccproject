
package com.equipe.qshow;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Resultado extends Activity {
	
	//Declaração das váriaves dos objetos presentes na tela de resultados da busca, "Resultado". 
	String row1, row2, row3;
	public static String artistax="", datax="", cidadex="";
    private CardArrayAdapter cardArrayAdapter;
	private ListView listax ;
	int k=0;
	String foto = "";	
	
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
		getDadosCidade();
		}catch(Exception e){
			Toast toast = Toast.makeText(getApplicationContext(), "ERRO, verifique sua conexão com a internet e tente novamente.", Toast.LENGTH_SHORT);
	    	toast.show();
		}
		
		/*Ação feita ao clique do usuário na listax (ListView), que pega o conteúdo da row_personalizada,
		de acordo com o item clicado pelo usúario, e os seta nas váriaves row1, row2, row3, que darão os dados
		do nome do Artista, Data do show e nome da Cidade desse show, e posteriormente, chamará a próxima classe.*/
		listax.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,  long id) {			 
			
			row1 = ((TextView)view.findViewById(R.id.line1)).getText().toString();
			row2 = ((TextView)view.findViewById(R.id.line2)).getText().toString();
			row3 = ((TextView)view.findViewById(R.id.line3)).getText().toString();
			
			artistax=row1.replace(" ", "_");
			datax=row2;
			cidadex=row3.replace("São Paulo", "Sao Paulo");

			   Intent a1 = new Intent(Resultado.this, Artista.class);
			   startActivity(a1);
			}
		});
		 
	}

	//Método de busca do artista no PHP.
	private InputStream busca() throws IOException{    	
    	URL url = new URL("http://equipeqshow.webuda.com//buscaArtistaCidade.php?nome_artista=" + QSHOW.busca);
		return url.openConnection().getInputStream();
    }
	
	//Método de busca da cidade no PHP.
	private InputStream buscaCidade() throws IOException{    	
    	URL url = new URL("http://equipeqshow.webuda.com//buscaCidade.php?nome_artista=" + QSHOW.busca);
		return url.openConnection().getInputStream();
    }
	
	
	 //Onde será feita a busca dos dados do Artista pesquisado no XML.
	 private void getDados() {
			try {
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				XmlPullParser xpp = factory.newPullParser();
				xpp.setInput(busca(), null);
				
				if (xpp!=null) {
					int eventType = xpp.getEventType();
					String atual = null;
					String artista = "", data="",cidade="";									
				
						while (eventType != XmlPullParser.END_DOCUMENT) {					
							
						if (eventType == XmlPullParser.START_TAG) {
							atual = xpp.getName();
						}
						if (eventType == XmlPullParser.END_TAG) {
							atual = "";
						}
					
						if (eventType == XmlPullParser.TEXT) {
							if ("NOME_ARTISTA".equals(atual)) {								
								artista=xpp.getText();
								k++;											
							}

							if ("CIDADE_SHOW".equals(atual)) {								
								cidade=xpp.getText().replace("Sao Paulo", "São Paulo");
								k++;								
							}
							if ("DATA_SHOW".equals(atual)) {								
								data=xpp.getText();								
								k++;
							}
                          if ("FOTO_ARTISTA".equals(atual)) {								
								foto=xpp.getText();
								k++;								
						}					
							
						}
						eventType = xpp.next();
						
						if(k==4){

						tab card = new tab(artista, data, cidade, foto);
						cardArrayAdapter.add(card);
						
						artista="";
						cidade="";
						data="";
						foto="";
						k=0;
						}
					}		
						
				}

				listax.setAdapter(cardArrayAdapter);
			} catch (Exception e) {
				
			}
		
		}
	 
	//Onde será feita a busca dos dados da Cidade pesquisada no XML.
	 private void getDadosCidade() {			
			try {
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				XmlPullParser xpp = factory.newPullParser();
				xpp.setInput(buscaCidade(), null);
				
				if (xpp!=null) {
					int eventType = xpp.getEventType();
					String atual = null;
					String artista = "", data="",cidade="";								
				
						while (eventType != XmlPullParser.END_DOCUMENT) {					
							
						if (eventType == XmlPullParser.START_TAG) {
							atual = xpp.getName();
						}
						if (eventType == XmlPullParser.END_TAG) {
							atual = "";
						}
					
						if (eventType == XmlPullParser.TEXT) {
							if ("NOME_ARTISTA".equals(atual)) {								
								artista=xpp.getText();
								k++;											
							}

							if ("CIDADE_SHOW".equals(atual)) {								
								cidade=xpp.getText().replace("Sao Paulo", "São Paulo");
								k++;								
							}
							if ("DATA_SHOW".equals(atual)) {								
								data=xpp.getText();								
								k++;
							}
                       if ("FOTO_ARTISTA".equals(atual)) {								
								foto=xpp.getText();
								k++;								
						}					
							
						}
						eventType = xpp.next();
						
						if(k==4){

						tab card = new tab(artista, data, cidade, foto);
						cardArrayAdapter.add(card);
						
						artista="";
						cidade="";
						data="";
						foto="";
						k=0;
						}
					}		
						
				}

				listax.setAdapter(cardArrayAdapter);
			} catch (Exception e) {
				Toast toast = Toast.makeText(getApplicationContext(), "ERRO, verifique sua conexão com a internet e tente novamente.", Toast.LENGTH_SHORT);
		    	toast.show();
			}
		
		}

	@Override
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
	}
}
