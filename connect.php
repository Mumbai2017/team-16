<?php
echo "ffffffff";
function connect(){
<<<<<<< HEAD
	//$data = parse_ini_file("connect.ini");
	//$conn = @mysqli_connect($data['servername'],$data['username'],$data['$password'],$data['dbname']);
	$conn = @mysqli_connect("localhost","root","","makeawish");
=======
	$data = parse_ini_file("connect.ini");
	//$conn = @mysqli_connect($data['servername'],$data['username'],$data['$password'],$data['dbname']);
	$conn = @mysqli_connect("localhost","root","m3gARooT","team16");
	echo $conn;
		return $conn;
>>>>>>> e501da8f2143b4eceb191a78767a021761c97564
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