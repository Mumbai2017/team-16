<?php
function connect(){
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "team-16";
	$conn = @mysqli_connect($servername, $username, $password, $dbname);
	if (!$conn){
		echo $error='{"error":"Could not connect"}';
		exit;
	}	
	else
	{
		return $conn;
	}
}
function disconnect($conn){
	mysqli_close($conn);
}
?>