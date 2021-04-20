package com.poyraz.kitaplikproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
        var kitapAdi: TextView
        var yazarAdi: TextView
        var sehir: TextView
        var yorum:TextView
        var resim: ImageView

        init {
            kitapAdi = itemView.findViewById(R.id.textViewKitapAdi)
            yazarAdi = itemView.findViewById(R.id.textViewYazarAdi)
            sehir = itemView.findViewById(R.id.textViewSehir)
            yorum=itemView.findViewById(R.id.textViewYorum)
            resim=itemView.findViewById(R.id.imageViewKitapResim)

            /*itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, DetailPertanyaan::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemKode.text)
                    putExtra("CATEGORY", itemKategori.text)
                    putExtra("CONTENT", itemIsi.text)
                }
                context.startActivity(intent)
            }*/
        }

    }

    private val yazarlar = arrayOf("Halide Edip Adıvar",
        "Ömer Seyfettin", "Peyami Safa", "Reşat Nuri Güntekin",
        "Ahmet Hamdi Tanpınar", "Sait Faik Abasıyanık", "Sabahattin Ali",
        "Oğuz Atay")

    private val kitaplar = arrayOf("Sinekli Bakkal", "Kaşağı",
        "Dokuzuncu Hariciye Koğuşu", "Çalıkuşu",
        "Huzur", "Lüzumsuz Adam",
        "Kürk Mantolu Madonna", "Tutunamaynalar")

    private val sehirler = arrayOf("Ankara",
        "İstanbul", "Nevşehir", "Kayseri",
        "İzmir", "Yalova", "Yozgat",
        "Antalya")

    private val resimler = arrayOf(R.drawable.cile,R.drawable.kurkmantolumadonna,
        R.drawable.luzumsuzadam,R.drawable.sineklibakal,R.drawable.tutunamayanlar,
        R.drawable.cile,R.drawable.kurkmantolumadonna,R.drawable.luzumsuzadam)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.kitapAdi.text = kitaplar[position]
        holder.yazarAdi.text = yazarlar[position]
        holder.sehir.text = sehirler[position]
        holder.resim.setImageResource(resimler[position])
    }

    override fun getItemCount(): Int {
        return kitaplar.size
    }
}
