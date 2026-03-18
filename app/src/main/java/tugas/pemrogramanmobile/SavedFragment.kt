package tugas.pemrogramanmobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import tugas.pemrogramanmobile.databinding.FragmentSavedBinding
import tugas.pemrogramanmobile.rbchotel.Kamar
import tugas.pemrogramanmobile.rbchotel.KamarAdapter

class SavedFragment : Fragment() {

    private var _binding: FragmentSavedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Dummy data: Kamar yang seolah disukai user
        val savedKamar = arrayListOf(
            Kamar("Deluxe Room", "Rp 750.000 / Malam", R.drawable.kamar_deluxe, "Ruangan luas dengan kasur King Size dan area duduk santai."),
            Kamar("President Suite", "Rp 1.500.000 / Malam", R.drawable.logo, "Kemewahan tanpa batas dengan layanan butler 24 jam.")
        )

        // Reuse KamarAdapter yang sudah ada
        val adapter = KamarAdapter(savedKamar)
        binding.rvSavedKamar.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}