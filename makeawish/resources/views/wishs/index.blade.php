@extends('layouts.backend')

@section('content')
    <div class="container">
        <div class="row">
           @if(Auth::check() && Auth::user()->hasRole('admin')) {
              @include('admin.sidebar')

@else 
            @include('volsidebar')

@endif

            <div class="col-md-9">
                <div class="panel panel-default">
                    <div class="panel-heading">Wishs</div>
                    <div class="panel-body">
                        <a href="{{ url('/frontend/wishs/create') }}" class="btn btn-success btn-sm" title="Add New Wish">
                            <i class="fa fa-plus" aria-hidden="true"></i> Add New
                        </a>

                        {!! Form::open(['method' => 'GET', 'url' => '/frontend/wishs', 'class' => 'navbar-form navbar-right', 'role' => 'search'])  !!}
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
                                        <th>ID</th><th>Child Aadhar</th><th>Wish Details</th><th>Wish 1</th><th>Wish 2</th><th>Wish 3</th><th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                @foreach($wishs as $item)
                                    <tr>
                                        <td>{{ $item->id }}</td>
                                        <td>{{ $item->name }}</td><td>{{ $item->details }}</td><td>{{ $item->wish1 }}</td><td>{{ $item->wish2 }}</td><td>{{ $item->wish3 }}</td>
                                        <td>
                                            <a href="{{ url('/frontend/wishs/' . $item->id) }}" title="View Wish"><button class="btn btn-info btn-xs"><i class="fa fa-eye" aria-hidden="true"></i> View</button></a>
                                            <a href="{{ url('/frontend/wishs/' . $item->id . '/edit') }}" title="Edit Wish"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></a>
                                            {!! Form::open([
                                                'method'=>'DELETE',
                                                'url' => ['/frontend/wishs', $item->id],
                                                'style' => 'display:inline'
                                            ]) !!}
                                                {!! Form::button('<i class="fa fa-trash-o" aria-hidden="true"></i> Delete', array(
                                                        'type' => 'submit',
                                                        'class' => 'btn btn-danger btn-xs',
                                                        'title' => 'Delete Wish',
                                                        'onclick'=>'return confirm("Confirm delete?")'
                                                )) !!}
                                            {!! Form::close() !!}
                                        </td>
                                    </tr>
                                @endforeach
                                </tbody>
                            </table>
                            <div class="pagination-wrapper"> {!! $wishs->appends(['search' => Request::get('search')])->render() !!} </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
