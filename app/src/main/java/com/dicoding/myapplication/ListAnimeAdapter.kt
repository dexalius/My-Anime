package com.dicoding.myapplication

//import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAnimeAdapter(private val listAnime: ArrayList<Anime>) : RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_anime, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listAnime[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description


        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listAnime[holder.adapterPosition]) }

//        holder.itemView.setOnClickListener {
//            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
//            intentDetail.putExtra("key_anime", listAnime[holder.adapterPosition])
//            holder.itemView.context.startActivity(intentDetail)
//        }
    }

    override fun getItemCount(): Int = listAnime.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Anime)
    }


}