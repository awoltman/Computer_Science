<?php

require "init.php";
$f_name = $_GET["first_name"];
$l_name = $_GET["last_name"];
$email = $_GET["email"];
$password = $_GET["password"];
$ice_machines = 'none';

$sql = "SELECT * FROM users WHERE email = '$email'";

$result = mysqli_query($con,$sql);

if($result>0)
{
    $status = "exists";
}
else
{
$sql = "INSERT INTO `Users`(`first_name`, `last_name`, `email`, `password`, `ice_machines`) VALUES ('$f_name','$l_name','$email','$password','$ice_machines')";
    if(mysqli_query($con,$sql) == true)
    {
        $status = "ok";
    }
    else
    {
        $status = "error";
    }
}

echo json_encode(array("response"=>$status));

mysqli_close($con);

?>