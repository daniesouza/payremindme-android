package br.com.fiap.helloandroid2.extensions

import android.widget.EditText

fun EditText.value() = this.text.toString()