package com.example.ladymobile.pertemuan_10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.ladymobile.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = if (convertView == null) {
            ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemMessageBinding.bind(convertView)
        }

        val message = getItem(position)
        message?.let { item ->
            binding.textSender.text = item.senderName
            binding.textMessage.text = item.messageText

            Glide.with(context)
                .load(item.avatarResId)
                .circleCrop()
                .into(binding.avatarImg)

            binding.root.setOnClickListener { view ->
                Snackbar.make(
                    view,
                    "${item.senderName}: ${item.messageText}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }
}
