package com.masudin.kawalcovid19.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masudin.kawalcovid19.Model.Corona
import com.masudin.kawalcovid19.R
import kotlinx.android.synthetic.main.card.view.*

class RecyclerAdapter(private val model: Corona, private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card, parent, false))
    }

    override fun getItemCount(): Int {
        return model.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.valueReg.text = model[position].attributes.countryRegion
        holder.itemView.valueConfirm.text = "${model[position].attributes.confirmed}"
        holder.itemView.valueDeath.text = "${model[position].attributes.deaths}"
        holder.itemView.valueRecover.text ="${model[position].attributes.recovered }"
        holder.itemView.valueActive.text = "${model[position].attributes.active}"

    }
}