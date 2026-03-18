package tugas.pemrogramanmobile.rbchotel // Sesuaikan dengan package kamu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import tugas.pemrogramanmobile.GetStartedActivity
import tugas.pemrogramanmobile.LoginActivity
import tugas.pemrogramanmobile.R

class SplashScreenActivity : AppCompatActivity() {

    // Tentukan berapa lama Splash Screen muncul (dalam milidetik)
    // 3000 milidetik = 3 detik
    private val splashDelay: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // --- Logika Splash Screen Dimulai di Sini ---

        // Kita menggunakan Handler untuk menjalankan kode setelah jeda waktu tertentu
        // Looper.getMainLooper() memastikan kode dijalankan di Main Thread (thread UI)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreenActivity, GetStartedActivity::class.java)
            startActivity(intent)
            finish()

        }, splashDelay) // splashDelay adalah jeda waktu yang sudah kita tentukan di atas

    }
}