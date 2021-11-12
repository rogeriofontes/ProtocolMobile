package br.com.unipac.protocolo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "usuario")
class Usuario(
    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
    @ColumnInfo(name = "full_name")
    var fullName: String = "",
    var usename: String = "",
    var senha: String = "",
) : BaseEntity()