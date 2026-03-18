package tugas.pemrogramanmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PromoAdapter(private val listPromo: List<Promo>) : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_promo, parent, false)
        return PromoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        val promo = listPromo[position]
        holder.tvTitle.text = promo.title
        holder.ivPromo.setImageResource(promo.imageRes)
    }

    override fun getItemCount(): Int = listPromo.size

    class PromoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPromo: ImageView = itemView.findViewById(R.id.iv_promo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_promo_title)
    }
}