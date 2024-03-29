package com.everykan.lecturamedica.model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.everykan.lecturamedica.database.DatabaseHelper;

import java.util.Date;
import java.util.List;

public class LecturaServicesSQLite implements LecturaServices {

    private Context contexto;
    private DatabaseHelper myDB;

    public LecturaServicesSQLite(Context context){
        this.contexto = context;
        myDB = new DatabaseHelper(contexto);
    }

    @Override
    public Lectura create(Lectura lectura) {
        return myDB.createLectura(lectura);
    }

    @Override
    public Lectura read(Integer codigo) {
        //TODO
        return null;
    }

    @Override
    public Lectura update(Lectura lectura) {
        //TODO
        return null;
    }

    @Override
    public boolean delete(Integer codigo) {
        //TODO
        return false;
    }

    @Override
    public List<Lectura> getAll() {

        return myDB.getAll();
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2) {
        //TODO
        return null;
    }
}
