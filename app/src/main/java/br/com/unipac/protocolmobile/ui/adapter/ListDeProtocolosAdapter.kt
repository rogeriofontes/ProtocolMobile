package br.com.unipac.protocolmobile.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unipac.protocolmobile.R
import br.com.unipac.protocolo.model.Protocolo

class ListDeProtocolosAdapter(
    listDeProtocolos: List<Protocolo>?,
    internal val context: Context,
    private val callbacks: (Int) -> Unit
) : RecyclerView.Adapter<ListDeProtocolosAdapter.ViewHolder>() {
    internal var listDeProtocolos: List<Protocolo> = ArrayList<Protocolo>()

    init {
        if (listDeProtocolos != null) {
            this.listDeProtocolos = listDeProtocolos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflateView =
            LayoutInflater.from(context).inflate(R.layout.content_item_protocolo, parent, false)
        return ViewHolder(inflateView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                var protocolo = listDeProtocolos[position]

        holder.tvName.text = "${protocolo.primeiroNome}"
        if (position % 2 == 0) {
            holder.tvName.setBackgroundColor(Color.GRAY)
        } else {
            holder.tvName.setBackgroundColor(Color.WHITE)
        }

      //  holder.tvName.text = "${protocolo.primeiroNome}"
        holder.tvNumeroProtocolo.text = "${protocolo.numeroProtocolo}"

    }

    override fun getItemCount(): Int {
        return listDeProtocolos.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvNumeroProtocolo: TextView = view.findViewById(R.id.tvProtocolo)
    }


}