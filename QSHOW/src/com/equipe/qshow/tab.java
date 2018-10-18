package com.equipe.qshow;

public class tab {
	//Declaração das váriaveis que corresponderão aos dados pesquisados no aplicativo.
    private String NOME_ARTISTA;
    private String DATA_SHOW;
    private String LOCAL_SHOW;
    private String FOTO_ARTISTA;
  
    public tab(String NOME_ARTISTA, String DATA_SHOW, String LOCAL_SHOW, String FOTO_ARTISTA){
    	this.NOME_ARTISTA = NOME_ARTISTA;
    	this.DATA_SHOW = DATA_SHOW;
    	this.LOCAL_SHOW = LOCAL_SHOW;
    	this.FOTO_ARTISTA = FOTO_ARTISTA;
    }

    /*Getters e Setters das varáveis que serão usadas para receber os dados dos artistas
    ou cidades pesquisados no aplicativo.*/
	
    public String getNOME_ARTISTA() {
		return NOME_ARTISTA;
	}

	public String getDATA_SHOW() {
		return DATA_SHOW;
	}

	public String getLOCAL_SHOW() {
		return LOCAL_SHOW;
	
    }
	
	public String getFOTO_ARTISTA(){
		return FOTO_ARTISTA;
	}
}