<?php

namespace App\Http\Controllers;
use DB;
use Illuminate\Http\Request;

class sms extends Controller
{
    

 	  public function index()
    {

    	 //$number = $request->input('number');
    	$number =DB::table('smss')->select('mobile')->get();   //      $users = DB::table('users')->get();
    	
    		
    	//print_r($number); die();


        return view('sms',compact('number'));
    }


}
