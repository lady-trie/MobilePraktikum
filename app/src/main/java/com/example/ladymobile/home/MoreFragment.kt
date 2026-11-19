package com.example.ladymobile.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ladymobile.databinding.FragmentMoreBinding
import com.google.android.material.snackbar.Snackbar

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccountSettings.setOnClickListener {
            Toast.makeText(requireContext(), "Buka Pengaturan Akun", Toast.LENGTH_SHORT).show()
        }

        binding.btnAppAbout.setOnClickListener {
            Snackbar.make(binding.root, "LadyMobile v1.0 - Modul Praktikum Android Kotlin", Snackbar.LENGTH_LONG).show()
        }

        binding.btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Logout berhasil!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
