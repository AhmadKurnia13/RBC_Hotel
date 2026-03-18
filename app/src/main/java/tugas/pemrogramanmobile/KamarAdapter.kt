package tugas.pemrogramanmobile.rbchotel // Sesuaikan package kamu!

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tugas.pemrogramanmobile.R

class KamarAdapter(private val listKamar: ArrayList<Kamar>) : RecyclerView.Adapter<KamarAdapter.KamarViewHolder>() {

    // Menyambungkan dengan file XML item_kamar yang kita buat tadi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KamarViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kamar, parent, false)
        return KamarViewHolder(view)
    }

    // Menghitung jumlah total data kamar
    override fun getItemCount(): Int {
        return listKamar.size
    }

    // Memasukkan data ke masing-masing komponen di dalam desain
    override fun onBindViewHolder(holder: KamarViewHolder, position: Int) {
        val kamar = listKamar[position]
        holder.imgKamar.setImageResource(kamar.gambarKamar)
        holder.tvNamaKamar.text = kamar.namaKamar
        holder.tvHargaKamar.text = kamar.hargaKamar

        // Ketika seluruh area kotak (itemView) diklik
        holder.itemView.setOnClickListener {
            // 1. Buat Intent (Kendaraan) menuju DetailKamarActivity
            // Kita pakai holder.itemView.context karena kita butuh "context" dari layar saat ini
            val intentDetail = android.content.Intent(holder.itemView.context, DetailKamarActivity::class.java)

            // 2. Masukkan data ke dalam kendaraan (seperti menaruh barang di bagasi)
            intentDetail.putExtra("EXTRA_NAMA", kamar.namaKamar)
            intentDetail.putExtra("EXTRA_HARGA", kamar.hargaKamar)
            intentDetail.putExtra("EXTRA_GAMBAR", kamar.gambarKamar)
            intentDetail.putExtra("EXTRA_DESKRIPSI", kamar.deskripsiKamar)

            // 3. Berangkat!
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    // Deklarasi ID komponen dari XML
    class KamarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgKamar: ImageView = itemView.findViewById(R.id.img_kamar)
        val tvNamaKamar: TextView = itemView.findViewById(R.id.tv_nama_kamar)
        val tvHargaKamar: TextView = itemView.findViewById(R.id.tv_harga_kamar)
    }
}