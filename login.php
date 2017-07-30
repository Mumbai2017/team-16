<?php
include 'connect.php';
	$conn = connect();
	//$data = json_decode('logindata');
	$aadhar_id = $_POST['aadhar_id'];
    $password = $_POST['password'];
	$query = "SELECT * FROM person WHERE aadhar_id=$aadhar_id AND password='$password'";
	$response = @mysqli_query($conn, $query);
    if($response){
		while($row = mysqli_fetch_array($response)){
			$result = array();
			$return["Status"] = "Success";
			$return["aadhar_id"] = $row[0];
			$return["username"] = $row[1];
			$return["doctor"] = $row[2];
			$return["volunteer"] = $row[3];
			$return["donor"] = $row[4];
		}
		echo json_encode($return);
    } 
	else {
		echo mysqli_error($conn);
        $return["Status"] = "Error logging in";
        echo json_encode($return);
    }
?>
