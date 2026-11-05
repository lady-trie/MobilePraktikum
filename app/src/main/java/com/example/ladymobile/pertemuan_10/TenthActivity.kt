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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar Navigation
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Initialize Dummy Data (10 Messages)
        initDummyData()

        // Setup MessageAdapter & ListView (Requirement 2)
        messageAdapter = MessageAdapter(this, allMessages)
        binding.listViewMessages.adapter = messageAdapter

        // Form Submit Handler
        binding.btnSubmitMessage.setOnClickListener {
            val text = binding.editMessageText.text.toString().trim()
            if (text.isEmpty()) {
                binding.textInputLayoutMessage.error = "Pesan tidak boleh kosong"
            } else {
                binding.textInputLayoutMessage.error = null
                val newMessage = MessageModel(
                    senderName = "Anda",
                    messageText = text,
                    avatarUrl = "https://picsum.photos/200?random=99"
                )
                allMessages.add(0, newMessage)
                messageAdapter.notifyDataSetChanged()
                binding.editMessageText.text?.clear()
                Snackbar.make(binding.root, "Pesan berhasil ditambahkan!", Snackbar.LENGTH_SHORT).show()
            }
        }

        // ChipGroup Filter Handler (Requirement 3)
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val checkedChip = group.findViewById<Chip>(checkedIds[0])
                checkedChip?.let { chip ->
                    Toast.makeText(this, "Filter dipilih: ${chip.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // GridLayout Buttons Click Handlers (Requirement 3)
        val gridButtons = listOf(
            binding.btnGrid1, binding.btnGrid2, binding.btnGrid3,
            binding.btnGrid4, binding.btnGrid5, binding.btnGrid6
        )
        gridButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                Toast.makeText(this, "Klik ${button.text} (Tombol ${index + 1})", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initDummyData() {
        allMessages.addAll(
            listOf(
                MessageModel("Budi Santoso", "Halo, bagaimana kabar tugas praktikum Pertemuan 10?", "https://picsum.photos/200?random=1"),
                MessageModel("Siti Rahma", "Jangan lupa kirim laporan hari ini ya!", "https://picsum.photos/200?random=2"),
                MessageModel("Ahmad Fauzi", "Design UI dengan Material Design makin rapi.", "https://picsum.photos/200?random=3"),
                MessageModel("Dewi Lestari", "Ada meeting jam 2 siang nanti di lab.", "https://picsum.photos/200?random=4"),
                MessageModel("Rian Pratama", "Projek Android Studio sudah siap di-submit.", "https://picsum.photos/200?random=5"),
                MessageModel("Nabila Putri", "Glide membuat loading gambar jadi makin cepat!", "https://picsum.photos/200?random=6"),
                MessageModel("Eko Wijaya", "Custom AdapterListView bekerja dengan sangat baik.", "https://picsum.photos/200?random=7"),
                MessageModel("Fitri Handayani", "ChipGroup dan Form Material3 terlihat modern.", "https://picsum.photos/200?random=8"),
                MessageModel("Gilang Ramadhan", "Semangat praktikum Pemrograman Mobile!", "https://picsum.photos/200?random=9"),
                MessageModel("Indah Permata", "Terima kasih atas bantuannya hari ini.", "https://picsum.photos/200?random=10")
            )
        )
    }
}
