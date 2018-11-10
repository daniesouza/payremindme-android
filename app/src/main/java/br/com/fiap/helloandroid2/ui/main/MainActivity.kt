package br.com.fiap.helloandroid2.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.fiap.helloandroid2.R
import br.com.fiap.helloandroid2.model.Pedido
import br.com.fiap.helloandroid2.ui.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * https://www.materialpalette.com/teal/yellow
 * https://wordpad.cc/31scj
 * https://www.flaticon.com/free-icon/pizza_135648#term=pizza&page=1&position=5
 */

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.nomeCliente = intent.getStringExtra("nome")
        mainViewModel.telefoneCliente = intent.getStringExtra("telefone")

        txtNome.text = getString(R.string.saudacao, mainViewModel.nomeCliente, mainViewModel.telefoneCliente)

        cdAtum.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.atumSelecionado = isChecked
        }
        cdBacon.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.baconSelecionado = isChecked
        }
        cdCalabresa.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.calabresaSelecionado = isChecked
        }
        cdMussarela.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.mussarelaSelecionado = isChecked
        }


        cdAtum.isChecked = mainViewModel.atumSelecionado
        cdBacon.isChecked = mainViewModel.baconSelecionado
        cdCalabresa.isChecked = mainViewModel.calabresaSelecionado
        cdMussarela.isChecked = mainViewModel.mussarelaSelecionado

        btnCalcular.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("pedido", gerarPedido())
            startActivity(intent)
        }
    }

    private fun gerarPedido(): Pedido {
        return Pedido(mainViewModel.nomeCliente, mainViewModel.telefoneCliente)
    }
}