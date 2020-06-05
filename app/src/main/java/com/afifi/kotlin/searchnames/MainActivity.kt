package com.afifi.kotlin.searchnames

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.Afifi.kotlin.searchnames.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val nameList = mutableSetOf<String>()
    val emptyStr:String = ""

    fun addAction(v: View){
        var newName:String = nameET?.text.toString()
        if(newName == null || newName == ""){
            Toast.makeText(this, "Please write a name to be added", Toast.LENGTH_SHORT).show()
        }else {
            nameList.add(newName)
            Toast.makeText(this, "$newName added successfully", Toast.LENGTH_SHORT).show()
            nameET.setText("")
        }
    }

    fun searchAction(v: View){
        val searchStr = searchNameET?.text.toString()
        if(searchStr == null || searchStr == ""){
            Toast.makeText(this, "Please write a name to search", Toast.LENGTH_SHORT).show()
        }else{
            var i:Int = nameList.indexOf(searchStr)
            var m ="The name ($searchStr) is Found"
            var color:String = "#ff99cc00"
            if(i<0){
                m="The name ($searchStr) wasn't Found"
                color = "#ffcc0000"
            }
            txtShow.text = m
            txtShow.setTextColor(Color.parseColor(color))
            searchNameET.setText("")
        }
    }
}