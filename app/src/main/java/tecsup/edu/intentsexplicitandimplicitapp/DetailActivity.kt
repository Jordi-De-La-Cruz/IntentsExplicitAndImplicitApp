package tecsup.edu.intentsexplicitandimplicitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val codeText = findViewById<TextView>(R.id.codeText)
        val fullnameText = findViewById<TextView>(R.id.fullnameText)
        val amountText = findViewById<TextView>(R.id.amountText)

        if (this.intent.extras != null) {
            if (this.intent.extras!!["code"] != null) {
                val code = this.intent.extras!!.getInt("code")
                codeText.text = code.toString()
            }

            if (this.intent.extras!!["fullname"] != null) {
                val fullname = this.intent.extras!!.getString("fullname")
                fullnameText.text = fullname
            }

            if (this.intent.extras!!["amount"] != null) {
                val amount = this.intent.extras!!.getDouble("amount")
                amountText.text = amount.toString()
            }
        }
    }
}
