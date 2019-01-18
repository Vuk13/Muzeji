<?php
require('db_connection.php');
$id=$_REQUEST['id'];
$query = "SELECT * from muzej where id='".$id."'";
$result = mysqli_query($con,$query) or die (mysqli_error($con));
$row = mysqli_fetch_assoc($result);
?>
<!DOCTYPE html>
<head>
	<title>Izmijeni podatak</title>
</head>
<body>
	<div class = "form">
		<p><a href="insert.php">Dodaj novi podatak</a>
	<h1>Izmijeni podatak</h1>
	<?php
	$status = "";
	if(isset($_POST['new']) && $_POST['new']==1)
	{
		$id=$_REQUEST['id'];
		$naziv = $_REQUEST['naziv'];
		$telefon = $_REQUEST['telefon'];
		$email =$_REQUEST['email'];
	    $cijena_ulaznice = $_REQUEST['cijena_ulaznice'];
	    $opis =$_REQUEST['opis'];
	    $latituda = $_REQUEST['latituda'];
	    $longituda =$_REQUEST['longituda'];
	    $icon =$_REQUEST['icon'];
	    $update ="update muzej set NAZIV='".$naziv."', TELEFON='".$telefon."',EMAIL='".$email."', CIJENA_ULAZNICE='".$cijena_ulaznice."',OPIS='".$opis."', LATITUDA='".$latituda."', LONGITUDA='".$longituda."', ICON='".$icon."' where id='".$id."'";
	    mysqli_query($con,$update) or die(mysqli_error($con));
	    $status = "Podatak uspjesno izmijenjen. </br></br>
	    <a href='view.php'>Pogledajte promijenjeni podatak</a>";
	    echo '<p style="color:#FF0000;">'.$status.'</p>';
	}else{?>
	<div>
		<form name="form" method="post" action="">
		<input type="hidden" name="new" value="1" />
		<input name="id" type="hidden" value="<?php echo $row['id'];?>" />
		<p><input type="text" name="naziv" placeholder="Unesite naziv" required value="<?php echo $row['NAZIV'];?>"/></p>
		<p><input type="text" name="telefon" placeholder="Unesite telefon" required value="<?php echo $row['TELEFON'];?>"/></p>
		<p><input type="text" name="email" placeholder="Unesite email" required value="<?php echo $row['EMAIL'];?>"/></p>
		<p><input type="text" name="cijena_ulaznice" placeholder="Unesite cijenu ulaznice" required value="<?php echo $row['CIJENA_ULAZNICE'];?>"/></p>
		<p><input type="text" name="opis" placeholder="Unesite opis" required value="<?php echo $row['OPIS'];?>"/></p>
		<p><input type="text" name="latituda" placeholder="Unesite latitudu" required value="<?php echo $row['LATITUDA'];?>"/></p>
		<p><input type="text" name="longituda" placeholder="Unesite longitudu" required value="<?php echo $row['LONGITUDA'];?>"/></p>
		<p><input type="text" name="icon" placeholder="Unesite url ikonice" required value="<?php echo $row['ICON'];?>"/></p>
		<p><input name="submit" type="submit" value="Update" /></p>
	</form>
<?php } ?>
</div>
</div>
</body>
</html>