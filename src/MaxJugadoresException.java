public class MaxJugadoresException extends RuntimeException
{
    public MaxJugadoresException()
    {
        super("No pueden agregarse mas de 23 futbolistas al equipo.");
    }
}
