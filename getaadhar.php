<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        require_once 'DB_Connect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }

    // destructor
    function __destruct() {
        
    }

 
    /**
     * Get user by email and password
     */
    public function getAadharDetails($id) {
        $result = mysql_query("SELECT * FROM aadhar WHERE id = '$id'") or die(mysql_error());
        // check for result 
        $no_of_rows = mysql_num_rows($result);
   

       
        if ($no_of_rows > 0) {
            $result = mysql_fetch_array($result);
            
                return $result;
          
        } else {
            // user not found
            return false;
        }
    }


?>
