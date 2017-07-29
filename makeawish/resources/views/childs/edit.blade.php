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
                    <div class="panel-heading">Edit Child #{{ $child->id }}</div>
                    <div class="panel-body">
                        <a href="{{ url('/frontend/childs') }}" title="Back"><button class="btn btn-warning btn-xs"><i class="fa fa-arrow-left" aria-hidden="true"></i> Back</button></a>
                        <br />
                        <br />

                        @if ($errors->any())
                            <ul class="alert alert-danger">
                                @foreach ($errors->all() as $error)
                                    <li>{{ $error }}</li>
                                @endforeach
                            </ul>
                        @endif

                        {!! Form::model($child, [
                            'method' => 'PATCH',
                            'url' => ['/frontend/childs', $child->id],
                            'class' => 'form-horizontal',
                            'files' => true
                        ]) !!}

                        @include ('childs.form', ['submitButtonText' => 'Update'])

                        {!! Form::close() !!}

                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
