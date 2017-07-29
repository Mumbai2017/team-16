@extends('layouts.backend')

@section('content')
    <div class="container">
        <div class="row">
         @if(Auth::check() && Auth::user()->hasRole('admin')) 
                    @include('admin.sidebar')
           
            @endif

            <div class="col-md-9">
                <div class="panel panel-default">
                    <div class="panel-heading">Donation {{ $donation->id }}</div>
                    <div class="panel-body">

                        <a href="{{ url('/frontend/donations') }}" title="Back"><button class="btn btn-warning btn-xs"><i class="fa fa-arrow-left" aria-hidden="true"></i> Back</button></a>
                        <a href="{{ url('/frontend/donations/' . $donation->id . '/edit') }}" title="Edit Donation"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></a>
                        {!! Form::open([
                            'method'=>'DELETE',
                            'url' => ['frontend/donations', $donation->id],
                            'style' => 'display:inline'
                        ]) !!}
                            {!! Form::button('<i class="fa fa-trash-o" aria-hidden="true"></i> Delete', array(
                                    'type' => 'submit',
                                    'class' => 'btn btn-danger btn-xs',
                                    'title' => 'Delete Donation',
                                    'onclick'=>'return confirm("Confirm delete?")'
                            ))!!}
                        {!! Form::close() !!}
                        <br/>
                        <br/>

                        <div class="table-responsive">
                            <table class="table table-borderless">
                                <tbody>
                                    <tr>
                                        <th>ID</th><td>{{ $donation->id }}</td>
                                    </tr>
                                    <tr><th> User Id </th><td> {{ $donation->user_id }} </td></tr><tr><th> Receipt No </th><td> {{ $donation->receipt_no }} </td></tr><tr><th> Amount </th><td> {{ $donation->amount }} </td></tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
