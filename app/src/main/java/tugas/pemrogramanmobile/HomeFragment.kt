package tugas.pemrogramanmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import tugas.pemrogramanmobile.databinding.FragmentHomeBinding
import tugas.pemrogramanmobile.rbchotel.Kamar
import tugas.pemrogramanmobile.rbchotel.KamarAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPromoRecyclerView()
        setupKamarRecyclerView()
    }

    private fun setupPromoRecyclerView() {
        val promoList = listOf(
            Promo("Diskon 30% Libur Sekolah", R.drawable.kamar_standard),
            Promo("Promo Cashback Rp 100rb", R.drawable.kamar_deluxe),
            Promo("Hemat s/d 50% di RBC Hotel", R.drawable.logo)
        )

        val promoAdapter = PromoAdapter(promoList)
        binding.rvPromo.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = promoAdapter
        }
    }

    private fun setupKamarRecyclerView() {
        val daftarKamar = arrayListOf(
            Kamar("Standard Room", "Rp 450.000 / Malam", R.drawable.kamar_standard, "Kamar nyaman dengan kasur Queen Size, TV kabel, dan pemandangan kota."),
            Kamar("Deluxe Room", "Rp 750.000 / Malam", R.drawable.kamar_deluxe, "Ruangan luas dengan kasur King Size, area duduk santai, dan minibar."),
            Kamar("President Suite", "Rp 1.500.000 / Malam", R.drawable.logo, "Kemewahan tanpa batas dengan layanan butler 24 jam.")
        )

        val kamarAdapter = KamarAdapter(daftarKamar)
        binding.rvKamar.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = kamarAdapter
            isNestedScrollingEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}