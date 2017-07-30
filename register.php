<?php
include 'connect.php';
	$conn = connect();
	//$_POST = json_decode('personinsert');
	$aadhar_id = (int)$_POST['email'];
	$password = $_POST['password'];
	if($password == NULL || $password == ""){
		$return["Status"] = "Please enter a password";
        echo json_encode($return);	
		exit;
	}
	$type_doctor = 0;//(int)$_POST['type_doctor'];
	$type_volunteer = 0;//(int)$_POST['type_volunteer'];
	$type_donor = 0;//(int)$_POST['type_donor'];
	$query = "SELECT name FROM aadhar WHERE aadhar_id=$aadhar_id";
	$response = @mysqli_query($conn, $query);
	if($response){
		while($row = mysqli_fetch_array($response))
			$username = $row[0];
	}
	else{
		$return["Status"] = "Wrong aadhar id";
        echo json_encode($return);	
		exit;
	}
	$query = "INSERT INTO person(aadhar_id,password,type_doctor,type_donor,
	type_volunteer) 
	VALUES($aadhar_id,'$password',$type_doctor,$type_donor,$type_volunteer)";
	$response = @mysqli_query($conn, $query);
	if($response){
		$return["Status"] = "Success";
        echo json_encode($return);	
	}  
	else
		echo mysqli_error($conn);
?>