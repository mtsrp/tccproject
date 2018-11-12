<html>
<head>
<meta http-equiv="Content-Type" content="site/html; charset=utf-8" />
<title>logando Certo</title>
</head>
 
 <body>

 <?php
 
 
include("conection.php");
session_start();

$USUARIO_FUNC=$_GET["USUARIO_FUNC"];
$SENHA_FUNC=$_GET["SENHA_FUNC"];


$_SESSION['USUARIO_FUNC']=$USUARIO_FUNC;




$sql = "SELECT USUARIO_FUNC,SENHA_FUNC  FROM funcionarios WHERE USUARIO_FUNC = '$USUARIO_FUNC' AND SENHA_FUNC = '$SENHA_FUNC' ";

$query = mysqli_query($con, $sql);
$result= mysqli_fetch_row($query);
 

 
 if($result == true )
{
 
	echo "<script language=javascript>alert( ' Login efetuado com sucesso! Bem Vindo Professor ' ); window.location='http://localhost/site/Notas/PagProf.php'; </script>";
	
 }
 
else

 {
 
	$sql = "SELECT USUARIO_FUNC,SENHA_FUNC  FROM funcionarios WHERE USUARIO_FUNC = '$USUARIO_FUNC';
	$query = mysqli_query($con, $sql);
	$result= mysqli_fetch_row($query);
	
	if($result == true)
	{
			
		echo "<script language=javascript>alert( ' Login efetuado com sucesso! Bem Vindo  Aluno ' ); window.location='http://localhost/site/Notas/PagAluno.php'; </script>";
			
	}
	
	else
	{
		
		echo "<script language=javascript>alert( ' Login ou senha estão incorretos. Ou seu nivel de acesso não é peUSUARIO_FUNCitido.' ); window.location='http://localhost/site/index.html'; </script>";
		
	}


}

		

?>


</head>
</html>
