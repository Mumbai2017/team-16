<?php
echo "ffffffff";
function connect(){
	$data = parse_ini_file("connect.ini");
	//$conn = @mysqli_connect($data['servername'],$data['username'],$data['$password'],$data['dbname']);
	$conn = @mysqli_connect("localhost","root","m3gARooT","team16");
	echo $conn;
		return $conn;
	if (!$conn){
		echo $error='{"error":"Could not connect"}';
		exit;
	}	
	else
	{
		echo "connected";
		return $conn;
	}
}
function disconnect($conn){
	mysqli_close($conn);
}
?>