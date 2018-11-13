<?php
 
include("conection.php"); 
 
	$NOME_FUNC= $_GET["NOME_FUNC"];
	$USUARIO_FUNC= $_GET["USUARIO_FUNC"];
	$DTADMI_FUNC= $_GET["DTADMI_FUNC"];
	$DTDEMIS_FUNC= $_GET["DTDEMIS_FUNC"];	    
	$SENHA_FUNC= $_GET["SENHA_FUNC"];
 	$PERMISSOES_FUNC= $_GET["PERMISSOES_FUNC"];
 	$ID_SETOR = $_GET["ID_SETOR"];

 //Inserindo dados no bd
  
 if($SENHA_FUNC != null){
	
	
		$NOME_FUNC=$_GET["NOME_FUNC"];
		$USUARIO_FUNC= $_GET["USUARIO_FUNC"];
		$DTADMI_FUNC= $_GET["DTADMI_FUNC"];
		$DTDEMIS_FUNC= $_GET["DTDEMIS_FUNC"];		    			    
		$SENHA_FUNC=$_GET["SENHA_FUNC"];
	 	$PERMISSOES_FUNC= $_GET["PERMISSOES_FUNC"];
	 	$ID_SETOR = $_GET["ID_SETOR"];

		echo "CADASTRADO COM SUCESSO! Por favor faça o seu login.";
		
		$sql= "INSERT INTO `funcionarios` (`NOME_FUNC`, `DTADMI_FUNC`, `DTDEMIS_FUNC`, `USUARIO_FUNC`, `SENHA_FUNC`,`PERMISSOES_FUNC`,`ID_SETOR`) VALUES ('$NOME_FUNC', '$DTADMI_FUNC', '$DTDEMIS_FUNC', '$USUARIO_FUNC', '$SENHA_FUNC', '$PERMISSOES_FUNC', '$ID_SETOR' )";
		echo $sql;
		$resultado=mysqli_query($con, $sql);
		
		
	}
 ?>
 