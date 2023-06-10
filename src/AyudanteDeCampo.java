public class AyudanteDeCampo extends Integrante implements Jugar,Preparar
{
    private String metodologia;

    public AyudanteDeCampo(String nombre, String apellido, int edad, String metodologia) {
        super(nombre, apellido, edad);
        this.metodologia = metodologia;
    }

    public AyudanteDeCampo() {

    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    @Override
    public String toString() {
        return super.toString() +
                "metodologia='" + metodologia + '\'' +
                '}';
    }

    @Override
    public void viajar()
    {
        System.out.println("Ayudante de campo viajando...");
    }

    @Override
    public void concentrar()
    {
        System.out.println("Ayudante de campo concentrando...");
    }

    @Override
    public void jugar()
    {
        System.out.println("Ayudante de campo en el partido...");
    }

    @Override
    public void prepararEntrenamiento()
    {
        System.out.println("Ayudante de campo preparando entrenamiento...");
    }

    @Override
    public int compareTo(Integrante o) {
        return this.getEdad() - o.getEdad();
    }
}
