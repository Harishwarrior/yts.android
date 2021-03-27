package com.harish.yify.presentation.screens.details.viewholders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.harish.yify.R

class GalleryViewHolder(root: View) : RecyclerView.ViewHolder(root) {
    val imageView: ImageView = root.findViewById(R.id.iv_gallery)
}