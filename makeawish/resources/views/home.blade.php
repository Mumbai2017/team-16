@extends('layouts.app')

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
        
@endsection
