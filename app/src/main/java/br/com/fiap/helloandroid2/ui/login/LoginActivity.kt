package br.com.fiap.helloandroid2.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.helloandroid2.R
import br.com.fiap.helloandroid2.extensions.value
import br.com.fiap.helloandroid2.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btFazerPedido.setOnClickListener {
            fazerPedido()
        }
    }

    private fun fazerPedido() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("nome", inputNome.value())
        intent.putExtra("telefone", inputTelefone.value())
        startActivity(intent)
    }
}
