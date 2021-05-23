package com.aula.spentoftravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calcular.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                if (isEmpty(distancia.text) || isEmpty(preco.text) || isEmpty(autonomia.text))
                 Toast.makeText(applicationContext, "Preencha todos os campos.", Toast.LENGTH_LONG).show()
               else{
                    try {
                        val d = distancia.text.toString().replace(',', '.').toDouble()
                        val p = preco.text.toString().replace(',', '.').toDouble()
                        val a = autonomia.text.toString().replace(',', '.').toDouble()
                        var s: Any
                        if (d == 0.00 || p == 0.00 || a == 0.00)
                            Toast.makeText(applicationContext, "Nenhum campo pode ter o valor zero.", Toast.LENGTH_LONG).show()

                        else{
                            s = ((d * p) / a)
                            s = String.format("%.2f", s)
                            total.text = "R$ ${s}"
                        }
                    } catch(e : Exception){
                        Toast.makeText(applicationContext, "Preencha todos os campos com valores válidos. EX: 17,5 ou 17.5.", Toast.LENGTH_LONG).show()

                    }

                }
            }
        }
        )
    }
}