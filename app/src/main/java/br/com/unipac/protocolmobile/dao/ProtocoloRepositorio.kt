package br.com.unipac.protocolmobile.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.unipac.protocolo.model.Protocolo

@Dao
interface ProtocoloRepositorio {

    @Query("SELECT * FROM protocolo")
    fun getAll(): List<Protocolo>

    @Query("SELECT * FROM protocolo WHERE id IN (:protocoloIds)")
    fun loadAllByIds(protocoloIds: IntArray): List<Protocolo>

    /*@Query(
        "SELECT * FROM user WHERE primeiro_nome LIKE :first AND " +
                "ultimo_nome LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): Protocolo*/

    @Insert
    fun insert(protocolo: Protocolo)

    @Insert
    fun insertAll(vararg protocolos: Protocolo)

    @Delete
    fun delete(protocolo: Protocolo)
}