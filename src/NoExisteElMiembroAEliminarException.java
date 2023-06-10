public class NoExisteElMiembroAEliminarException extends RuntimeException
{
    public NoExisteElMiembroAEliminarException()
    {
        super("No existe el miembro a eliminar.");
    }
}
