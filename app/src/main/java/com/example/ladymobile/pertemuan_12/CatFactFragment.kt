package com.example.ladymobile.pertemuan_12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.ladymobile.data.api.RetrofitClient
import com.example.ladymobile.databinding.FragmentCatFactBinding
import kotlinx.coroutines.launch

class CatFactFragment : Fragment() {

    private var _binding: FragmentCatFactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatFactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchCatFact()

        binding.btnFetchFact.setOnClickListener {
            fetchCatFact()
        }
    }

    private fun fetchCatFact() {
        binding.progressBarCatFact.visibility = View.VISIBLE
        binding.tvCatFact.text = "Memuat fakta kucing dari API..."
        binding.tvFactLength.text = ""

        lifecycleScope.launch {
            try {
                val catFact = RetrofitClient.catFactApiService.getCatFact()
                binding.progressBarCatFact.visibility = View.GONE
                binding.tvCatFact.text = "\"${catFact.fact}\""
                binding.tvFactLength.text = "Panjang karakter: ${catFact.length}"
            } catch (e: Exception) {
                binding.progressBarCatFact.visibility = View.GONE
                binding.tvCatFact.text = "Gagal memuat fakta kucing."
                Toast.makeText(
                    requireContext(),
                    "Error API: ${e.localizedMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
