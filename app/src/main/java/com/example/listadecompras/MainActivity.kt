package com.example.listadecompras

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    var index=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtos_adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val compras_adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val list_view_produtos: ListView = findViewById(R.id.list_view_produtos)
        val list_view_compras: ListView = findViewById(R.id.list_view_compras)
        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val editTextTextPersonName: EditText = findViewById(R.id.editTextTextPersonName)
        val builder = AlertDialog.Builder(this@MainActivity)
        list_view_produtos.adapter = produtos_adapter
        list_view_compras.adapter = compras_adapter

        button.setOnClickListener {
            builder.setTitle("Exemplo de uso Dialog")
            builder.setMessage("Confirma?")

            builder.setPositiveButton("Sim"){dialog, which ->
                Toast.makeText(applicationContext,"Botão sim selecionado.",Toast.LENGTH_SHORT).show()
                val produto = editTextTextPersonName.text.toString()
                if (produto.isNotEmpty()) {
                    produtos_adapter.add(produto+" "+index)
                    index++
                    Toast.makeText(applicationContext,"Botão sim selecionado.", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setNegativeButton("Não"){dialog, which ->
                Toast.makeText(applicationContext,"Botão Não selecionado.",Toast.LENGTH_SHORT).show()
            }

            builder.setNeutralButton("Cancelar"){dialog, which ->
                Toast.makeText(applicationContext,"Cancelar selecionado.",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        list_view_produtos.setOnItemClickListener { adapterView, view, i, l ->
            val itemValue = list_view_produtos.getItemAtPosition(i) as String
            if (itemValue.isNotEmpty()) {
                compras_adapter.add(itemValue)
                Toast.makeText(applicationContext,"Botão sim selecionado.", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(applicationContext, "valor:" + i+"->"+itemValue, Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            for (x in 0..10) {
                produtos_adapter.add("produto"+ " "+ x)
            }
        }
    }
}