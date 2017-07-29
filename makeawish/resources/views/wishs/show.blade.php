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
                    <div class="panel-heading">Wish {{ $wish->id }}</div>
                    <div class="panel-body">

                        <a href="{{ url('/frontend/wishs') }}" title="Back"><button class="btn btn-warning btn-xs"><i class="fa fa-arrow-left" aria-hidden="true"></i> Back</button></a>
                        <a href="{{ url('/frontend/wishs/' . $wish->id . '/edit') }}" title="Edit Wish"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></a>
                        {!! Form::open([
                            'method'=>'DELETE',
                            'url' => ['frontend/wishs', $wish->id],
                            'style' => 'display:inline'
                        ]) !!}
                            {!! Form::button('<i class="fa fa-trash-o" aria-hidden="true"></i> Delete', array(
                                    'type' => 'submit',
                                    'class' => 'btn btn-danger btn-xs',
                                    'title' => 'Delete Wish',
                                    'onclick'=>'return confirm("Confirm delete?")'
                            ))!!}
                        {!! Form::close() !!}
                        <br/>
                        <br/>

                        <div class="table-responsive">
                            <table class="table table-borderless">
                                <tbody>
                                    <tr>
                                        <th>ID</th><td>{{ $wish->id }}</td>
                                    </tr>
                                    <tr><th> Name </th><td> {{ $wish->name }} </td></tr><tr><th> Details </th><td> {{ $wish->details }} </td></tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
