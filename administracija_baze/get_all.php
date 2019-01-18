<?php

$response = array();

require('db_connection.php');
$query = "SELECT * FROM muzej";
$result = mysqli_query($con,$query) or die (mysqli_error($con));

if(mysqli_num_rows($result) >0){
	$response["muzeji"] = array();

	while($row = mysqli_fetch_array($result)){
		$muzej = array();
		$muzej["id"] = $row["id"];
		$muzej["naziv"] = $row["NAZIV"];
		$muzej["telefon"] = $row["TELEFON"];
		$muzej["email"] = $row["EMAIL"];
		$muzej["cijena_ulaznice"] = $row["CIJENA_ULAZNICE"];
		$muzej["opis"] = $row["OPIS"];
		$muzej["latituda"] = $row["LATITUDA"];
		$muzej["longituda"] = $row["LONGITUDA"];
		$muzej["icon"] = $row['ICON'];
		
		array_push($response["muzeji"],$muzej);
	}
	$response["success"] = 1;

	echo json_encode($response);
   }else{
   	$response["success"] = 0;
   	$response["message"] = "nije uspjelo";

   	echo json_encode($response);
   }
 ?>
