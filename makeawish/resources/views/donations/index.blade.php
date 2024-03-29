@extends('layouts.backend')

@section('content')
    <div class="container">
        <div class="row">
            @if(Auth::check() && Auth::user()->hasRole('admin')) 
                    @include('admin.sidebar')
           
            @endif

            <div class="col-md-9">
                <div class="panel panel-default">
                    <div class="panel-heading">Donations</div>
                    <div class="panel-body">
                        <a href="{{ url('/frontend/donations/create') }}" class="btn btn-success btn-sm" title="Add New Donation">
                            <i class="fa fa-plus" aria-hidden="true"></i> Add New
                        </a>

                        {!! Form::open(['method' => 'GET', 'url' => '/frontend/donations', 'class' => 'navbar-form navbar-right', 'role' => 'search'])  !!}
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
                                        <th>ID</th><th>Amount</th><th>Name</th>
                                    </tr>
                                </thead>
                                <tbody>
                                @foreach($donations as $item)
                                    <tr>
                                        <td>{{ $item->id }}</td>
                                        <td>{{ $item->amount }}</td>
                                           <td>{{ $item->user->name }}</td>
                                        <td>
                                            <a href="{{ url('/frontend/donations/' . $item->id) }}" title="View Donation"><button class="btn btn-info btn-xs"><i class="fa fa-eye" aria-hidden="true"></i> View</button></a>
                                            <a href="{{ url('/frontend/donations/' . $item->id . '/edit') }}" title="Edit Donation"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></a>
                                            {!! Form::open([
                                                'method'=>'DELETE',
                                                'url' => ['/frontend/donations', $item->id],
                                                'style' => 'display:inline'
                                            ]) !!}
                                                {!! Form::button('<i class="fa fa-trash-o" aria-hidden="true"></i> Delete', array(
                                                        'type' => 'submit',
                                                        'class' => 'btn btn-danger btn-xs',
                                                        'title' => 'Delete Donation',
                                                        'onclick'=>'return confirm("Confirm delete?")'
                                                )) !!}
                                            {!! Form::close() !!}
                                        </td>
                                    </tr>
                                @endforeach
                                </tbody>
                            </table>
                            <div class="pagination-wrapper"> {!! $donations->appends(['search' => Request::get('search')])->render() !!} </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
