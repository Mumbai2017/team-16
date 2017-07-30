<?php
include 'connect.php';
	$conn = connect();
	$volunteer_aadhar = $_POST['volunteer_aadhar'];//69915244;
	//$_POST = json_decode('wishform');
    $aadhar_id_child = $_POST['aadhar_id'];//495246;
	$wish_1 = $_POST['wish1'];//"I want to have food";
	$wish_2 = $_POST['wish2'];//"I want to go out";
	$wish_3 = $_POST['wish3'];//"I want to meet";
	$wish_1_type = "";
	$wish_2_type = "";
	$wish_3_type = "";
	//based on keywords..can use nlp later
	if(stristr($wish_1, 'have') == TRUE) 
		$wish_1_type = "to have";
	else if(stristr($wish_1, 'go') == TRUE) 
		$wish_1_type = "to go";
	else if(stristr($wish_1, 'meet') == TRUE) 
		$wish_1_type = "to meet";
	else 
		$wish_1_type = "to be";
	if(stristr($wish_2, 'have') == TRUE) 
		$wish_2_type = "to have";
	else if(stristr($wish_2, 'go') == TRUE) 
		$wish_2_type = "to go";
	else if(stristr($wish_2, 'meet') == TRUE) 
		$wish_2_type = "to meet";
	else 
		$wish_2_type = "to be";
	if(stristr($wish_3, 'have') == TRUE) 
		$wish_3_type = "to have";
	else if(stristr($wish_3, 'go') == TRUE) 
		$wish_3_type = "to go";
	else if(stristr($wish_3, 'meet') == TRUE) 	
		$wish_3_type = "to meet";
	else 
		$wish_3_type = "to be";
	$approved = $_POST['approved'];//"y";
	$approved_by = $_POST['approved_by'];//"me";
	$date_format_1 = $_data['proposed_date'];"20-02-2009";
	$date_format_2 = strtotime($date_format_1);
	$date_format_3 = date('Y-m-d H:i:s',$date_format_2);
	$proposed_date = $date_format_3;
	$date_format_1 = $_data['approved_date'];//"20-03-2009";
	$date_format_2 = strtotime($date_format_1);
	$date_format_3 = date('Y-m-d H:i:s',$date_format_2);
	$approved_date = $date_format_3;
	$date_format_1 = $_data['fulfillmentdate'];//"20-03-2009";
	$date_format_2 = strtotime($date_format_1);
	$date_format_3 = date('Y-m-d H:i:s',$date_format_2);
	$fulfillmentdate = $date_format_3;
	$fulfilldby = $_POST['fulfilldby'];//12;
	$wish_detail = $_POST['wish_detail'];//"a lot";
	$query = "INSERT INTO wish(wish_1,wish_2,wish_3,wish_1_type,wish_2_type,wish_3_type,aadhar_id_child,wish_detail,approved,approved_by,proposed_date,approved_date,fulfillmentdate,fulfilldby) 
	VALUES ('$wish_1','$wish_2','$wish_3','$wish_1_type','$wish_2_type','$wish_3_type',$aadhar_id_child,'$wish_detail','$approved','$approved_by','$proposed_date','$approved_date','$fulfillmentdate','$fulfilldby')";
	$response = @mysqli_query($conn, $query);
	$query = "INSERT INTO child_volunteer(aadhar_id_child,aadhar_id_person) VALUES($aadhar_id_child,$volunteer_aadhar)";
	$response = @mysqli_query($conn, $query);
	$status = "Identified";
	$query = "UPDATE child SET status='$status' WHERE aadhar_id=$aadhar_id_child";
	$response = @mysqli_query($conn, $query);
	if($response)
	    echo '{"Status":"Inserted"}';
	else
		echo mysqli_error($conn);
?>
