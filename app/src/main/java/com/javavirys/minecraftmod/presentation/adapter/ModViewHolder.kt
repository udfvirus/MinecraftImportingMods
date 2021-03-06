package com.javavirys.minecraftmod.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.javavirys.minecraftmod.R
import com.javavirys.minecraftmod.core.entity.Mod
import com.javavirys.minecraftmod.util.extension.loadBitmapFromAssets

class ModViewHolder(
    view: View,
    private val onItemClick: (item: Mod) -> Unit,
    private val onCheckItem: (item: Mod) -> Unit
) : RecyclerView.ViewHolder(view) {

    private var favoriteImage: Int = 0

    private val titleTextView by lazy {
        ViewCompat.requireViewById<TextView>(
            itemView,
            R.id.title
        )
    }

    private val logoImageView by lazy {
        ViewCompat.requireViewById<ImageView>(
            itemView,
            R.id.image
        )
    }

    private val favoriteImageView by lazy {
        ViewCompat.requireViewById<ImageView>(
            itemView,
            R.id.favorite
        )
    }

    fun bind(item: Mod) {
        item.callback = { updateFavoriteImage(item) }

        itemView.setOnClickListener {
            onItemClick(item)
        }

        favoriteImageView.setOnClickListener {
            item.favorite = item.favorite.not()
            updateFavoriteImage(item)
            onCheckItem(item)
        }

        updateFavoriteImage(item)

        titleTextView.text = item.name
        if (item.image == null) {
            item.image = itemView.context.loadBitmapFromAssets("images/${item.imagePath}")
        }
        logoImageView.setImageBitmap(item.image)
    }

    private fun updateFavoriteImage(item: Mod) {
        val star = if (item.favorite) {
            R.drawable.ic_star_selected
        } else {
            R.drawable.ic_star_unselected
        }

        if (star == favoriteImage) {
            return
        }
        favoriteImage = star

        favoriteImageView.setImageResource(star)
    }
}