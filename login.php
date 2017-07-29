<?php
include 'connect.php';
<<<<<<< HEAD
	$conn = connect();
	//$data = json_decode('logindata');
	$aadhar_id = $_POST['aadhar_id'];
    $password = $_POST['password'];
	$query = "SELECT * FROM person WHERE aadhar_id=$aadhar_id AND password='$password'";
=======
echo "hello";
$conn = connect();
$email=9161246;
$password="abcd";
$query = "SELECT * FROM person WHERE aadhar_id=$email AND password=$password";
$response = @mysqli_query($conn, $query);
if(response)
{
	$result = array();
	while($row = mysql_fetch_array($response))
		$result[] = $row;
}
print_r( $result);
echo "hiii";
while($row = mysqli_fetch_array($response)){
			$result = arrray();
			$return["Status"] = "Success";
			$return["aadhar_id"] = $row[0];
		}
		echo json_encode($return);
/*	$conn = connect();
	//$data = json_decode('logindata');
	//$aadhar_id = $data['aadhar_id'];
    //$password = $data['password'];
	$response = array("error" => FALSE);
	if (isset($_POST['email']) && isset($_POST['password'])) {
	// receiving the post params
    $email = $_POST['email'];
    $password = $_POST['password'];
	$query = "SELECT * FROM person WHERE aadhar_id=$email AND password=$password";
>>>>>>> e501da8f2143b4eceb191a78767a021761c97564
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
<<<<<<< HEAD
=======
}else {
    // required post params is missing
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters email or password is missing!";
    echo json_encode($response);
}*/
>>>>>>> e501da8f2143b4eceb191a78767a021761c97564
?>
