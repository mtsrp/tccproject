<?php
 
include("conection.php"); 
 
	$NOME_FUNC=$_POST["NOME_FUNC"];
	$DTADMI_FUNC= $_POST["DTADMI_FUNC"];
	$DTDEMIS_FUNC= $_POST["DTDEMIS_FUNC"]		    
	$SENHA_FUNC=$_POST["SENHA_FUNC"];
 
 //Inserindo dados no bd
  
 if($SENHA_FUNC != null){
	
	
		$NOME_FUNC=$_POST["NOME_FUNC"];
		$DTADMI_FUNC= $_POST["DTADMI_FUNC"];			    
		$SENHA_FUNC=$_POST["SENHA_FUNC"];
	
		echo "CADASTRADO COM SUCESSO! Por favor faça o seu login.";
		
		$sql= "INSERT `funcionarios` SET `SENHA_FUNC` ='$SENHA_FUNC', `DTADMI_FUNC` = $DTADMI_FUNC  WHERE NOME_FUNC = $NOME_FUNC";
		echo $sql;
		$resultado=mysqli_query($con, $sql);
		
		
	}
 ?>
 