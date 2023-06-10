import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args)
    {
        Federacion federacionArgentina = new Federacion<>("AFA","20/02/1983",3);

        Futbolista f1 = new Futbolista("Romario","Romarinho",29,9,"Delantero");
        Futbolista f2 = new Futbolista("Roman","Riquelme",27,10,"Mediocampista");
        Entrenador e1 = new Entrenador("Ricardo","Zielinski",39,433,"Ofensivo");
        AyudanteDeCampo a1 = new AyudanteDeCampo("Capo","Martinez",18,"Bielsista");
        Masajista m1 = new Masajista("Tambor","Delana",22,"Bueno",5);
        Masajista m2 = new Masajista("Tambora","Decuero",22,"Bueno",5);

        ///Implemento una lista secundaria para poder captar las excepciones mientras voy pasando a la lista generica de integrantes
        ArrayList<Integrante> listaAux = new ArrayList<>();
        listaAux.add(f1);
        listaAux.add(f2);
        listaAux.add(e1);
        listaAux.add(a1);
        listaAux.add(m1);

        ///Recorro la lista secundaria y agrego a la lista de la federacion para asi si hay una excepcion capturarla y que el programa siga corriendo.
        for(Integrante elemento: listaAux)
        {
            try
            {
                federacionArgentina.agregar(elemento);
            }
            catch (MaxJugadoresException e)
            {
                System.out.println(e.getMessage());
            }
            catch (YaHayEntrenadorExcepcion e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Integrantes de la federacion antes de borrar: ");
        federacionArgentina.mostrar();

        try
        {
            federacionArgentina.quitar(m2);
        }
        catch(NoExisteElMiembroAEliminarException e)
        {
            System.out.printf(e.getMessage());
        }
        System.out.println("Integrantes de la federacion luego de borrar: ");
        federacionArgentina.mostrar();
        System.out.println("Exportando a JSON....");
        System.out.println("Integrantes de la federacion ordenados por edad: ");
        Collections.sort(federacionArgentina.getIntegrantes());
        federacionArgentina.mostrar();
        try
        {
            federacionArgentina.exportarAJson("mi_archivo.json",federacionArgentina);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Mostrando en JSON...");
        try
        {
            federacionArgentina.mostrarEnJson("mi_archivo.json");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}