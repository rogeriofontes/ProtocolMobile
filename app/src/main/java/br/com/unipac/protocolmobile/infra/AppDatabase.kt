package br.com.unipac.protocolmobile.infra

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.unipac.protocolmobile.converters.Converters
import br.com.unipac.protocolmobile.dao.ProtocoloRepositorio
import br.com.unipac.protocolmobile.dao.UsuarioRepositorio
import br.com.unipac.protocolo.model.Protocolo
import br.com.unipac.protocolo.model.Usuario

@Database(entities = [Protocolo::class, Usuario::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ProtocoloRepositorio(): ProtocoloRepositorio
    abstract fun UsuarioRepositorio(): UsuarioRepositorio

    companion object {
        private var instance: AppDatabase? = null
        private val databaseName = "protoco.db"

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, databaseName
                    ).allowMainThreadQueries().build();
                }
            }
            return instance;
        }

        fun destroyInstance() {
            instance = null
        }
    }
}