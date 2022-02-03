package dev.rennangalvao.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);

    }

    //Criar o banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS
                        + " (id INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                        " nome TEXT NOT NULL ); ";

        try {
            db.execSQL( sql );
            Log.i("INFO DB", "Sucesso ao criar a a tabela ");

        }catch (Exception e){
            Log.i("INFO DB", "ERRO ao criar a tabela " + e.getMessage());
        }
    }
    // Atualizar the table caso precise "add novas tabelas"
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int nerVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ; " ;

        try {
            db.execSQL( sql );
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App");

        }catch (Exception e){
            Log.i("INFO DB", "ERRO ao atualizar App " + e.getMessage());
        }
    }
}
