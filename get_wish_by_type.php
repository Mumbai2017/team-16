<?php
include 'connect.php';
	$conn = connect();
	$wish_type = "to go";//$_POST['wish_type'];
	$wish = array();
	$aadhar_id = array();
	$childen = "";
	$query = "SELECT * FROM wish";
	$response = @mysqli_query($conn, $query);
	if($response){
		$resultdata = array();
		while($row = mysqli_fetch_array($response)){
			$resultdata[] = $row;
		}
	}
	foreach($resultdata as $data){
		if($data[4] == $wish_type){
			$wish[] = $data[1];		
			$aadhar_id[] = $data[7];
		}
		if($data[5] == $wish_type){
			$wish[] = $data[2];		
			$aadhar_id[] = $data[7];
		}
		if($data[6] == $wish_type){
			$wish[] = $data[3];		
			$aadhar_id[] = $data[7];
		}
	}
	$count = 0;
	foreach($aadhar_id as $aadhar){
			$query = "SELECT name FROM aadhar WHERE aadhar_id=$aadhar";
			$response = @mysqli_query($conn, $query);
			if($response){
				while($row = mysqli_fetch_array($response))
					$name = $row[0];
			}
			$child['name'] = $name;
			$child['aadhar'] = $aadhar;
			$child['wish'] = $wish[$count++];
			$children[] = $child;
	}	
	$data = array();
	$data['error'] = false;
	$data['children'] = $children;
	echo json_encode($data);	
?>