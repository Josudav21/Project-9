package com.example.project9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project9.databinding.ItemUserBinding
import com.example.project9.local_db.entity.User

class UserAdapter(
    private val onUserClickListener: OnUserClickListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    interface OnUserClickListener {
        fun onUserClicked(user: User)
    }

    private val listContainer = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = listContainer[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return listContainer.size
    }

    fun populateData(input: List<User>) {
        listContainer.clear()
        listContainer.addAll(input)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User) {
            binding.apply {
                tvName.text = user.name
                tvEmail.text = user.email
                tvPhone.text = user.phoneNumber
                clRoot.setOnClickListener{
                    onUserClickListener.onUserClicked(user)
                }

            }
        }
    }

}