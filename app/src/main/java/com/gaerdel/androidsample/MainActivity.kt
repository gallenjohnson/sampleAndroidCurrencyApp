package com.gaerdel.androidsample

import android.icu.text.NumberFormat
import android.icu.util.Currency
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    fun convertCurrency(view: View) = if(currency_field.text.isNotEmpty()) {
        val currencyValue = currency_field.text.toString().toFloat()
        val dollarValue = currencyValue
        val euroValue = setLocaleNumberFormat().format(dollarValue * 0.90f)
        output.text = euroValue
    } else output.text = getString(R.string.no_value)

    private fun setLocaleNumberFormat(): NumberFormat {
        val numFormat: NumberFormat = NumberFormat.getCurrencyInstance()
        numFormat.maximumFractionDigits = 2
        numFormat.currency = Currency.getInstance(getString(R.string.iso_country_code))
        return  numFormat
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
