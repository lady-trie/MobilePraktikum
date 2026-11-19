package com.example.ladymobile.pertemuan_12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ladymobile.data.model.PicsumPhotoModel
import com.example.ladymobile.databinding.ItemPicsumPhotoBinding

class PicsumPhotoAdapter(
    private val photoList: List<PicsumPhotoModel>,
    private val onItemClick: (PicsumPhotoModel) -> Unit
) : RecyclerView.Adapter<PicsumPhotoAdapter.PicsumViewHolder>() {

    class PicsumViewHolder(val binding: ItemPicsumPhotoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicsumViewHolder {
        val binding = ItemPicsumPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PicsumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PicsumViewHolder, position: Int) {
        val photo = photoList[position]
        with(holder.binding) {
            tvAuthor.text = "By: ${photo.author}"
            tvDimension.text = "${photo.width} x ${photo.height}"

            Glide.with(holder.itemView.context)
                .load(photo.downloadUrl)
                .centerCrop()
                .into(imgPicsumPhoto)

            root.setOnClickListener {
                onItemClick(photo)
            }
        }
    }

    override fun getItemCount(): Int = photoList.size
}
