public class Cabina extends Equipaje {
    private static final int TIEMPO = 2;

    public Cabina(double peso, double tamanio) {
        super(peso, tamanio);
    }

    public Cabina(double precioBase) {
        super(precioBase);
    }

    public Cabina() {
        super();
    }

    public double calcularPrecio() {
        return super.calcularPrecio() + (getPeso() * getTamanio() * TIEMPO);
    }
}