package com.everykan.lecturamedica.model;

import java.util.Date;
import java.util.List;

public interface LecturaServices {

    public Lectura create(Lectura lectura);
    public Lectura read(Integer codigo);
    public Lectura update(Lectura lectura);
    public boolean delete(Integer codigo);

    // la lista de objetos de clase Lectura
    public List<Lectura> getAll();
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2);

}
