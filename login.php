<?php
include 'connect.php';
	$data = json_decode('logindata');
	$aadhar_id = $data['aadhar_id'];
    $password = $data['password'];
	$query = "SELECT * FROM person WHERE aadhar_id=$aadhar_id AND password=$password";
	$response = @mysqli_query($conn, $query);
    if($response){
		while($row = mysqli_fetch_array($response)){
			$result = arrray();
			$return["Status"] = "Success";
			$return["aadhar_id"] = $row[0];
			$return["username"] = $row[1];
			$return["doctor"] = $row[3];
			$return["volunteer"] = $row[4];
			$return["donor"] = $row[5];
		}
		echo json_encode($return);
    } 
	else {
        $return["Status"] = "Error logging in";
        echo json_encode($return);
    }
}
?>
