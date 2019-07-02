package com.everykan.lecturamedica.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LecturaServicesImpl implements LecturaServices {

    // 1
    private static final Map<Integer,Lectura> LECTURAS;

    private static final LecturaServicesImpl INSTANCE = new LecturaServicesImpl();

    // 2
    static {

        LECTURAS = new TreeMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // creamos 10 fechas de ejemplo
        Date fecha0 = null;
        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        Date fecha4 = null;
        Date fecha5 = null;
        Date fecha6 = null;
        Date fecha7 = null;
        Date fecha8 = null;
        Date fecha9 = null;

        try {

            fecha0 = sdf.parse("01/01/2019 01:20:10");
            fecha1 = sdf.parse("01/01/2019 12:23:30");
            fecha2 = sdf.parse("01/01/2019 14:15:43");
            fecha3 = sdf.parse("01/01/2019 09:30:00");
            fecha4 = sdf.parse("01/01/2019 13:20:20");
            fecha5 = sdf.parse("01/01/2019 16:28:25");
            fecha6 = sdf.parse("01/01/2019 09:35:00");
            fecha7 = sdf.parse("01/01/2019 11:10:18");
            fecha8 = sdf.parse("01/01/2019 15:40:50");
            fecha9 = sdf.parse("01/01/2019 17:35:54");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        // creamos las lecturas
        Lectura l0 = new Lectura(fecha0, 97.6, 91.2, 105.3,41.497376432529556,2.3838508129119877);
        Lectura l1 = new Lectura(fecha1, 65.6, 71.0, 110.3,41.438359139366504,2.166543602943421);
        Lectura l2 = new Lectura(fecha2, 78.0, 78.2, 120.0,41.497376432529556,2.3838508129119877);
        Lectura l3 = new Lectura(fecha3, 94.0, 90.2, 130.5,41.497376432529556,2.3838508129119877);
        Lectura l4 = new Lectura(fecha4, 66.0, 80.0, 150.0,41.497376432529556,2.3838508129119877);
        Lectura l5 = new Lectura(fecha5, 72.5, 91.5, 112.6,41.497376432529556,2.3838508129119877);
        Lectura l6 = new Lectura(fecha6, 56.8, 88.0, 121.4,41.497376432529556,2.3838508129119877);
        Lectura l7 = new Lectura(fecha7, 80.0, 70.4, 131.2,41.497376432529556,2.3838508129119877);
        Lectura l8 = new Lectura(fecha8, 55.6, 84.0, 150.8,41.497376432529556,2.3838508129119877);
        Lectura l9 = new Lectura(fecha9, 44.8, 92.1, 115.0,41.497376432529556,2.3838508129119877);

        // asignamos valores a los codigos
        l0.setCodigo(100);
        l1.setCodigo(101);
        l2.setCodigo(102);
        l3.setCodigo(103);
        l4.setCodigo(104);
        l5.setCodigo(105);
        l6.setCodigo(106);
        l7.setCodigo(107);
        l8.setCodigo(108);
        l9.setCodigo(109);

        // los colocamos en las variables codigo del map
        LECTURAS.put(l0.getCodigo(),l0);
        LECTURAS.put(l1.getCodigo(),l1);
        LECTURAS.put(l2.getCodigo(),l2);
        LECTURAS.put(l3.getCodigo(),l3);
        LECTURAS.put(l4.getCodigo(),l4);
        LECTURAS.put(l5.getCodigo(),l5);
        LECTURAS.put(l6.getCodigo(),l6);
        LECTURAS.put(l7.getCodigo(),l7);
        LECTURAS.put(l8.getCodigo(),l8);
        LECTURAS.put(l9.getCodigo(),l9);

    }
    // creamos un constructor privado
    private LecturaServicesImpl(){

    }

    public static LecturaServicesImpl getInstance(){

        return INSTANCE;

    }

    @Override
    public Lectura create(Lectura lectura) {
        // implemantar el create
        // nos llega una lectura nueva, necesitamos calcular el nuevo código
        Integer maxCode = ((TreeMap<Integer,Lectura> ) LECTURAS).lastKey();
        Integer newCode = maxCode++;
        lectura.setCodigo(newCode);
        return LECTURAS.put(lectura.getCodigo(),lectura);
    }

    @Override
    public Lectura read(Integer codigo) {

        return LECTURAS.get(codigo);

    }

    @Override
    public Lectura update(Lectura lectura) {
        // nos debe llegar una lectura de un codigo existente
        // caso contrario debemos lanzar un exception
        // containsKey =???
        boolean lecturaExiste = LECTURAS.containsKey(lectura.getCodigo());

        if(lectura.getCodigo() == null || !lecturaExiste) {
            throw new IllegalArgumentException("Sólo se pueden actualizar lecturas de códigos existentes");
        }
        return LECTURAS.put(lectura.getCodigo(), lectura);
    }

    @Override
    public boolean delete(Integer codigo) {
        Lectura lectura = LECTURAS.remove(codigo);
        return lectura == null ? false: true;
    }

    @Override
    public List<Lectura> getAll() {
        return new ArrayList<Lectura>(LECTURAS.values());
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2) {

        List<Lectura> lecturas = new ArrayList<>();

        for(Lectura lectura: getAll()){
            Date fechaHora = lectura.getFechaHora();
            if (fechaHora.after(fecha1) && fechaHora.before(fecha2)){
                lecturas.add(lectura);
            }
        }
        return lecturas;
    }

}
