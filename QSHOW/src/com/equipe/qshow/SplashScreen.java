package com.equipe.qshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

@SuppressWarnings("unused")
public class SplashScreen extends Activity implements Runnable{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
	//Declara��o do m�todo Handler (Splash), que determinar� o tempo de execu��o da SplashScreen.
	Handler Splash = new Handler();
	Splash.postDelayed(SplashScreen.this, 3000);
	}
	
	
	//Declara��o do m�todo run(), que iniciar� a activity de busca, e finalizar� a SplashScreen.
	public void run(){
		startActivity(new Intent(SplashScreen.this,QSHOW.class));
		finish();
	}
}
