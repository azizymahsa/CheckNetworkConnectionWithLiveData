package azizy.mahsa.checknetworkconnectionwithlivedata

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import azizy.mahsa.checknetworkconnectionwithlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding: ActivityMainBinding

    //other
    private val checkConnection by lazy { CheckConnection(application) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {
            checkConnection.observe(this@MainActivity) {
                if (it) {
                    networkImg.setImageResource(R.drawable.ic_round_wifi_24)
                    networkImg.setColorFilter(
                        ContextCompat.getColor(this@MainActivity, R.color.green),
                        PorterDuff.Mode.MULTIPLY
                    )
                    networkStatus.text = "CONNECTED :)"
                    networkStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.green))
                } else {
                    networkImg.setImageResource(R.drawable.ic_round_wifi_off_24)
                    networkImg.setColorFilter(
                        ContextCompat.getColor(this@MainActivity, R.color.red),
                        PorterDuff.Mode.MULTIPLY
                    )
                    networkStatus.text="DISCONNECTED :("
                    networkStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.red))
                }
            }

        }

    }
}