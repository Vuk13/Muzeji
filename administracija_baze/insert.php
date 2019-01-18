<?php
require ('db_connection.php');
$status = "";
if(isset($_POST['new']) && $_POST['new']==1){
	$naziv =$_REQUEST['naziv'];
    $telefon = $_REQUEST['telefon'];
    $email =$_REQUEST['email'];
    $cijena_ulaznice = $_REQUEST['cijena_ulaznice'];
    $opis =$_REQUEST['opis'];
    $latituda = $_REQUEST['latituda'];
    $longituda =$_REQUEST['longituda'];
    $icon = $_REQUEST['icon'];
    $ins_query = "insert into muzej(`NAZIV`,`TELEFON`,`EMAIL`
    ,`CIJENA_ULAZNICE`,`OPIS`,`LATITUDA`,`LONGITUDA`,`ICON`)values('$naziv','$telefon','$email','$cijena_ulaznice','$opis','$latituda','$longituda','$icon')";
    mysqli_query($con,$ins_query)
    or die(mysqli_error($con));
    $status = "Novi podatak uspjesno dodat.
    </br></br><a href='view.php'>Pogledajte uneseni podatak</a>";
}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Unos novog podatka</title>
</head> 
<body>
	<div class = "form">
		<p> <a href="view.php">Pregled podataka</a>
		</p>
	<div>
	<h1>Unesite novi podatak</h1>
	<form name="form" method="post" action="">
		<input type="hidden" name="new" value="1" />
		<p><input type="text" name="naziv" placeholder="Unesite naziv" required /></p>
		<p><input type="text" name="telefon" placeholder="Unesite broj telefona" required /></p>
		<p><input type="text" name="email" placeholder="Unesite email" required /></p>
		<p><input type="text" name="cijena_ulaznice" placeholder="Unesite cijenu ulaznice" required /></p>
		<p><input type="text" name="opis" placeholder="Unesite opis" required /></p>
		<p><input type="text" name="latituda" placeholder="Unesite latitudu" required /></p>
		<p><input type="text" name="longituda" placeholder="Unesite longitudu" required /></p>
		<p><input type="text" name="icon" placeholder="Unesite url ikonice" required /></p>	
		<p><input name="submit" type="submit" value="Submit" /></p>
	</form>
	<p style="color:#FF0000;"><?php echo $status; ?></p>
	</div>
	</div>
</body>
</html>












