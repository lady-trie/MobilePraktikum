package com.example.ladymobile.message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ladymobile.R
import com.example.ladymobile.databinding.FragmentMessageBinding
import com.example.ladymobile.message.tutorial.TutorialMessageActivity

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarMessage.inflateMenu(R.menu.message_toolbar_menu)
        binding.toolbarMessage.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_tutorial -> {
                    val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
