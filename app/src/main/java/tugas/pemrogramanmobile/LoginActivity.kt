package tugas.pemrogramanmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import tugas.pemrogramanmobile.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Login button listener
        binding.btnLogin.setOnClickListener {
            if (validateLogin()) {
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                
                // Navigate to Dashboard
                val intentToDashboard = Intent(this@LoginActivity, DashboardActivity::class.java)
                startActivity(intentToDashboard)
                finish()
            }
        }

        // Navigate to Register
        binding.tvGoToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(intent, options.toBundle())
            finish()
        }
    }

    private fun validateLogin(): Boolean {
        var isValid = true
        
        if (binding.etEmail.text.isNullOrEmpty()) {
            binding.tilEmail.error = "Email tidak boleh kosong"
            binding.tilEmail.shake()
            isValid = false
        } else {
            binding.tilEmail.error = null
        }

        if (binding.etPassword.text.isNullOrEmpty()) {
            binding.tilPassword.error = "Password tidak boleh kosong"
            binding.tilPassword.shake()
            isValid = false
        } else {
            binding.tilPassword.error = null
        }

        return isValid
    }
}