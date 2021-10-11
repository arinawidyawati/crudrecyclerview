package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNis : EditText
    private lateinit var inputNama : EditText
    private lateinit var jkLakilaki: RadioButton
    private lateinit var jkPerempuan : RadioButton
    private lateinit var btnTambah: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: SiswaAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNis     = findViewById(R.id.txtInputNis)
        inputNama    = findViewById(R.id.txtInputNama)
        jkLakilaki   = findViewById(R.id.rbLakiLaki)
        jkPerempuan  = findViewById(R.id.rbPerempuan)
        btnTambah    = findViewById(R.id.btnTambah)
        recyclerView = findViewById(R.id.listData)
        val data = mutableListOf<SiswaData>()
        viewManager=LinearLayoutManager(this)
        recyclerAdapter= SiswaAdapter(data)
        recyclerView.adapter=recyclerAdapter
        recyclerView.layoutManager=viewManager
        //setOnclikListener untuk tombol Tambah Data
        btnTambah.setOnClickListener {
            //membuat variabel penyimpan data
            val nis = inputNis.text.toString()
            val nama = inputNama.text.toString()
            var jk =""
            if (jkLakilaki.isChecked) {
                jk = "Lakilaki"
            }else{
                jk="Perempuan"
            }
            //simpan data ke array mutableList
            val dataSiswa=SiswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}