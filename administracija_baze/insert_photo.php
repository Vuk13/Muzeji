<!DOCTYPE html>
<head>
	<title> Dodavanje slika </title>
</head>
<body>
	<a href="index.html">HOME</a>
<?php 
require('db_connection.php');

	$status="";
	if(isset($_POST['new']) && $_POST['new']==1){
			$ime = $_POST['imena_muzeja'];
			$ime_query = "SELECT * FROM muzej WHERE NAZIV='".$ime."'";
			$rez = mysqli_query($con,$ime_query);
			$row = mysqli_fetch_assoc($rez);
			$muzej_id=$row['id'];
			$imgURL = $_REQUEST['imgURL'];
			$query2 = "INSERT INTO image(`image_url`,`muzej_id`) VALUES ('$imgURL','$muzej_id')";
			mysqli_query($con,$query2) or die(mysqli_error($con));
			$status = "Nova fotografija uspjesno dodata.
			    </br></br><a href='view_slike.php'>Pogledajte unesenu fotografiju</a>";
			}

?>
		<form name="form" method="post" action="">
		<p>Muzej: </p>
		<select name='imena_muzeja', id='imena_muzeja'>
			<?php 
				require('db_connection.php');

				$query = "SELECT * FROM muzej ORDER BY id desc";
				$result = mysqli_query($con,$query);
				while ($row = mysqli_fetch_assoc($result)) {
				   echo '<option value="'.$row['NAZIV'].'">'.$row['NAZIV'].'</option>';
				}
			?>
		</select>
		<p>Dodaj sliku</p>
		<input type="hidden" name="new" value="1" />
		<p><input type="text" name="imgURL" placeholder="Unesite URL slike" required /></p>
		<p><input name="submit" type="submit" value="Submit" /></p>
		<p style="color:#FF0000;"><?php echo $status; ?></p>
		</form>
</body>
</html>