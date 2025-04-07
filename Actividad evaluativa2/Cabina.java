public class Cabina extends Equipaje {
    private static final int TIEMPO = 2;

    public Cabina(double peso, double tamanio) {
        super(peso, tamanio);
    }

   
    public double calcularPrecio() {
        return super.calcularPrecio() + (peso * tamanio * TIEMPO);
    }
}
