package com.example.ladymobile.pertemuan_10

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ladymobile.R
import com.example.ladymobile.databinding.ActivityTenthBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding
    private lateinit var messageAdapter: MessageAdapter
    private val allMessages = mutableListOf<MessageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar Navigation
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Initialize Dummy Data (Local Boy & Girl Avatars + Natural Messages)
        initDummyData()

        // Setup MessageAdapter & ListView
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
                    avatarResId = R.drawable.ic_avatar_boy
                )
                allMessages.add(0, newMessage)
                messageAdapter.notifyDataSetChanged()
                binding.editMessageText.text?.clear()
                Snackbar.make(binding.root, "Pesan terkirim! 🚀", Snackbar.LENGTH_SHORT).show()
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
        gridButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                Toast.makeText(this, "Aksi: ${button.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initDummyData() {
        allMessages.addAll(
            listOf(
                MessageModel("Budi", "P, tugas p10 udah selese belom bro?", R.drawable.ic_avatar_boy),
                MessageModel("Siti", "Nanti kumpul kantin ya abis kelas!", R.drawable.ic_avatar_girl),
                MessageModel("Rian", "Minjem catetan kemarin dnk pliss", R.drawable.ic_avatar_boy),
                MessageModel("Nabila", "Info dosen udah masuk room zoom belom?", R.drawable.ic_avatar_girl),
                MessageModel("Fauzi", "Gasss nugas bareng di perpus jam 3", R.drawable.ic_avatar_boy),
                MessageModel("Dewi", "Woi laporan kelompok siapa yg pegang?", R.drawable.ic_avatar_girl),
                MessageModel("Eko", "Gas kan mabar bentar habis maghrib", R.drawable.ic_avatar_boy),
                MessageModel("Fitri", "Ada yg ngerti bagian gridlayout ga?", R.drawable.ic_avatar_girl),
                MessageModel("Gilang", "Santuy besok kan masih tenggat jam 12 malem", R.drawable.ic_avatar_boy),
                MessageModel("Indah", "Makasih ya gengs buat bantuan tadi!", R.drawable.ic_avatar_girl)
            )
        )
    }
}
