<html>
<head>
<meta http-equiv="Content-Type" content="site/html; charset=utf-8" />
<title>Administrador | Cadastro</title>
</head>
 
 <body>

 <?php
 
include("conection.php"); 
 
	$NOME_FUNC=$_POST["NOME_FUNC"];
	$DTADMI_FUNC= $_POST["DTADMI_FUNC"];		    
	$SENHA_FUNC=$_POST["SENHA_FUNC"];
	$cSENHA_FUNC=$_POST["cSENHA_FUNC"]; 
 
 //Inserindo dados no bd
 
  if($SENHA_FUNC != $cSENHA_FUNC){
 
	echo "<script language=javascript>alert( 'As SENHA_FUNCs tem que ser iguais ' ); </script>";
	
 }
 
 
 if($SENHA_FUNC == $cSENHA_FUNC){
	
	
		$NOME_FUNC=$_POST["NOME_FUNC"];
		$DTADMI_FUNC= $_POST["DTADMI_FUNC"];			    
		$SENHA_FUNC=$_POST["SENHA_FUNC"];
		$cSENHA_FUNC=$_POST["cSENHA_FUNC"]; 
	
		echo "<script language=javascript>alert( 'CADASTRADO COM SUCESSO! Por favor faça o seu login. ' ); window.location='http://localhost/site/index.html'; </script>";
		
		$sql= "UPDATE `funcionarios` SET `SENHA_FUNC` ='$SENHA_FUNC', `DTADMI_FUNC` = $DTADMI_FUNC  WHERE NOME_FUNC = $NOME_FUNC";
		echo $sql;
		$resultado=mysqli_query($con, $sql);
		
		
	}



 ?>
 
 
</body>
</html>