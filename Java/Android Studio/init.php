<?php

$host = "localhost";
$user_name = "id10178505_wimsa_app"
$user_password = "Manitowoc2019"
$db_name = "id10178505_wimsa"

$con = mysqli_connect($host,$user_name,$user_password,$db_name);

if($con)
echo "Connection success...";
else
echo "Connection Failed..."

?>