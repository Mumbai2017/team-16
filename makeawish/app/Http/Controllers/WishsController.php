<?php

namespace App\Http\Controllers;

use App\Http\Requests;
use App\Http\Controllers\Controller;

use App\Wish;
use Illuminate\Http\Request;
use Session;

class WishsController extends Controller
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
            $wishs = Wish::where('name', 'LIKE', "%$keyword%")
				->orWhere('details', 'LIKE', "%$keyword%")
				->paginate($perPage);
        } else {
            $wishs = Wish::paginate($perPage);
        }

        return view('wishs.index', compact('wishs'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\View\View
     */
    public function create()
    {
        return view('wishs.create');
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
        
        $requestData = $request->all();
        print_r($requestData);
        $requestData['wish1_type']='to meet';
                $requestData['wish2_type']='to see';

        $requestData['wish3_type']='to go';


            


        
       // $requestData.indexOf("turtles") > -1
        
        Wish::create($requestData);

        Session::flash('flash_message', 'Wish added!');

        return redirect('frontend/wishs');
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
        $wish = Wish::findOrFail($id);

        return view('wishs.show', compact('wish'));
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
        $wish = Wish::findOrFail($id);

        return view('wishs.edit', compact('wish'));
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
        
        $wish = Wish::findOrFail($id);
        $wish->update($requestData);

        Session::flash('flash_message', 'Wish updated!');

        return redirect('frontend/wishs');
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
        Wish::destroy($id);

        Session::flash('flash_message', 'Wish deleted!');

        return redirect('frontend/wishs');
    }
}
