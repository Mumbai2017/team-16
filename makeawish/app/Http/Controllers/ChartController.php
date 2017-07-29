<?php

   
namespace App\Http\Controllers;
use Auth;
use App\Http\Requests;
use App\Http\Controllers\Controller;

use App\Donation;
use Illuminate\Http\Request;
use Session;
    class ChartController extends Controller {
        public function pieChart(){
             $donations=Donation::selectRaw('count(amount) as count,amount')->groupBy('amount')->get();
             $user=array();
             foreach ($user as $result) {
                 $user[$result->amount]=(int)$result->count;
             }
           
            return view('piechart',compact('user'));
        }
        
    }