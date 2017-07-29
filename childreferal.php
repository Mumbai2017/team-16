<?php
include 'connect.php';
	$conn = connect();
	$data = json_decode('referalform');
	$aadhar_id = (int)$data['aadhar'];
	$hospital_name = $data['hospital'];
	$case_no = (int)$data['caseno'];
	$gender = $data['gender'];
	$mother_tongue = $data['mother_tongue'];
	$education = $data['education'];
	$fathers_name = $data['father'];
	$mother_name = $data['mother'];
	$guardian = $data['guardian'];
	$siblings = (int)$data['no_of_siblings'];
	$illness = $data['illness'];
	$parent_consent = $data['parent_consent'];
	$consent_by = $data['consent_by'];
	$witness = $data['witness'];
	$photo_url = $POST['photo_url'];
	$query = "INSERT INTO child(aadhar_id,hospital_name,case_no,gender,
	mother_tongue,education,fathers_name,mothers_name,guardian,siblings,illness,parent_consent,consent_by,witness,photo_url) 
	VALUES('$aadhar_id','$hospital_name','$case_no','$gender',
	'$mother_tongue','$education','$fathers_name','$mothers_name',
	'$guardian','$siblings','$illness','$parent_consent','$consent_by','$witness','$photo_url')";
	$response = @mysqli_query($conn, $query);
	if($response)
	    echo '{"Status":"Inserted"}';
	else
		echo mysqli_error($conn);
}
?>
