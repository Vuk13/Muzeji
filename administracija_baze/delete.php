<?php 
require('db_connection.php');
$id=$_REQUEST['id'];
$query = "DELETE FROM muzej WHERE id=$id";
$result = mysqli_query($con,$query) or die (mysqli_error($con));
header("Location: view.php");
?>s