<?php
	$con = mysqli_connect("localhost","my_email","my_password","my_db");

	$first_name = $_POST["first_name"];
	$last_name = $_POST["last_name"];
	$email = $_POST["email"];
	$password= $_POST["password"];
	$ice_machines = $_POST["ice_machines"];

	$statement = mysqli_prepare($con, "INSERT INTO USERS (first_name,last_name,email,password,ice_machines" VALUES (?,?,?,?,?);
	mysqli_stmt_bind_param($statement, "sssss", $first_name,$last_name,$email,$password,$ice_machines);
	mysqli_stmt_execute($statement);
	
	mysqli_close($con);


?>