﻿<?php
$servername = "localhost";
$database = "fazenda";
$username = "root";
$password = "";

//Dados para conexão

$con = mysqli_connect($servername, $username, $password, $database);

// Não necessario em projeto Local

// Checando a conexão


if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
    // Caso gere erro na conexão com o banco retorna a mensagem do mySql
}

echo "conexão com sucesso";

?>