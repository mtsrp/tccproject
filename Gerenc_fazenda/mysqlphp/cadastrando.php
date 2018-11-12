<?php
 
include("conection.php"); 
 
	$NOME_FUNC= $_GET["NOME_FUNC"];
	$USUARIO_FUNC= $_GET["USUARIO_FUNC"];
	$DTADMI_FUNC= $_GET["DTADMI_FUNC"];
	$DTDEMIS_FUNC= $_GET["DTDEMIS_FUNC"];	    
	$SENHA_FUNC= $_GET["SENHA_FUNC"];
 
 //Inserindo dados no bd
  
 if($SENHA_FUNC != null){
	
	
		$NOME_FUNC=$_GET["NOME_FUNC"];
		$USUARIO_FUNC= $_GET["USUARIO_FUNC"];
		$DTADMI_FUNC= $_GET["DTADMI_FUNC"];
		$DTDEMIS_FUNC= $_GET["DTDEMIS_FUNC"];		    			    
		$SENHA_FUNC=$_GET["SENHA_FUNC"];
	
		echo "CADASTRADO COM SUCESSO! Por favor faça o seu login.";
		
		$sql= "INSERT INTO `funcionarios` (`NOME_FUNC`, `DTADMI_FUNC`, `DTDEMIS_FUNC`, `USUARIO_FUNC`, `SENHA_FUNC`) VALUES ('$NOME_FUNC', '$DTADMI_FUNC', '$DTDEMIS_FUNC', '$USUARIO_FUNC', $SENHA_FUNC)";
		echo $sql;
		$resultado=mysqli_query($con, $sql);
		
		
	}
 ?>
 