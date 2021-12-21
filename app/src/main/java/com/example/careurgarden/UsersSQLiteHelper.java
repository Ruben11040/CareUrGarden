package com.example.careurgarden;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class UsersSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Users (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " name TEXT," +
            " surname TEXT," +
            " birthday DATE," +
            " email TEXT," +
            " password TEXT," +
            " garden ARRAYLIST)";

    private static final String DB_NAME = "Users.db";
    private static final int DB_VERSION = 1;

    public UsersSQLiteHelper(Context contexto, String name,
                             SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción
        //de eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Users");

        //Se crea la nueva versión de la tabla
        onCreate(db);

    }
}
