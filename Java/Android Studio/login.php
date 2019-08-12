<?php

require "init.php";
$user_email = $_GET["email"];
$user_password = $_GET["password"];

$sql = "SELECT first_name,last_name,ice_machines from Users where email = '$user_email' and password = '$user_password'";

$result = mysqli_query($con,$sql);

if(!mysqli_num_rows($result)>0)
{
    $status = "failed";
    echo json_encode(array("response"=>$status));
}
else
{
    $row = mysqli_fetch_assoc($result);
    $f_name = $row['first_name'];
    $l_name = $row['last_name'];
    $ice_machines = $row['ice_machines'];
    echo json_encode(array("response"=>$status,"first_name"=>$f_name,"last_name"=>$l_name,"ice_machines"=>$ice_machines));
}

mysqli_close();

?>