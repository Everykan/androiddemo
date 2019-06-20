package com.everykan.listbanderas;

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

    public Adaptador(Context contexto, String[][] datos, int[] imagenes) {

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

        final View vista = inflater.inflate(R.layout.elemento_fila, null);

        TextView nombre = (TextView) vista.findViewById(R.id.idnonpais);
        TextView continente = (TextView) vista.findViewById(R.id.idcontinente);
        ImageView imagen = (ImageView) vista.findViewById(R.id.idbandera);

        // ahora colocamos los datos en estas vistas (views)...

        nombre.setText(datos[i][0]);
        continente.setText(datos[i][1]);
        imagen.setImageResource(datosImg[i]);

        // cuando hagamos clic en la el item y veamos la ficha

        imagen.setTag(i);

        return vista;

    }

}

