package com.example.mycontactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontactlist.databinding.ContactInfoBinding

class Adapter(
    val listContacts: MutableList<Contacts>, val listener: MainActivity): RecyclerView.Adapter<Adapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ContactInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount(): Int {
        return listContacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = listContacts[position]
        holder.name.text = listContacts[position].name
        holder.phone.text = listContacts[position].phone


        holder.root.setOnClickListener{
            listener.onContactSelected(contact.phone)
        }

    }

    inner class ContactViewHolder(binding: ContactInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        val root = binding.root
        var name = binding.nameinfo
        var phone = binding.phoneinfo
    }
    }