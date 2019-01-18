<?php 
require('db_connection.php');
$id=$_REQUEST['id'];
$query = "DELETE FROM image WHERE id_img=$id";
$result = mysqli_query($con,$query) or die (mysqli_error($con));
header("Location: view_slike.php");
?>