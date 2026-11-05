package com.example.ladymobile.message.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ladymobile.R
import com.example.ladymobile.databinding.FragmentTutorial1Binding

class TutorialFragment : Fragment() {

    private var _binding: FragmentTutorial1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorial1Binding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(position: Int): Fragment {
            return when (position) {
                0 -> Tutorial1Fragment()
                1 -> Tutorial2Fragment()
                2 -> Tutorial3Fragment()
                else -> Tutorial1Fragment()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
