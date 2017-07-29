<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Child extends Model
{
    /**
     * The database table used by the model.
     *
     * @var string
     */
    protected $table = 'children';

    /**
    * The database primary key value.
    *
    * @var string
    */
    protected $primaryKey = 'id';

    /**
     * Attributes that should be mass-assignable.
     *
     * @var array
     */
    protected $fillable = ['aadhar_id', 'hospital_name', 'case_no', 'illness', 'status'];

    
}
