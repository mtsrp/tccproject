package com.equipe.qshow;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Artista extends Activity {
	
	//Declaração das váriavéis dos objetos presentes na tela de dados do Artista/Show, "Artista".
	TextView artista, Biografia, local, cidade, data, sobreshow, ingresso;
	String Textfoto;
	ImageView imagemArtista;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_artista);		
		
		//Instanciação dos objetos utilizados na quarta tela do projeto, "Artista".
		imagemArtista = (ImageView) findViewById(R.id.imagemArtista);
		artista = (TextView) findViewById(R.id.txtArtista);
		Biografia = (TextView) findViewById(R.id.txtBiografia);
		local = (TextView) findViewById(R.id.txtlocaldoShow);
		cidade = (TextView) findViewById(R.id.txtCidade);
		data = (TextView) findViewById(R.id.txtDiadoShow);
		sobreshow = (TextView) findViewById(R.id.txtSobreOShow);
		ingresso = (TextView) findViewById(R.id.txtLinkCompra);
		ingresso.setMovementMethod(LinkMovementMethod.getInstance());
		
		
		/*Os dados do Artista e do Show serão exibidos, caso não haja conexão ou um erro seja encontrado,
		informações padrão aparecerão na tela e uma mensagem será exibida.*/
		try{	
		getDados();
		getFotoArtista();
		
		}catch (Exception e) {
			int duration = 4000;
			Toast toast = Toast.makeText(getApplicationContext(), "ERRO, exibindo informações padrão.", duration);
	    	toast.show();
		}
		
	}
	
	//Método de busca do artista no PHP.
	private InputStream busca() throws IOException{ 
		URL url = new URL("http://equipeqshow.webuda.com//artista.php?nome_artista="+Resultado.artistax+"&data_show="+Resultado.datax+"&cidade_show="+Resultado.cidadex);
		return url.openConnection().getInputStream();
    }
	
	
	//Onde será feita a busca dos dados do Artista pesquisado e do Show escolhido na ListView no XML.
	private void getDados() {
			try {
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				XmlPullParser xpp = factory.newPullParser();
				xpp.setInput(busca(), null);
				if (xpp!=null) {
					int eventType = xpp.getEventType();
					String atual = null;
							
					while (eventType != XmlPullParser.END_DOCUMENT) {
						
						if (eventType == XmlPullParser.START_TAG) {
							atual = xpp.getName();
						}
						if (eventType == XmlPullParser.END_TAG) {
							atual = "";
						}
					
						if (eventType == XmlPullParser.TEXT) {
							if ("NOME_ARTISTA".equals(atual)) {
								
								artista.setText(xpp.getText().toString().replace("_", " "));
							}
							
							if ("DATA_SHOW".equals(atual)) {
								
								data.setText(xpp.getText().toString());
							
							}
							
							if ("CIDADE_SHOW".equals(atual)) {
								
								cidade.setText(xpp.getText().toString().replace("Sao Paulo", "São Paulo"));
								
							}
							
							if ("LOCAL_SHOW".equals(atual)) {
								
								local.setText(xpp.getText().toString());
							
							}
							
							if ("INGRESSO_SHOW".equals(atual)) {
								
								ingresso.setText(xpp.getText().toString());
							
							}
							

							if ("SOBRE_SHOW".equals(atual)) {
								
								sobreshow.setText(xpp.getText().toString());
								
							}
							
							if ("SOBRE_ARTISTA".equals(atual)) {
								
								Biografia.setText(xpp.getText().toString());
								
							}
							
                            if ("FOTO_ARTISTA".equals(atual)) {
								
								Textfoto=xpp.getText();
								
							}
							
						}
						
						eventType = xpp.next();						
					}										
				}}catch (Exception e) {
			}
			} 	
	

	//Método de busca da imagem do Artista pesquisado no próprio aplicativo, de acordo com o nome do mesmo.
	private void getFotoArtista() {
		// TODO Auto-generated method stub
		if (Textfoto.equals("aha")){
 			 imagemArtista.setImageResource(R.drawable.aha);
 		}
  		if (Textfoto.equals("alok")){
 			 imagemArtista.setImageResource(R.drawable.alok);
 		}
  		if (Textfoto.equals("cidadenegra")){
 			 imagemArtista.setImageResource(R.drawable.cidadenegra);
 		}
  		if (Textfoto.equals("cpm")){
 			imagemArtista.setImageResource(R.drawable.cpm);
 		}
  		if (Textfoto.equals("deftones")){
 			 imagemArtista.setImageResource(R.drawable.deftones);
 		}
  		if (Textfoto.equals("delatierra")){
 			 imagemArtista.setImageResource(R.drawable.delatierra);
 		}
  		if (Textfoto.equals("eltonjohn")){
 			 imagemArtista.setImageResource(R.drawable.eltonjohn);
 		}
  		if (Textfoto.equals("faithnomore")){
  			imagemArtista.setImageResource(R.drawable.faithnomore);
 		}
  		if (Textfoto.equals("felguk")){
  			imagemArtista.setImageResource(R.drawable.felguk);
 		}
  		if (Textfoto.equals("gojira")){
  			imagemArtista.setImageResource(R.drawable.gojira);
 		}
  		if (Textfoto.equals("hollywoodvampires")){
  			imagemArtista.setImageResource(R.drawable.hollywoodvampires);
 		}
  		if (Textfoto.equals("johnlegend")){
  			imagemArtista.setImageResource(R.drawable.johnlegend);
 		}
  		if (Textfoto.equals("katyperry")){
  			imagemArtista.setImageResource(R.drawable.katyperry);
 		}
  		if (Textfoto.equals("korn")){
  			imagemArtista.setImageResource(R.drawable.korn);
 		}
  		if (Textfoto.equals("lambofgod")){
  			imagemArtista.setImageResource(R.drawable.lambofgod);
 		}
  		if (Textfoto.equals("lulusantos")){
  			imagemArtista.setImageResource(R.drawable.lulusantos);
 		}
  		if (Textfoto.equals("magic")){
  			imagemArtista.setImageResource(R.drawable.magic);
 		}
  		if (Textfoto.equals("mastodon")){
  			imagemArtista.setImageResource(R.drawable.mastodon);
 		}
  		if (Textfoto.equals("metallica")){
  			imagemArtista.setImageResource(R.drawable.metallica);
 		}
  		if (Textfoto.equals("motleycrue")){
  			imagemArtista.setImageResource(R.drawable.motleycrue);
 		}
  		if (Textfoto.equals("onerepublic")){
  			imagemArtista.setImageResource(R.drawable.onerepublic);
 		}
  		if (Textfoto.equals("paralamasdosucesso")){
  			imagemArtista.setImageResource(R.drawable.paralamasdosucesso);
 		}
  		if (Textfoto.equals("queen")){
  			imagemArtista.setImageResource(R.drawable.queen);
 		}
  		if (Textfoto.equals("queensofthestoneage")){
  			imagemArtista.setImageResource(R.drawable.queensofthestoneage);
 		}
  		if (Textfoto.equals("rihanna")){
  			imagemArtista.setImageResource(R.drawable.rihanna);
 		}
  		if (Textfoto.equals("robyn")){
  			imagemArtista.setImageResource(R.drawable.robyn);
 		}
  		if (Textfoto.equals("rodstewart")){
  			imagemArtista.setImageResource(R.drawable.rodstewart);
 		}
  		if (Textfoto.equals("royalblood")){
  			imagemArtista.setImageResource(R.drawable.royalblood);
 		}
  		if (Textfoto.equals("samsmith")){
  			imagemArtista.setImageResource(R.drawable.samsmith);
 		}
  		if (Textfoto.equals("sheppard")){
  			imagemArtista.setImageResource(R.drawable.sheppard);
 		}
  		if (Textfoto.equals("slipknot")){
  			imagemArtista.setImageResource(R.drawable.slipknot);
 		}
  		if (Textfoto.equals("systemofadown")){
  			imagemArtista.setImageResource(R.drawable.systemofadown);
 		}
  		if (Textfoto.equals("thescript")){
  			imagemArtista.setImageResource(R.drawable.thescript);
 		}
  		if (Textfoto.equals("tropkillaz")){
 			 imagemArtista.setImageResource(R.drawable.tropkillaz);
 		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.artista, menu);
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
