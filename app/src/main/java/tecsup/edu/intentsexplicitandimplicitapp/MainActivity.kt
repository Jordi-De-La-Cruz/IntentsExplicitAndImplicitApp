package tecsup.edu.intentsexplicitandimplicitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExplicitActivity = findViewById<Button>(R.id.btnExplicitActivity)
        val btnImplicitActivity = findViewById<Button>(R.id.btnImplicitActivity)
        val codeInput = findViewById<EditText>(R.id.codeInput)
        val fullnameInput = findViewById<EditText>(R.id.fullnameInput)
        val amountInput = findViewById<EditText>(R.id.amountInput)

        btnExplicitActivity.setOnClickListener {

            val code = codeInput.text.toString()
            val fullname = fullnameInput.text.toString()
            val amount = amountInput.text.toString()

            if ("" == code || "" == fullname || "" == amount) {
                Toast.makeText(this, "Los campos son requeridos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("code", code.toInt())
            intent.putExtra("fullname", fullname)
            intent.putExtra("amount", amount.toDouble())
            startActivity(intent)
        }

        btnImplicitActivity.setOnClickListener {

            val code = codeInput.text.toString()
            val fullname = fullnameInput.text.toString()
            val amount = amountInput.text.toString()

            if ("" == code || "" == fullname || "" == amount) {
                Toast.makeText(this, "Los campos son requeridos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "code: $code\nfullname: $fullname\namount: $amount")
            intent.type = "text/plain"
            startActivity(intent)
        }
    }
}
