package com.example.ladymobile.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.ladymobile.data.api.RetrofitClient
import com.example.ladymobile.databinding.FragmentHomeBinding
import com.example.ladymobile.pertemuan_2.SecondActivity
import com.example.ladymobile.pertemuan_3.ThirdActivity
import com.example.ladymobile.pertemuan_4.FourthActivity
import com.example.ladymobile.pertemuan_5.FifthActivity
import com.example.ladymobile.pertemuan_6.SplashScreenActivity
import com.example.ladymobile.pertemuan_7.Pertemuan7Activity
import com.example.ladymobile.pertemuan_10.TenthActivity
import com.example.ladymobile.pertemuan_11.EleventhActivity
import com.example.ladymobile.pertemuan_12.TwelfthActivity
import kotlinx.coroutines.launch

class FragmentHome : Fragment() {

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

        // Buttons Click Handlers
        binding.btnToSecond.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnToThird.setOnClickListener {
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Rumbai")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSixth.setOnClickListener {
            val intent = Intent(requireContext(), SplashScreenActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(requireContext(), Pertemuan7Activity::class.java)
            startActivity(intent)
        }

        binding.btnToTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToEleventh.setOnClickListener {
            val intent = Intent(requireContext(), EleventhActivity::class.java)
            startActivity(intent)
        }

        binding.btnToTwelfth.setOnClickListener {
            val intent = Intent(requireContext(), TwelfthActivity::class.java)
            startActivity(intent)
        }

        // CatFact Quote Refresh Setup
        fetchQuote()

        binding.btnRefreshQuote.setOnClickListener {
            fetchQuote()
        }
    }

    private fun fetchQuote() {
        binding.progressBarHomeQuote.visibility = View.VISIBLE

        lifecycleScope.launch {
            try {
                val catFact = RetrofitClient.catFactApiService.getCatFact()
                binding.progressBarHomeQuote.visibility = View.GONE
                binding.tvQuote.text = "\"${catFact.fact}\""
            } catch (e: Exception) {
                binding.progressBarHomeQuote.visibility = View.GONE
                binding.tvQuote.text = "\"Cats often overreact to unexpected stimuli because of their extremely sensitive nervous system.\""
                Toast.makeText(requireContext(), "CatFact Loaded", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
