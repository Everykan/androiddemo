package com.everykan.lecturamedica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.everykan.lecturamedica.model.Lectura;
import com.everykan.lecturamedica.model.LecturaServices;
import com.everykan.lecturamedica.model.LecturaServicesImpl;

import java.text.SimpleDateFormat;
import java.util.List;

public class Adaptador extends BaseAdapter {

    private LayoutInflater inflater = null;
    private List<Lectura> lecturas; // es null pero el método constructor de Adaptador se encarga de asignarle los datos
    private Context contexto;

    private SimpleDateFormat sdf1;
    private SimpleDateFormat sdf2;

    public Adaptador (Context contexto){

        this.contexto = contexto;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

     //              INTERFACE                  IMPLEMENTACION
        LecturaServices lecturaServices = LecturaServicesImpl.getInstance(); //lecturaServices es lo que llamo "aparato de hacer cosas"

    //  LecturaServices lecturaServices = new LecturaServicesSQLite(contexto);

        lecturas = lecturaServices.getAll(); // obtenemos la lista de lecturas List<Lectura>

        // variables de apoyo para dividir la fecha y hora

        sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        sdf2 = new SimpleDateFormat("HH:mm");

    }

    // generar las filas que van en el ListView

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.lectura_row, null);

        // Recogemos todas las vistas del layout

        TextView diastolica = (TextView) vista.findViewById(R.id.idDiastolica);
        TextView sistolica = (TextView) vista.findViewById(R.id.idSistolica);
        TextView peso = (TextView) vista.findViewById(R.id.idPeso);
        TextView fecha = (TextView) vista.findViewById(R.id.idFecha);
        TextView hora = (TextView) vista.findViewById(R.id.idHora);

        Lectura lectura = lecturas.get(position);

        // m1 convierto string con la parte extraida de sdf1 y sdf2

        String strFecha = sdf1.format(lectura.getFechaHora());
        String strHora =  sdf2.format(lectura.getFechaHora());

        diastolica.setText(String.valueOf(lectura.getDiastolica()));
        sistolica.setText(String.valueOf(lectura.getSistolica()));
        peso.setText(String.valueOf(lectura.getPeso()));
        fecha.setText(strFecha);
        hora.setText(strHora);

        return vista;

        // Otra forma de hacerlo sin utilizar el lectura_row.xml
        // ques es creando el layout y las diferentes views de forma programática
        // en Java, lo cual ES UNA LOCURA! aunque se puede conseguir EXACTAMENTE lo mismo

       /*
        LinearLayout linearLayout = new LinearLayout(contexto);

        TextView tv1 = new TextView(contexto);
        TextView tv2 = new TextView(contexto);

        tv1.setText(String.valueOf(lectura.getDistolica()));
        tv2.setText(String.valueOf(lectura.getSistolica()));

        linearLayout.addView(tv1);
        linearLayout.addView(tv2);

        return linearLayout;

        */

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