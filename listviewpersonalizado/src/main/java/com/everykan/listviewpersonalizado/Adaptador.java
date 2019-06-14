package com.everykan.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    // dentro del getView necesitamos un 'aparato' para generar el objeto
    // 'inflable'

    private LayoutInflater inflater = null;

    private Context contexto;
    private String[][] datos;
    private int[] datosImg;

    public Adaptador (Context contexto, String[][] datos, int[] imagenes) {

        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;
        //
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

    }


    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView titulo = (TextView) vista.findViewById(R.id.idTitulo);
        TextView duracion = (TextView) vista.findViewById(R.id.idDuracion);
        TextView director = (TextView) vista.findViewById(R.id.idDirector);

        ImageView imagen = (ImageView) vista.findViewById(R.id.idImagen);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.idRatingBarPel);

        // ahora colocamos los datos en estas vistas (views)...

        titulo.setText(datos[i][0]);
        director.setText(datos[i][1]);
        duracion.setText("Duración : " + datos[i][2]); // ojo "hard coded"
        imagen.setImageResource(datosImg[i]);
        calificacion.setProgress(Integer.valueOf(datos[i][3]));

        // cuando hagamos clic en la el item y veamos la ficha

        imagen.setTag(i);

        return vista;

    }

}

