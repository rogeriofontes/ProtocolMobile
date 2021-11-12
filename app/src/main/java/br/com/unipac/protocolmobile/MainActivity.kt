package br.com.unipac.protocolmobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unipac.protocolmobile.infra.AppDatabase
import br.com.unipac.protocolmobile.ui.adapter.ListDeProtocolosAdapter
import br.com.unipac.protocolmobile.ui.ui.login.LoginActivity
import br.com.unipac.protocolmobile.utils.SessionManager
import br.com.unipac.protocolo.model.Protocolo
import br.com.unipac.protocolo.model.Usuario

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManage: LinearLayoutManager
    private lateinit var listDeProtocolosAdapter: ListDeProtocolosAdapter
    private lateinit var db: AppDatabase
    private lateinit var sessionManager: SessionManager

    private var listaDeProtocolos: List<Protocolo> = ArrayList<Protocolo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(this)

        if (!sessionManager.isLoggedIn()) {
            logout()
        }

        db = AppDatabase.getInstance(this)!!

        var usuario = Usuario()
        usuario.fullName = "Rogerio"
        usuario.usename = "root@localhost.com"
        usuario.senha = "123456"
        db?.UsuarioRepositorio()?.insert(usuario)
        var usuarios = db?.UsuarioRepositorio()?.getAll()
        Log.i("Usuarios:", "${usuarios?.size}")

        var protocolo = Protocolo()
        protocolo.numeroProtocolo = 1234
        protocolo.email = "fon@dld.com"
        protocolo.primeiroNome = "Ze"
        protocolo.ultimoNome = "Silva"
        protocolo.idUsuario = 1L
        db?.ProtocoloRepositorio().insert(protocolo)
        var protocolos = db.ProtocoloRepositorio().getAll()
        Log.i("protocolos:", "${protocolos.size}")

        initView()
    }

    private fun logout() {
        sessionManager.setLogin(false)

        var intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
       /* Uri uri = Uri.parse("smsto:3499999999");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "The SMS text");
        startActivity(intent);*/
    }

    private fun initView() {
        var listDeProtocolosRv = findViewById<RecyclerView>(R.id.listDeProtocolosRv)

        listaDeProtocolos = listProtocolos()!!
        listDeProtocolosAdapter =
            ListDeProtocolosAdapter(listaDeProtocolos, this, this::deleteAdapter)
        linearLayoutManage = LinearLayoutManager(this)

        listDeProtocolosRv.layoutManager = linearLayoutManage
        listDeProtocolosRv.adapter = listDeProtocolosAdapter

    }

    fun getAll(): List<Protocolo>? {
        return db?.ProtocoloRepositorio()?.getAll()
    }

    private fun listProtocolos(): List<Protocolo>? {
        return db?.ProtocoloRepositorio()?.getAll()
    }

    private fun deleteAdapter(position: Int) {
        var listaDeProtocolos = listProtocolos()
        var protocolo = listaDeProtocolos?.get(position)
        if (protocolo != null) {
            db?.ProtocoloRepositorio()?.delete(protocolo)
            listDeProtocolosAdapter.notifyItemRemoved(position)
        }
    }
}