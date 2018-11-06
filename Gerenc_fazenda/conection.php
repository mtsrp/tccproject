<?php
$servername = "localhost";
$database = "Gerenc_fazendadb";
$username = "root";
$password = "senha1234";

//Dados para conexão

$conn = mysqli_connect($servername, $username, $password, $database);

// Não necessario em projeto Local

// Checando a conexão


if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
    // Caso gere erro na conexão com o banco retorna a mensagem do mySql
}

?>
