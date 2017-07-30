<?php
include 'connect.php';
	$conn = connect();
	$doctor_aadhar = $_POST['doctor_aadhar'];
	//$_POST = json_decode('referalform');
	$aadhar_id = (int)$_POST['aadhar'];
	$query = "SELECT count(aadhar_id) from child where aadhar_id=$aadhar_id";
	$response = @mysqli_query($conn, $query);
	if($response){
		while($row = mysqli_fetch_array($response))
			$count = $row[0];
	}
	if($count){
	    echo '{"error":true}';
		exit;
	}
	$hospital_name = $_POST['hospital'];
	$case_no = (int)$_POST['caseno'];
	$gender = $_POST['gender'];
	$mother_tongue = $_POST['mother_tongue'];
	$education = $_POST['education'];
	$fathers_name = $_POST['father'];
	$mother_name = $_POST['mother'];
	$guardian = $_POST['guardian'];
	$siblings = (int)$_POST['no_of_siblings'];
	$illness = $_POST['illness'];
	$parent_consent = $_POST['parent_consent'];
	$consent_by = $_POST['consent_by'];
	$witness = $_POST['witness'];
	$photo_url = $POST['photo_url'];
	$status = "Referred";
	$query = "INSERT INTO child(aadhar_id,hospital_name,case_no,gender,
	mother_tongue,education,fathers_name,mothers_name,guardian,siblings,illness,parent_consent,consent_by,witness,photo_url,status) 
	VALUES('$aadhar_id','$hospital_name','$case_no','$gender',
	'$mother_tongue','$education','$fathers_name','$mothers_name',
	'$guardian','$siblings','$illness','$parent_consent','$consent_by','$witness','$photo_url','$status')";
	$response = @mysqli_query($conn, $query);
	$query = "INSERT INTO child_doctor VALUES($aadhar_id,$doctor_aadhar)";
	$response = @mysqli_query($conn, $query);
	if($response)
	    echo '{"Status":"Inserted"}';
	else
		echo mysqli_error($conn);
}
?>
