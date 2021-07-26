package br.com.rangeldev.myimc.components

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater


import android.widget.Button
import android.widget.TextView
import br.com.rangeldev.myimc.R
import br.com.rangeldev.myimc.R.layout.custom_dialog_result

class MyCustomDailog(
    private val applicationContext:Context,
    private val result:String,
    private val title:String
){

    fun createCustomTwoButtonDialog() {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater
            .from(applicationContext)
            .inflate(custom_dialog_result, null)

        val btnEntend: Button = mDialogView.findViewById(R.id.btnEntendi)
        val txtTitle: TextView = mDialogView.findViewById(R.id.txtTitle)
        val txtResult: TextView = mDialogView.findViewById(R.id.txtResult)

        val result:String = result
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(applicationContext)
            .setView(mDialogView)
            //.setTitle(title)
            //.setMessage(result)
        txtTitle.text = title
        txtResult.text = result
        println("DAILOG $result")
        //show dialog
        val mAlertDialog: AlertDialog = mBuilder.show()
        //cancel button click of custom layout
        btnEntend.setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()
        }
    }
}
