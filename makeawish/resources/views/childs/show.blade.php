@extends('layouts.backend')

@section('content')
    <div class="container">
        <div class="row">
           @if(Auth::check() && Auth::user()->hasRole('admin')) {
              @include('admin.sidebar')

            @elseif(Auth::check() && Auth::user()->hasRole('doctor')) { 
            @include('docsidebar')
            @else(Auth::check() && Auth::user()->hasRole('volunteer')) { 
            @include('volsidebar')
            @endif

            <div class="col-md-9">
                <div class="panel panel-default">
                    <div class="panel-heading">Child {{ $child->id }}</div>
                    <div class="panel-body">

                        <a href="{{ url('/frontend/childs') }}" title="Back"><button class="btn btn-warning btn-xs"><i class="fa fa-arrow-left" aria-hidden="true"></i> Back</button></a>
                        <a href="{{ url('/frontend/childs/' . $child->id . '/edit') }}" title="Edit Child"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></a>
                        {!! Form::open([
                            'method'=>'DELETE',
                            'url' => ['frontend/childs', $child->id],
                            'style' => 'display:inline'
                        ]) !!}
                            {!! Form::button('<i class="fa fa-trash-o" aria-hidden="true"></i> Delete', array(
                                    'type' => 'submit',
                                    'class' => 'btn btn-danger btn-xs',
                                    'title' => 'Delete Child',
                                    'onclick'=>'return confirm("Confirm delete?")'
                            ))!!}
                        {!! Form::close() !!}
                        <br/>
                        <br/>

                        <div class="table-responsive">
                            <table class="table table-borderless">
                                <tbody>
                                    <tr>
                                        <th>ID</th><td>{{ $child->id }}</td>
                                    </tr>
                                    <tr><th> Aadhar Id </th><td> {{ $child->aadhar_id }} </td></tr><tr><th> Hospital Name </th><td> {{ $child->hospital_name }} </td></tr><tr><th> Case No </th><td> {{ $child->case_no }} </td></tr><tr><th> Status </th><td> {{ $child->status }} </td></tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
