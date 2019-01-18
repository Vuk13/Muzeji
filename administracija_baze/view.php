<?php
require ('db_connection.php');
?>
<!DOCTYPE html>
<html>
<head>
<title> View Records </title>
</head>
<body>
<div class="form">
	<p><a href="index.html">Home</a>
		<a href="insert.php">Dodaj novi podatak</a>
	</p>
	<h2> Pregled podataka </h2>
	<table width="100%" border = "1" style = "border-collapse: collapse;">
		<thead>
			<tr>
				<th><strong>ICON</strong></th>
				<th><strong>ID</strong></th>
				<th><strong>Naziv</strong></th>
				<th><strong>Telefon</strong></th>
				<th><strong>Email</strong></th>
				<th><strong>Cijena ulaznice</strong></th>
				<th><strong>Opis</strong></th>
				<th><strong>Latituda</strong></th>
				<th><strong>Longituda</strong></th>
				<th><strong>Edit</strong></th>
				<th><strong>Delete</strong></th>
			</tr>
		</thead>
	<tbody>
	<?php
	$count=1;
	$sel_query="Select * from muzej ORDER BY id desc;";
	$result = mysqli_query($con,$sel_query);
	while($row = mysqli_fetch_assoc($result)) {?>
		<tr><td align="center"><?php echo $row["ICON"]; ?></td>
			<td align="center"><?php echo $row["id"]; ?></td>
			<td align="center"><?php echo $row["NAZIV"]; ?></td>
			<td align="center"><?php echo $row["TELEFON"]; ?></td>
			<td align="center"><?php echo $row["EMAIL"]; ?></td>
			<td align="center"><?php echo $row["CIJENA_ULAZNICE"]; ?></td>
			<td align="center"><?php echo $row["OPIS"]; ?></td>
			<td align="center"><?php echo $row["LATITUDA"]; ?></td>
			<td align="center"><?php echo $row["LONGITUDA"]; ?></td>
			<td align="center">

			<a href="edit.php?id=<?php echo $row["id"]; ?>">Edit</a>
			</td>
			<td align="center">
			<a href="delete.php?id=<?php echo $row["id"]; ?>">Delete</a>
			</td>
			</tr>
		<?php $count++; }?>
	</tbody>
</table>
</div>
</body>
</html>

