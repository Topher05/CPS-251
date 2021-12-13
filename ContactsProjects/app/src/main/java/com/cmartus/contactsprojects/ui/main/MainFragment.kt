package com.cmartus.contactsprojects.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cmartus.contactsprojects.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.viewModels
import com.cmartus.contactsprojects.Contact

import com.cmartus.contactsprojects.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactPhone.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val phoneNumber = binding.contactPhone.text.toString()

            if(name.isNotEmpty() && phoneNumber.isNotEmpty()){
                val contact = Contact(name, phoneNumber)
                viewModel.insertContact(contact)
                clearFields()
            }

            binding.findButton.setOnClickListener{
                val name = binding.contactName.text.toString()
                if(name.isNotEmpty()){
                    viewModel.findContact(name)
                    clearFields()
                }else{
                    Toast.makeText(context, "Please enter a name to search for", Toast.LENGTH_SHORT).show()
                }
            }

            binding.sortAscButton.setOnClickListener{
                viewModel.getSortedListAsc()
            }

            binding.sortDescButton.setOnClickListener {
                viewModel.getSortedListDesc()
            }

        }
    }

    private fun observerSetup(){
        viewModel.getAllContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(this, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    Toast.makeText(context, "No contact found with that name", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_view)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener((object: ContactListAdapter.onItemClickListener{
            override fun onClick(id: String) {
                var contactId: Int = parseInt(id)
                viewModel.deleteContact(contactId)
            }
        }))
    }

}