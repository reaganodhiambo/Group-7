package com.example.mamambogaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private val data = ArrayList<String>()
    private val data1 = ArrayList<String>()
    private val data2 = ArrayList<String>()
    private val data3 = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pname = findViewById<EditText>(R.id.etproduct)
        val price = findViewById<EditText>(R.id.etprice)
        val qty = findViewById<EditText>(R.id.etqty)

        val subtotal = findViewById<EditText>(R.id.etsubtotal)
        val pay = findViewById<EditText>(R.id.etpay)
        val balance = findViewById<EditText>(R.id.etbalance)

        val badd = findViewById<Button>(R.id.btn1)
        val bcal = findViewById<Button>(R.id.btn2)


        bcal.setOnClickListener {
            val sub = Integer.parseInt(subtotal.getText().toString())
            val payment = Integer.parseInt(pay.getText().toString())
            val bal = payment - sub
            balance.setText(balance.toString())



        }

        badd.setOnClickListener {
            val prodname = pname.text.toString()
            val pprice = price.text.toString().toInt()
            val pqty = qty.text.toString().toInt()
            val total = pprice*pqty

            data.add(prodname)
            data1.add(pprice.toString())
            data2.add(pqty.toString())
            data3.add(total.toString())

            val table = findViewById<TableLayout>(R.id.tl1)


            val row = TableRow(this)
            val t1 = TextView(this)
            val t2 = TextView(this)
            val t3 = TextView(this)
            val t4 = TextView(this)


            val tot:String
            var sum = 0

            for(i in data.indices) {
                val pn = data[i]
               val  prc = data1[i]
                val qt = data2[i]
               val  tt = data3[i]

                t1.text = pn
                t2.text = prc
                t3.text = qt
                t4.text = tt

                sum = sum + Integer.parseInt(data3[i])
            }

            row.addView(t1)
            row.addView(t2)
            row.addView(t3)
            row.addView(t4)

            subtotal.setText(sum.toString())
            pname.setText("")
            price.setText("")
            qty.setText("")
            pname.requestFocus()

        }
    }
}