<?php
	$con = mysqli_connect("localhost","my_email","my_password","my_db");

	$email = $_POST["email"];
	$password= $_POST["password"];
	$ice_machines = $_POST["ice_machines"]
	

	$statement = mysqli_prepare($con, "SELECT email,ice_machines FROM Users WHERE email = ? AND password = ?");
	mysqli_stmt_bind_param($statement, "ss", $email,$password);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_resultk($statement);
	mysqli_stmt_bind_result($statement,$email,$ice_machine);

	$user = array();

	while(mysqli_stmt_fetch($statement)){
		$user[name] = $name;
		$user[ice_machines] = $ice_machines;
	}

	echo json_encode($user);
	
	mysqli_stmt_close($statement);
	
	mysqli_close($con);


?>