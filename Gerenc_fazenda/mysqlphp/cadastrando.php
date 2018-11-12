<html>
<head>
<meta http-equiv="Content-Type" content="site/html; charset=utf-8" />
<title>Administrador | Cadastro</title>
</head>
 
 <body>

 <?php
 
include("conexao.php"); 
 
	$RM=$_POST["RM"];
	$nome=$_POST["nome"];			    
	$senha=$_POST["senha"];
	$csenha=$_POST["csenha"]; 
	$turma=$_POST["turma"];
 
 //Inserindo dados no bd
 
  if($senha != $csenha){
 
	echo "<script language=javascript>alert( 'As senhas tem que ser iguais ' ); window.location='http://localhost/site/index.html';</script>";
	
 }
 
 
 if($senha == $csenha){
	
	
	
		$RM=$_POST["RM"];
		$nome=$_POST["nome"];			    
		$senha=$_POST["senha"];
		$csenha=$_POST["csenha"]; 
		$turma=$_POST["turma"];
	
		echo "<script language=javascript>alert( 'CADASTRADO COM SUCESSO! Por favor faça o seu login. ' ); window.location='http://localhost/site/index.html'; </script>";
		
		$sql= "UPDATE `cadastro_pessoa` SET `SENHA` ='$senha', `TURMA` = '$turma' WHERE RM = $RM";
		echo $sql;
		$resultado=mysqli_query($con, $sql);
		
		
		
	}



 ?>
 
 
</body>
</html>