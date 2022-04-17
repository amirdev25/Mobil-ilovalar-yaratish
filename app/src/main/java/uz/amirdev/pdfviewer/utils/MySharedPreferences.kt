package uz.amirdev.pdfviewer.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreferences {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }


    fun setMainItemPosition(position: Int) {
        editor.putInt("MainItemPosition", position).commit()
    }

    fun getMainItemPosition() = sharedPreferences.getInt("MainItemPosition", -1)

    fun setItemPosition(position: Int) {
        editor.putInt("ItemPosition", position).commit()
    }

    fun getItemPosition() = sharedPreferences.getInt("ItemPosition", -1)

}