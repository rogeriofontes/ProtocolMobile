package br.com.unipac.protocolmobile.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.unipac.protocolo.model.Protocolo
import br.com.unipac.protocolo.model.Usuario

@Dao
interface UsuarioRepositorio {

    @Query("SELECT * FROM usuario")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM usuario WHERE id IN (:usuarioIds)")
    fun loadAllByIds(usuarioIds: IntArray): List<Usuario>

    @Insert
    fun insert(usuario: Usuario)

    @Insert
    fun insertAll(vararg usuarios: Usuario)

    @Delete
    fun delete(usuario: Usuario)
}