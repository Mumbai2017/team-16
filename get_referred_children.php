<?php
include 'connect.php';
	$conn = connect();
	$aadhar_id = (int)$_POST['aadhar_id'];//49911864;
	$query = "SELECT aadhar_id_child FROM child_doctor WHERE aadhar_id_person=$aadhar_id";
	$response = @mysqli_query($conn, $query);
	$aadhar = array();
	$childern = "";
	if($response){
		while($row = mysqli_fetch_array($response))
			$aadhar[] = $row[0];
		foreach($aadhar as $aadhar){
			$query = "SELECT name FROM aadhar WHERE aadhar_id=$aadhar_id";
			$response = @mysqli_query($conn, $query);
			if($response){
				while($row = mysqli_fetch_array($response))
					$name = $row[0];
			}
			$query = "SELECT status FROM child WHERE aadhar_id=$aadhar";
			$response = @mysqli_query($conn, $query);
			if($response){
				while($row = mysqli_fetch_array($response))
					$status = $row[0];
			}
			$child['name'] = $name;
			$child['aadhar'] = $aadhar;
			$child['status'] = $status;
			$children[] = $child;
		}
		$data = array();
		$data['error'] = true;
		$data['children'] = $children;
		echo json_encode($data);	
	}
	else{
		$data["error"] = false;
        echo json_encode($data);	
		exit;
	}
?>