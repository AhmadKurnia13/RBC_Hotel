package tugas.pemrogramanmobile

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.widget.doOnTextChanged
import tugas.pemrogramanmobile.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupRealTimeValidation()
        setupActionButtons()
    }

    private fun setupSpinner() {
        val accountTypes = arrayOf("Personal", "Bisnis", "VIP", "Ekonomi")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, accountTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spAccountType.adapter = adapter
    }

    private fun setupRealTimeValidation() {
        binding.etFullName.doOnTextChanged { text, _, _, _ ->
            binding.tilFullName.error = null
        }

        binding.etEmail.doOnTextChanged { text, _, _, _ ->
            val email = text.toString()
            if (email.contains("@") && email.contains(".")) {
                binding.tilEmail.setEndIconDrawable(android.R.drawable.checkbox_on_background)
                binding.tilEmail.setEndIconMode(com.google.android.material.textfield.TextInputLayout.END_ICON_CUSTOM)
                binding.tilEmail.setEndIconTintList(android.content.res.ColorStateList.valueOf(android.graphics.Color.GREEN))
            } else {
                binding.tilEmail.setEndIconMode(com.google.android.material.textfield.TextInputLayout.END_ICON_NONE)
            }
            binding.tilEmail.error = null
        }

        binding.etPassword.doOnTextChanged { _, _, _, _ ->
            binding.tilPassword.error = null
        }

        binding.etConfirmPassword.doOnTextChanged { _, _, _, _ ->
            binding.tilConfirmPassword.error = null
        }
    }

    private fun setupActionButtons() {
        binding.btnRegister.setOnClickListener {
            if (validateFormWithShake()) {
                showConfirmationDialog()
            }
        }

        binding.tvGoToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(this, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            startActivity(intent, options.toBundle())
            finish()
        }
    }

    private fun validateFormWithShake(): Boolean {
        var isValid = true

        if (binding.etFullName.text.isNullOrEmpty()) {
            binding.tilFullName.error = "Nama wajib diisi"
            binding.tilFullName.shake()
            isValid = false
        }

        val email = binding.etEmail.text.toString()
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Email tidak valid"
            binding.tilEmail.shake()
            isValid = false
        }

        if (binding.etPassword.text.isNullOrEmpty()) {
            binding.tilPassword.error = "Password wajib diisi"
            binding.tilPassword.shake()
            isValid = false
        }

        if (binding.etConfirmPassword.text.toString() != binding.etPassword.text.toString()) {
            binding.tilConfirmPassword.error = "Password tidak cocok"
            binding.tilConfirmPassword.shake()
            isValid = false
        }

        return isValid
    }

    private fun showConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi")
            .setMessage("Apakah data sudah benar?")
            .setPositiveButton("Ya") { _, _ ->
                Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}