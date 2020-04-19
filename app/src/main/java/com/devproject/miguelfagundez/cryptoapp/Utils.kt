package com.devproject.miguelfagundez.cryptoapp

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast

class Utils{

}


fun Activity.ShowMessage(view: View, message : String, duration: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(view, message, duration).setAction("Information!", null).show()
}

fun Activity.Toast(message : String, duration:Int= android.widget.Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}