package com.everykan.lecturamedica.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.everykan.lecturamedica.model.Lectura;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // que acabe en .db lo dejamos a gusto del consumidor
    private static final String DATABASE_NAME = "MEDICDATA";

    private static final String LECTURAS_TABLE = "LECTURAS";

    private static final String COL_0 = "CODIGO";
    private static final String COL_1 = "FECHA_HORA";
    private static final String COL_2 = "PESO";
    private static final String COL_3 = "DIASTOLICA";
    private static final String COL_4 = "SISTOLICA";
    private static final String COL_5 = "LONGITUD";
    private static final String COL_6 = "LATITUD";

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Aquí hay DDL y también DML (si queremos que hayan datos en las tablas)

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + LECTURAS_TABLE + " (")
          .append(COL_0).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
          .append(COL_1).append(" TEXT NOT NULL, ")
          .append(COL_2).append(" REAL NOT NULL, ")
          .append(COL_3).append(" REAl NOT NULL, ")
          .append(COL_4).append(" REAL NOT NULL, ")
          .append(COL_5).append(" REAL, ")
          .append(COL_6).append(" REAL)");

        String strDDL = sb.toString();

        db.execSQL(strDDL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Este onUpgrade será diferente para cada situación.

        // Por ejemplo, en el paso de 1 -> 2 se requiere una columna nueva
        // Por ejemplo, en el paso de 2 -> 3 se requiere una tabla nueva, con datos...

        db.execSQL("DROP TABLE IF EXISTS " + LECTURAS_TABLE);
        onCreate(db);

        //
    }

    // Métodos para se consumidos por otras clases.

    public Lectura createLectura(double peso,
                              double diastoloca,
                              double sistoloca,
                              Date fechaHora,
                              double longitud,
                              double latitud){
        // TODO
        return null;
    }

    public Lectura createLectura(Lectura lectura){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, getStringFromDate(lectura.getFechaHora()));
        contentValues.put(COL_2, lectura.getPeso());
        contentValues.put(COL_3, lectura.getDiastolica());
        contentValues.put(COL_4, lectura.getSistolica());
        contentValues.put(COL_5, lectura.getLongitud());
        contentValues.put(COL_6, lectura.getLatitud());

        // nullColumnHack se utiliza cuando pretendemos insertar un registro
        // con valores null. En ese caso, contentValues estará vacío (sin PUT)
        long resultado = db.insert(LECTURAS_TABLE,null,contentValues);

        // insert nos devuelve un long.... La ID del registro que acaba de generar
        // o -1 si algo ha ido mal...

        // A la lectura que me llegaba sin código, le asigno su código y la devuelvo.
        lectura.setCodigo((int) resultado);

        // si la cosa ha ido mal, devuelvo una lectura null
        return resultado == -1 ? null: lectura;
    }

    public Lectura getLectura(int codigo){

        SQLiteDatabase db = getWritableDatabase();

        String[] args = new String[] {String.valueOf(codigo)};

        Cursor cursor = db.rawQuery("SELECT * FROM " + LECTURAS_TABLE + " WHERE CODIGO = ?", args);

        Lectura lectura = null;

        if (cursor != null && cursor.getCount() > 0){   // Sabemos que hay 1 registro!
            cursor.moveToNext();                        // Situamos el puntero en ese registro
            int code = cursor.getInt(0);
            Date fecha = getDateFromString(cursor.getString(1));
            double peso = cursor.getDouble(2);
            double diastolica = cursor.getDouble(3);
            double sistolica = cursor.getDouble(4);
            double longitud = cursor.getDouble(5);
            double latitud = cursor.getDouble(6);

            lectura = new Lectura(fecha,peso,diastolica,sistolica,longitud,latitud);
            lectura.setCodigo(code);

        }

        return lectura;
    }

    public Cursor getAll2(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LECTURAS_TABLE + " ORDER BY " + COL_1 + " DESC", null);
        return cursor;
    }


    public List<Lectura> getAll(){

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + LECTURAS_TABLE + " ORDER BY " + COL_1 + " DESC", null);

        String[] columnas = new String[]{COL_0,COL_1,COL_2,COL_3,COL_4,COL_5,COL_6};

        List<Lectura> lecturas = new ArrayList<Lectura>();

        if (cursor != null && cursor.getCount() > 0){

            while (cursor.moveToNext()){

                Integer codigo = cursor.getInt(0);
                String strFecha = cursor.getString(1); // La fecha vive como String "dd/MM/yyyy HH:mm"
                Date fecha = getDateFromString(strFecha);
                double peso = cursor.getDouble(2);
                double diastolica = cursor.getDouble(3);
                double sistolica = cursor.getDouble(4);
                double longitud = cursor.getDouble(5);
                double latitud = cursor.getDouble(6);

                Lectura lectura = new Lectura(fecha,peso,diastolica,sistolica,longitud,latitud);
                lectura.setCodigo(codigo);
                lecturas.add(lectura);

            }
        }

        return lecturas;
    }


    //**************************************************
    //  Métodos Privados
    //**************************************************

    private String getStringFromDate(Date date){
        return SDF.format(date);
    }

    private Date getDateFromString(String strFecha){

        Date date = null;
        try {
            date = SDF.parse(strFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public List<Lectura> getBetweenDates(Date desde, Date hasta){

        List<Lectura> lecturas = getAll();

        List<Lectura> lecturasFiltradas = new ArrayList<Lectura>();

        for (Lectura lectura: lecturas){
            if (lectura.getFechaHora().after(desde) && lectura.getFechaHora().before(hasta)){
                // pal saco
                lecturasFiltradas.add(lectura);
            }
        }

        return lecturas;

    }



    public void transferencia(){

        // BEGINTRANSACTION

        // Leemos saldo

        // Si saldo cubre importe a transferir...


                // Descontamos importe a cuenta Origen

                int a = 10/0;

                // Incrementamos importe a cuenta Destino

        // ENDTRANSACTION

    }






}
