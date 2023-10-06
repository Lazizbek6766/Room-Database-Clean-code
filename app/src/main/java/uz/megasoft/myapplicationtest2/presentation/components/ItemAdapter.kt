package uz.megasoft.myapplicationtest2.presentation.components

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.megasoft.myapplicationtest2.databinding.ItemRecyclerBinding
import uz.megasoft.myapplicationtest2.domain.model.Item

class ItemAdapter(
    val deleteItemClick: (id: Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    var listener: ((Item) -> Unit)? = null
    private val dif = AsyncListDiffer(this, ITEM_DIFF)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {

        return ViewHolder(
            ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()
    override fun getItemCount() = dif.currentList.size

    inner class ViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind() {
            val item = dif.currentList[adapterPosition]
            binding.apply {

                tvName.text = item.name
                tvDescription.text = item.description

                root.setOnClickListener {
                    listener?.invoke(item)
                }

                tvRemove.setOnClickListener {
                    deleteItemClick(item.id)
                }
            }
        }
    }

    fun submitList(list: List<Item>) {
        dif.submitList(list)
    }

    companion object {
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem
        }
    }
}