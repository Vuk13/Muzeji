<?php 
	require('db_connection.php');
?>
<!DOCTYPE html>
<head>
	<title>Pregled fotografija</title>
</head>
<body>
	<a href="index.html">HOME</a>
	<h2> Pregled fotografija </h2>
	<table width="100%" border = "1" style = "border-collapse: collapse;">
		<thead>
			<tr>
				<th><strong>ID</strong></th>
				<th><strong>ID MUZEJA</strong></th>
				<th><strong>Slika</strong></th>
			</tr>
		</thead>
	<tbody>
	<?php
	$count=1;
	$sel_query="Select * from image ORDER BY id_img desc;";
	$result = mysqli_query($con,$sel_query);
	while($row = mysqli_fetch_assoc($result)) {?>
		<tr><td align="center"><?php echo $row["id_img"]; ?></td>
			<td align="center"><?php echo $row["muzej_id"]; ?></td>
			<td align="center"><img src="<?php echo $row["image_url"]; ?>" width="350" height="200"></td>
			
			<td align="center">
			<a href="delete_photo.php?id=<?php echo $row["id_img"]; ?>">Delete</a>
			</td>
			</tr>
		<?php $count++; }?>
	</tbody>
</body>
</html>