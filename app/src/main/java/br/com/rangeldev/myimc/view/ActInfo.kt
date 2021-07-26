package br.com.rangeldev.myimc.view

import android.content.Intent
import android.net.Uri

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.rangeldev.myimc.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_info)
        supportActionBar!!.hide()

        val flotBtnSair:FloatingActionButton = findViewById(R.id.flotBtnSair)
        val floatBtnPolitic:FloatingActionButton = findViewById(R.id.floatBtnPolitic)
        flotBtnSair.setOnClickListener {
            // startVibrat(90)
            finish()
        }
        floatBtnPolitic.setOnClickListener{
            // startVibrat(90)
           // val it = Intent(applicationContext, ActPolitica::class.java)
            //startActivity(it)
        }

    }



    fun openBrowser(view: View) {

        //Get url from tag
        val url = view.tag as String

        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.addCategory(Intent.CATEGORY_BROWSABLE)

        //pass the url to intent data
        intent.data = Uri.parse(url)

        startActivity(intent)
    }

    override fun onBackPressed() {
        finish()
    }
}