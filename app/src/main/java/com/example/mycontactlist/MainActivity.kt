package com.example.mycontactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontactlist.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val contactLst: MutableList<Contacts> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactView = binding.contactList
        createMockData()

        contactView.layoutManager = LinearLayoutManager(this)
        contactView.adapter = Adapter(contactLst, this)
    }
    private fun createMockData(){
        contactLst.add(Contacts("Marcos", "21995244867"))
        contactLst.add(Contacts("Mateus", "21995254461"))
        contactLst.add(Contacts("Paulo", "21981254365"))
        contactLst.add(Contacts("Maria", "11944294761"))
        contactLst.add(Contacts("Luiza", "11935213469"))

    }
     fun onContactSelected(content: String) {
        Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT).show()
    }
}