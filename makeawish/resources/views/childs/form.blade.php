<div class="form-group {{ $errors->has('aadhar_id') ? 'has-error' : ''}}">
    {!! Form::label('aadhar_id', 'Aadhar Id', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::number('aadhar_id', null, ['class' => 'form-control']) !!}
        {!! $errors->first('aadhar_id', '<p class="help-block">:message</p>') !!}
    </div>
</div><div class="form-group {{ $errors->has('hospital_name') ? 'has-error' : ''}}">
    {!! Form::label('hospital_name', 'Hospital Name', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('hospital_name', null, ['class' => 'form-control']) !!}
        {!! $errors->first('hospital_name', '<p class="help-block">:message</p>') !!}
    </div>
</div><div class="form-group {{ $errors->has('case_no') ? 'has-error' : ''}}">
    {!! Form::label('case_no', 'Case No', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('case_no', null, ['class' => 'form-control']) !!}
        {!! $errors->first('case_no', '<p class="help-block">:message</p>') !!}
    </div>
</div><div class="form-group {{ $errors->has('illness') ? 'has-error' : ''}}">
    {!! Form::label('illness', 'Illness', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('illness', null, ['class' => 'form-control']) !!}
        {!! $errors->first('illness', '<p class="help-block">:message</p>') !!}
    </div>
</div><div class="form-group {{ $errors->has('status') ? 'has-error' : ''}}">
    {!! Form::label('status', 'Status', ['class' => 'col-md-4 control-label']) !!}
    <div class="col-md-6">
        {!! Form::text('status', null, ['class' => 'form-control']) !!}
        {!! $errors->first('status', '<p class="help-block">:message</p>') !!}
    </div>
</div>

<div class="form-group">
    <div class="col-md-offset-4 col-md-4">
        {!! Form::submit(isset($submitButtonText) ? $submitButtonText : 'Create', ['class' => 'btn btn-primary']) !!}
    </div>
</div>
