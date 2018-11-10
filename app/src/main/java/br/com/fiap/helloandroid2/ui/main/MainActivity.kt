package br.com.fiap.helloandroid2.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.fiap.helloandroid2.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * https://www.materialpalette.com/teal/yellow
 * https://wordpad.cc/31scj
 * https://www.flaticon.com/free-icon/pizza_135648#term=pizza&page=1&position=5
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nome = intent.getStringExtra("nome")
        val telefone = intent.getStringExtra("telefone")
        txtNome.text = getString(R.string.saudacao, nome, telefone)

    }
}