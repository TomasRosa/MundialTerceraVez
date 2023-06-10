public class YaHayEntrenadorExcepcion extends RuntimeException
{
    public YaHayEntrenadorExcepcion()
    {
        super("No puede haber mas de un entrenador en el equipo.");
    }
}
