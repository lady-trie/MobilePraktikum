package com.example.ladymobile.pertemuan_12

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ladymobile.data.api.RetrofitClient
import com.example.ladymobile.databinding.FragmentPicsumGalleryBinding
import kotlinx.coroutines.launch

class PicsumGalleryFragment : Fragment() {

    private var _binding: FragmentPicsumGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPicsumGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchPhotos()
    }

    private fun fetchPhotos() {
        binding.progressBarPicsum.visibility = View.VISIBLE

        lifecycleScope.launch {
            try {
                val photoList = RetrofitClient.picsumApiService.getPhotos(page = 1, limit = 30)
                binding.progressBarPicsum.visibility = View.GONE

                val adapter = PicsumPhotoAdapter(photoList) { photo ->
                    Toast.makeText(
                        requireContext(),
                        "Foto oleh: ${photo.author}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                binding.rvPicsumPhotos.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rvPicsumPhotos.adapter = adapter
            } catch (e: Exception) {
                binding.progressBarPicsum.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    "Gagal memuat galeri: ${e.localizedMessage}",
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
