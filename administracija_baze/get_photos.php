<?php

$response = array();

require('db_connection.php');
$query = "SELECT * FROM image";
$result = mysqli_query($con,$query) or die (mysqli_error($con));

if(mysqli_num_rows($result) >0){
	$response["slike"] = array();

	while($row = mysqli_fetch_array($result)){
		$slike = array();
		$slika["id_img"] = $row["id_img"];
		$slika["muzej_id"] = $row["muzej_id"];
		$slika["image_url"] = $row["image_url"];
		
		array_push($response["slike"],$slika);
	}
	$response["success"] = 1;

	echo json_encode($response);
   }else{
   	$response["success"] = 0;
   	$response["message"] = "nije uspjelo";

   	echo json_encode($response);
   }
 ?>
