package hu.bme.aut.android.brewdogapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.brewdogapplication.R
import hu.bme.aut.android.brewdogapplication.data.BeerListData
import hu.bme.aut.android.brewdogapplication.databinding.ItemBeerListBinding

class BeerListAdapter() : RecyclerView.Adapter<BeerListAdapter.ReportItemViewHolder>() {
    private val items = mutableListOf<BeerListData>()
    private lateinit var binding: ItemBeerListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportItemViewHolder {
        binding = ItemBeerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReportItemViewHolder(binding.root)
    }

    inner class ReportItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvBeerListTagline: TextView = binding.tvBeerListTagline
        val tvBeerListName: TextView = binding.tvBeerListName
        val tvBeerListAbv: TextView = binding.tvBeerListAbv
        val clBeerLayout: ConstraintLayout = binding.clBeerLayout

        var item: BeerListData? = null
    }

    override fun getItemCount() = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReportItemViewHolder, position: Int) {
        val item = items[position]

        holder.tvBeerListTagline.text = item.tagline
        holder.tvBeerListName.text = item.name
        holder.tvBeerListAbv.text = "${item.abv} %"

        holder.item = item
    }
}