package com.cmartus.contactsprojects.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cmartus.contactsprojects.Contact
import com.cmartus.contactsprojects.R

class ContactListAdapter(private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null

    var listener: onItemClickListener? = null

    fun settingListener(listener: onItemClickListener?){
        this.listener = listener
    }

    interface onItemClickListener{
        fun onClick(str: String)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int){
        val name = holder.name
        val phone = holder.phoneNumber
        val contactId = holder.id
        var deleteButton = holder.deleteButton
        contactList.let{
            name.text = it!![listPosition].contactName
            phone.text = it!![listPosition].phoneNumber
            contactId.text = it!![listPosition].id.toString()
        }

        deleteButton.setOnClickListener(View.OnClickListener {
            var id = contactId.text.toString()
            listener?.onClick(id)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var phoneNumber: TextView = itemView.findViewById(R.id.phoneNumber)
        var id: TextView = itemView.findViewById(R.id.contactId)
        var deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
    }
}