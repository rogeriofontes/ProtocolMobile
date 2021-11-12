package br.com.unipac.protocolo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "protocolo")
class Protocolo(
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0,
    @ColumnInfo(name = "primeiro_nome")
    var primeiroNome: String = "",
    @ColumnInfo(name = "ultimo_nome")
    var ultimoNome: String = "",
    var email: String = "",
    @ColumnInfo(name = "numero_protocolo")
    var numeroProtocolo: Int = 0,
    //Many To One - Trocar usuario por Aluno
    /*@ForeignKey(
        entity = Usuario::class,
                parentColumns = ["id"],
                childColumns = ["id_usuario"],
                onDelete = CASCADE
    )*/
    var idUsuario: Long = 0
) : BaseEntity()