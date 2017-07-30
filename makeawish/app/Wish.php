<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Wish extends Model
{
    /**
     * The database table used by the model.
     *
     * @var string
     */
    protected $table = 'wishs';

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
    protected $fillable = ['name', 'details','wish1','wish2','wish3','wish1_type','wish2_type','wish3_type'];

    
}
