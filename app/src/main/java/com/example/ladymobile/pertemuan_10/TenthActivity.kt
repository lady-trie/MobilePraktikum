package com.example.ladymobile.pertemuan_10

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ladymobile.databinding.ActivityTenthBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding
    private lateinit var messageAdapter: MessageAdapter
    private val allMessages = mutableListOf<MessageModel>()

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://avatarapi.runflare.run/public/1"),
        MessageModel("Budi", "Sudah makan?", "https://avatarapi.runflare.run/public/2"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://avatarapi.runflare.run/public/3"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://avatarapi.runflare.run/public/4"),
        MessageModel("Eka", "Nice job kemarin!", "https://avatarapi.runflare.run/public/5"),
        MessageModel("Fajar", "Lagi ngapain?", "https://avatarapi.runflare.run/public/6"),
        MessageModel("Gita", "Boleh minta tolong?", "https://avatarapi.runflare.run/public/7"),
        MessageModel("Hana", "Lihat email ya", "https://avatarapi.runflare.run/public/8"),
        MessageModel("Irfan", "Oke noted", "https://avatarapi.runflare.run/public/9"),
        MessageModel("Joko", "Sampai jumpa besok", "https://avatarapi.runflare.run/public/10")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar Navigation
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Initialize Message List
        allMessages.addAll(messageList)

        // MessageAdapter Setup
        messageAdapter = MessageAdapter(this, allMessages)
        binding.listViewMessages.adapter = messageAdapter

        // Form Submit Handler
        binding.btnSubmitMessage.setOnClickListener {
            val text = binding.editMessageText.text.toString().trim()
            if (text.isEmpty()) {
                binding.textInputLayoutMessage.error = "Pesan tidak boleh kosong!"
            } else {
                binding.textInputLayoutMessage.error = null
                val newMessage = MessageModel(
                    senderName = "Saya",
                    messageText = text,
                    avatarUrl = "https://avatarapi.runflare.run/public/11"
                )
                allMessages.add(0, newMessage)
                messageAdapter.notifyDataSetChanged()
                binding.editMessageText.text?.clear()
                Snackbar.make(binding.root, "Pesan terkirim! ✨", Snackbar.LENGTH_SHORT).show()
            }
        }

        // ChipGroup Filter Handler
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val checkedChip = group.findViewById<Chip>(checkedIds[0])
                checkedChip?.let { chip ->
                    Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // GridLayout Buttons Click Handlers
        val gridButtons = listOf(
            binding.btnGrid1, binding.btnGrid2, binding.btnGrid3,
            binding.btnGrid4, binding.btnGrid5, binding.btnGrid6
        )
        gridButtons.forEach { button ->
            button.setOnClickListener {
                Toast.makeText(this, "Aksi: ${button.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
