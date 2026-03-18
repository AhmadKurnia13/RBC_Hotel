package tugas.pemrogramanmobile.rbchotel // <-- Pastikan ini sesuai dengan package kamu!

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import tugas.pemrogramanmobile.R

class DetailKamarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kamar)

        // 1. Hubungkan variabel dengan ID di XML
        val imgKamar: ImageView = findViewById(R.id.img_detail_kamar)
        val tvNama: TextView = findViewById(R.id.tv_detail_nama)
        val tvHarga: TextView = findViewById(R.id.tv_detail_harga)
        val tvDeskripsi: TextView = findViewById(R.id.tv_detail_deskripsi)

        // 2. Ambil data dari "bagasi" Intent yang dikirim oleh Adapter
        // Perhatikan nama "EXTRA_NAMA" harus persis sama ejaannya dengan yang di Adapter
        val namaDitangkap = intent.getStringExtra("EXTRA_NAMA")
        val hargaDitangkap = intent.getStringExtra("EXTRA_HARGA")
        val deskripsiDitangkap = intent.getStringExtra("EXTRA_DESKRIPSI")
        // Untuk gambar (tipe data Int/Angka), kita butuh nilai default (misal 0) jika gagal terambil
        val gambarDitangkap = intent.getIntExtra("EXTRA_GAMBAR", 0)

        // 3. Pasang data yang ditangkap ke layar (UI)
        tvNama.text = namaDitangkap
        tvHarga.text = hargaDitangkap
        tvDeskripsi.text = deskripsiDitangkap
        imgKamar.setImageResource(gambarDitangkap)
    }
}