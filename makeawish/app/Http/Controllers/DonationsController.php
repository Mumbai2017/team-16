<?php

namespace App\Http\Controllers;
use Auth;
use App\Http\Requests;
use App\Http\Controllers\Controller;

use App\Donation;
use Illuminate\Http\Request;
use Session;

class DonationsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\View\View
     */
    public function index(Request $request)
    {
        $keyword = $request->get('search');
        $perPage = 25;

        if (!empty($keyword)) {
            $donations = Donation::where('user_id', 'LIKE', "%$keyword%")
				->orWhere('receipt_no', 'LIKE', "%$keyword%")
				->orWhere('amount', 'LIKE', "%$keyword%")
				->paginate($perPage);
        } else {
            $donations = Donation::paginate($perPage);
        }

        return view('donations.index', compact('donations'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\View\View
     */
    public function create()
    {
        return view('donations.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param \Illuminate\Http\Request $request
     *
     * @return \Illuminate\Http\RedirectResponse|\Illuminate\Routing\Redirector
     */
    public function store(Request $request)
    {
         $userId = Auth::id();
        //    $user = User::find(Auth::id());
            $requestData = $request->all();
            $requestData['user_id']= $userId;  
       // $requestData = $request->all();
        
        Donation::create($requestData);

        Session::flash('flash_message', 'Donation added!');

        return redirect('frontend/donations');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     *
     * @return \Illuminate\View\View
     */
    public function show($id)
    {
        $donation = Donation::findOrFail($id);

        return view('donations.show', compact('donation'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     *
     * @return \Illuminate\View\View
     */
    public function edit($id)
    {
        $donation = Donation::findOrFail($id);

        return view('donations.edit', compact('donation'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  int  $id
     * @param \Illuminate\Http\Request $request
     *
     * @return \Illuminate\Http\RedirectResponse|\Illuminate\Routing\Redirector
     */
    public function update($id, Request $request)
    {
        

        $requestData = $request->all();
        
        $donation = Donation::findOrFail($id);
        $donation->update($requestData);

        Session::flash('flash_message', 'Donation updated!');

        return redirect('frontend/donations');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     *
     * @return \Illuminate\Http\RedirectResponse|\Illuminate\Routing\Redirector
     */
    public function destroy($id)
    {
        Donation::destroy($id);

        Session::flash('flash_message', 'Donation deleted!');

        return redirect('frontend/donations');
    }
}
