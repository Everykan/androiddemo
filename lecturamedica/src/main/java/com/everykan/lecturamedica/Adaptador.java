package com.everykan.lecturamedica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.everykan.lecturamedica.model.Lectura;
import com.everykan.lecturamedica.model.LecturaServicesImpl;

import java.text.SimpleDateFormat;
import java.util.List;

public class Adaptador extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Lectura> lecturas;
    private Context contexto;

    private SimpleDateFormat sdf1;
    private SimpleDateFormat sdf2;

    public Adaptador (Context contexto){
        this.contexto = contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        lecturas = LecturaServicesImpl.getInstance().getAll();

        // variables de apoyo para dividir la fecha y hora

        sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        sdf2 = new SimpleDateFormat("HH:mm");

    }

    // generar las filas que van en el ListView

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.lectura_row, null);

        // método 1: recogemos todas las vistas del layout

        /* TextView distolica = (TextView) vista.findViewById(R.id.idDistolica);
        TextView sistolica = (TextView) vista.findViewById(R.id.idSistolica);
        TextView peso = (TextView) vista.findViewById(R.id.idPeso);
        TextView fecha = (TextView) vista.findViewById(R.id.idFecha);
        TextView hora = (TextView) vista.findViewById(R.id.idHora); */

        Lectura lectura = lecturas.get(position);

        // m1 convierto string con la parte extraida de sdf1 y sdf2

        /* String strFecha = sdf1.format(lectura.getFechaHora());
        String strHora =  sdf2.format(lectura.getFechaHora());

        distolica.setText(String.valueOf(lectura.getDistolica()));
        sistolica.setText((String.valueOf(lectura.getSistolica())));
        peso.setText(String.valueOf(lectura.getPeso()));
        fecha.setText(strFecha);
        hora.setText(strHora); */

        // método 2: Otra forma de hacerlo.....

        LinearLayout linearLayout = new LinearLayout(contexto);

        TextView tv1 = new TextView(contexto);
        TextView tv2 = new TextView(contexto);

        tv1.setText(String.valueOf(lectura.getDistolica()));
        tv2.setText(String.valueOf(lectura.getSistolica()));

        linearLayout.addView(tv1);
        linearLayout.addView(tv2);

        return linearLayout;

        // m1 return vista;
    }

    @Override
    public int getCount() {
        return lecturas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}