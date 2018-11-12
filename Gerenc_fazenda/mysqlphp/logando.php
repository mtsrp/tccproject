
 <?php
 
 
include("conection.php");
session_start();

$user_funcx=$_GET["USUARIO_FUNC"];
$senha_funcx=$_GET["SENHA_FUNC"];

$sql = "SELECT `USUARIO_FUNC`,`SENHA_FUNC`  FROM `funcionarios` WHERE `USUARIO_FUNC` = '$user_funcx' AND `SENHA_FUNC` = '$senha_funcx' ";

$query = mysqli_query($con, $sql);
$result= mysqli_fetch_row($query);
 

 
 if($result == true )
{
 
	echo " Login efetuado com sucesso! Bem Vindo Professor ";
	
 }
 
else

 {
 
	$sql = "SELECT `USUARIO_FUNC`, `SENHA_FUNC`  FROM 'funcionarios' WHERE `USUARIO_FUNC` = '$user_funcx'";
	$query = mysqli_query($con, $sql);
	$result= mysqli_fetch_row($query);
	
	if($result == true)
	{
			
		echo " Login efetuado com sucesso! Bem Vindo  Aluno ";
			
	}
	
	else
	{
		
		echo "login ou senha invalidos";
		
	}


}

		

?>
