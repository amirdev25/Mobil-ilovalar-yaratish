package uz.amirdev.pdfviewer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.amirdev.pdfviewer.R
import uz.amirdev.pdfviewer.databinding.ItemLayoutBinding
import uz.amirdev.pdfviewer.models.ItemModel

class RVAdapter(private val itemList: ArrayList<ItemModel>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ItemLayoutBinding.bind(holder.itemView).apply {
            itemText.text = itemList[position].name
            itemImg.setImageResource(itemList[position].img)
        }

        holder.itemView.setOnClickListener {
            listener.onClick(itemList[position], position)
        }
    }

    override fun getItemCount() = itemList.size
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    interface OnItemClickListener {
        fun onClick(item: ItemModel, position: Int)
    }
}