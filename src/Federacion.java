import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Federacion <T>
{
    public static final int MAX_FUTBOLISTAS = 23;

    private String nombre;
    private String fecha;
    private int cantMundiales;
    private boolean hayEntrenador = false;
    private int cantJugadores = 0;

    ArrayList<T> integrantes;

    public Federacion(String nombre, String fecha, int cantMundiales)
    {
        this.nombre = nombre;
        this.fecha = fecha;
        this.cantMundiales = cantMundiales;
        this.integrantes = new ArrayList<>();
    }
    public Federacion ()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantMundiales() {
        return cantMundiales;
    }

    public void setCantMundiales(int cantMundiales) {
        this.cantMundiales = cantMundiales;
    }

    public boolean isHayEntrenador() {
        return hayEntrenador;
    }

    public void setHayEntrenador(boolean hayEntrenador) {
        this.hayEntrenador = hayEntrenador;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public ArrayList<T> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<T> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return "Federacion{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cantMundiales=" + cantMundiales +
                ", integrantes=" + integrantes +
                '}';
    }
    public void agregar (T t) throws MaxJugadoresException,YaHayEntrenadorExcepcion
    {
       if(t instanceof Futbolista && this.cantJugadores == MAX_FUTBOLISTAS)
       {
           throw new MaxJugadoresException();
       }
       else if (t instanceof Futbolista && this.cantJugadores < MAX_FUTBOLISTAS)
       {
           this.integrantes.add(t);
           this.cantJugadores++;
       }
       if(t instanceof Entrenador && this.hayEntrenador == true)
       {
           throw new YaHayEntrenadorExcepcion();
       }
       else if(t instanceof Entrenador && this.hayEntrenador == false)
       {
           this.integrantes.add(t);
           this.hayEntrenador = true;
       }
       if(t instanceof AyudanteDeCampo || t instanceof Masajista)
       {
           this.integrantes.add(t);
       }
    }
    public void quitar (T t) throws NoExisteElMiembroAEliminarException
    {
        if(this.integrantes.contains(t))
        {
            this.integrantes.remove(t);
        }
        else
        {
            throw new NoExisteElMiembroAEliminarException();
        }
    }
    public void mostrar ()
    {
        for(T elemento: this.integrantes)
        {
            System.out.println(elemento);
        }
    }
    public void exportarAJson (String name, Federacion fed) throws IOException
    {
        File file = new File(name);
        ObjectMapper objectMapper = new ObjectMapper();

        if(!file.exists()) throw new IOException();

        try
        {
            objectMapper.writeValue(file,fed);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void mostrarEnJson (String name) throws IOException
    {
        File file = new File(name);
        ObjectMapper objectMapper = new ObjectMapper();

        if(!file.exists()) throw new IOException();

        try
        {
            Federacion fed = objectMapper.readValue(file,Federacion.class);
            System.out.println(fed);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
