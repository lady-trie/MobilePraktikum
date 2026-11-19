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
import com.example.ladymobile.pertemuan_10.MessageAdapter
import com.example.ladymobile.pertemuan_10.MessageModel
import com.google.android.material.snackbar.Snackbar

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private val allMessages = mutableListOf<MessageModel>()
    private lateinit var messageAdapter: MessageAdapter

    private val sampleMessages = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://picsum.photos/seed/alya/200/200"),
        MessageModel("Budi", "Sudah lihat fitur baru Pertemuan 11 & 12?", "https://picsum.photos/seed/budi/200/200"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://picsum.photos/seed/citra/200/200"),
        MessageModel("Dika", "Klik tombol info di toolbar atas untuk lihat tutorial onboarding!", "https://picsum.photos/seed/dika/200/200"),
        MessageModel("Eka", "Nice job praktikum hari ini!", "https://picsum.photos/seed/eka/200/200")
    )

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

        if (allMessages.isEmpty()) {
            allMessages.addAll(sampleMessages)
        }

        messageAdapter = MessageAdapter(requireContext(), allMessages)
        binding.listViewMessages.adapter = messageAdapter

        binding.btnSubmitMessage.setOnClickListener {
            val text = binding.editMessageText.text.toString().trim()
            if (text.isEmpty()) {
                binding.textInputLayoutMessage.error = "Pesan tidak boleh kosong!"
            } else {
                binding.textInputLayoutMessage.error = null
                val newMessage = MessageModel(
                    senderName = "Saya",
                    messageText = text,
                    avatarUrl = "https://picsum.photos/seed/me/200/200"
                )
                allMessages.add(0, newMessage)
                messageAdapter.notifyDataSetChanged()
                binding.editMessageText.text?.clear()
                Snackbar.make(binding.root, "Pesan terkirim!", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
