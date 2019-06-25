package com.everykan.sqlitehelloword;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import static android.content.ContentValues.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    //public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    //    super(context, name, factory, version);
    //}

    // Nombre de la DB
    public static final String DATABASE_NAME = "amigos.db";

    // Nombre de la Tabla
    public static final String AMIGOS_TABLE = "AMIGOS";

    // Columnas de la Tabla
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOMBRE";
    public static final String COL_3 = "APELLIDO1";
    public static final String COL_4 = "APELLIDO2";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // entramos acá cuando la DB se crea por primera vez
        // se ejecutará una sentencia de DDL (Data Definition Lenguaje)

         /* CREATE TABLE AMIGOS (
                ID      INTEGER PRIMARY KEY AUTOINCREMENT,
                NOMBRE      TEXT NOT NULL,
                APELLIDO1   TEXT NOT NULL,
                APELLIDO2   TEXT
           )
        */
        StringBuilder strSQL = new StringBuilder();

        // creamos la tabla AMIGOS
        strSQL.append("CREATE TABLE ")
              .append(AMIGOS_TABLE).append(" ").append(" (")
              .append(COL_1).append(" INTEGER PRIMARY KEY AUTOINCREMENT,")
              .append(COL_2).append(" TEXT NOT NULL,")
              .append(COL_3).append(" TEXT NOT NULL,")
              .append(COL_4).append(" TEXT)");
        // mostramos por el debug si hemos creado la tabla, esto lo hace sólo la primera vez
        Log.d("CREAR TABLA",strSQL.toString());

        db.execSQL(strSQL.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // este método se utiliza cuando se detectan cambios de versión de la db
        // normalmente la creación de nuevas tablas o columnas en las tablas existentes
        db.execSQL("DROP TABLE IF EXISTS " + AMIGOS_TABLE);
        onCreate(db);

    }

    // Métodos para realizar operaciones CRUD, obtención de listas, etc....

    public boolean insertData(String nombre, String apellido1, String apellido2) {

        // Necesitamos una referencia para abrir la DB o ubicarla

        SQLiteDatabase db = this.getWritableDatabase(); // Nos permite escribir en la DB

        // nombreBaseDatos = this.DATABASE_NAME;
        // nombreBaseDatos = DatabaseHelper.DATABASE_NAME;

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, apellido1);
        contentValues.put(COL_4, apellido2);

        // insertar datos en el row de la tabla
        long resultado = db.insert(AMIGOS_TABLE, null, contentValues);

        // evaluamos resultado;
        // si es -1 hay un error
        // se es >= 0 nos indica en número de registros afectados
        // mostramos el número de registro
        Log.d("***","Insertado correctamente: " + resultado);

        return resultado == -1 ? false: true;

    }

    // un cursor nos devuelve una tabla
    public Cursor getAll() {

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AMIGOS_TABLE, null);

        // Un selectuinArgs() es un arreglo(array) de string "String[]"
        // En una consulta pueden haber datos que serán sustituidos por los valores
        // de este array

        // Ejemplo:
        // SELECT * FROM AMIGOS WHERE nombre=? AND apellido1 LIKE ?%
        // String[] = {"Adolfo", "D"}

        return cursor;

    }

}
