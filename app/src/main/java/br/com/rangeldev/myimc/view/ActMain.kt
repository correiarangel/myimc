package br.com.rangeldev.myimc.view


import android.content.Intent

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import br.com.rangeldev.myimc.R
import br.com.rangeldev.myimc.R.layout.act_main
import br.com.rangeldev.myimc.components.MyCustomDailog
import br.com.rangeldev.myimc.viewModel.ViewModelIMC


class ActMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(act_main)

        val btnCalc:Button = findViewById (R.id.btnCalc)
        val height :EditText = findViewById (R.id.edtHeigth)
        val weight:EditText = findViewById (R.id.edtWeight)

        btnCalc.setOnClickListener{

            if(  !height.text.contains(".")) {
                msgToast("Digite altura corretamente ( Ex. 1.69 )")
                println("Digite altura corretamente ( Ex. 1.69 )")
                height.text.clear()
            }

            if(  height.text.isNotEmpty() && weight.text.isNotEmpty()){
                val calculatIMC  = ViewModelIMC(
                    height.text.toString(),
                    weight.text.toString(),
                )

                val  res = calculatIMC.startCalc()
                val customDailog = MyCustomDailog(this, res,"Resltado IMC")
                customDailog.createCustomTwoButtonDialog()
                height.text.clear()
                weight.text.clear()
            }else   if(  height.text.isNotEmpty() && weight.text.isEmpty()){
                msgToast("Digite sua altura :[")
            }else   if(  height.text.isEmpty() && weight.text.isNotEmpty()) {
                msgToast("Digite seu peso  :[")
            }
        }

    }
   /* fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }*/

    private fun msgToast(msg:String){
        val toast = Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT)
        toast.show()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.imc_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mnTips -> {
                msgToast("Dicas não foram inplementado")

                true
            }
            R.id.mnRecipes -> {
                msgToast("Receitas não foram inplementado")
                true
            }
            R.id.mnInfo-> {
                val it = Intent(this, ActInfo::class.java)
                 startActivity(it)
                true
            }
            R.id.mnPriveta-> {

                true
            }
            R.id.mnExit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


