@extends('layouts.backend')

@section('content')
    <div class="container">
        <div class="row">
                  
@if(Auth::check() && Auth::user()->hasRole('admin')) {
              @include('admin.sidebar')

            @elseif(Auth::check() && Auth::user()->hasRole('doctor')) { 
            @include('docsidebar')
            @else
            @include('volsidebar')

            @endif

            <div class="col-md-9">
                <div class="panel panel-default">
                    <div class="panel-heading">Childs</div>
                    <div class="panel-body">
                        <a href="{{ url('/frontend/childs/create') }}" class="btn btn-success btn-sm" title="Add New Child">
                            <i class="fa fa-plus" aria-hidden="true"></i> Add New
                        </a>

                        {!! Form::open(['method' => 'GET', 'url' => '/frontend/childs', 'class' => 'navbar-form navbar-right', 'role' => 'search'])  !!}
                        <div class="input-group">
                            <input type="text" class="form-control" name="search" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        {!! Form::close() !!}

                        <br/>
                        <br/>
                        <div class="table-responsive">
                            <table class="table table-borderless">
                                <thead>
                                    <tr>
                                        <th>ID</th><th>Aadhar Id</th><th>Hospital Name</th><th>Case No</th><th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                @foreach($childs as $item)
                                    <tr>
                                        <td>{{ $item->id }}</td>
                                        <td>{{ $item->aadhar_id }}</td><td>{{ $item->hospital_name }}</td><td>{{ $item->case_no }}</td><td>{{ $item->status }}</td>
                                        <td>
                                            <a href="{{ url('/frontend/childs/' . $item->id) }}" title="View Child"><button class="btn btn-info btn-xs"><i class="fa fa-eye" aria-hidden="true"></i> View</button></a>
                                            <a href="{{ url('/frontend/childs/' . $item->id . '/edit') }}" title="Edit Child"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></a>
                                            {!! Form::open([
                                                'method'=>'DELETE',
                                                'url' => ['/frontend/childs', $item->id],
                                                'style' => 'display:inline'
                                            ]) !!}
                                                
                                        </td>
                                    </tr>
                                @endforeach
                                </tbody>
                            </table>
                            <div class="pagination-wrapper"> {!! $childs->appends(['search' => Request::get('search')])->render() !!} </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
