<?php
function connect(){
	//$data = parse_ini_file("connect.ini");
	//$conn = @mysqli_connect($data['servername'],$data['username'],$data['$password'],$data['dbname']);
	$conn = @mysqli_connect("localhost","root","","makeawish");
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