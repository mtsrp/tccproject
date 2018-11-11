package com.software.engenharia.gerenc_fazenda.Funcionario;

public class tab {
	//Declara��o das v�riaveis que corresponder�o aos dados pesquisados no aplicativo.
    private String NOME_FUNC;
    private String DTADMI_FUNC;
    private String USUARIO_FUNC;

    public tab(String NOME_FUNC, String DTADMI_FUNC, String USUARIO_FUNC){
    	this.NOME_FUNC = NOME_FUNC;
    	this.DTADMI_FUNC = DTADMI_FUNC;
    	this.USUARIO_FUNC = USUARIO_FUNC;
    }

    /*Getters e Setters das var�veis que ser�o usadas para receber os dados dos artistas
    ou cidades pesquisados no aplicativo.*/
	
    public String getNOME_FUNC() {
		return NOME_FUNC;
	}

	public String getDTADMI_FUNC() {
		return DTADMI_FUNC;
	}

	public String getUSUARIO_FUNC() {
		return USUARIO_FUNC;
    }

}