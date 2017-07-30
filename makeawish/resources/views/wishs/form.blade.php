<div class="form-group {{ $errors->has('name') ? 'has-error' : ''}}">
    {!! Form::label('name', 'Child Aadhar', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('name', null, ['class' => 'form-control']) !!}
        {!! $errors->first('name', '<p class="help-block">:message</p>') !!}
    </div>
</div><div class="form-group {{ $errors->has('details') ? 'has-error' : ''}}">
    {!! Form::label('details', 'Details', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('details', null, ['class' => 'form-control']) !!}
        {!! $errors->first('details', '<p class="help-block">:message</p>') !!}
    </div>
</div>
<div class="form-group {{ $errors->has('details') ? 'has-error' : ''}}">
    {!! Form::label('wish1', 'Wish1', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('wish1', null, array('placeholder'=>'to meet' ),['class' => 'form-control']) !!}
        {!! $errors->first('wish1', '<p class="help-block">:message</p>') !!}
    </div>
</div>
<div class="form-group {{ $errors->has('details') ? 'has-error' : ''}}">
    {!! Form::label('wish2', 'Wish2', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('wish2', null, array('placeholder'=>'to see' ), ['class' => 'form-control']) !!}
        {!! $errors->first('wish2', '<p class="help-block">:message</p>') !!}
    </div>
</div>
<div class="form-group {{ $errors->has('details') ? 'has-error' : ''}}">
    {!! Form::label('wish3', 'Wish3', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('wish3', null, array('placeholder'=>'to go' ), ['class' => 'form-control']) !!}
        {!! $errors->first('wish3', '<p class="help-block">:message</p>') !!}
    </div>
</div>

<div class="form-group">
    <div class="col-md-offset-4 col-md-4">
        {!! Form::submit(isset($submitButtonText) ? $submitButtonText : 'Create', ['class' => 'btn btn-primary']) !!}
    </div>
</div>
