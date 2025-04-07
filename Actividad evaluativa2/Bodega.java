public class Bodega extends Equipaje {
    private static final double CAPACIDAD = 8.0;

    public Bodega(double peso, double tamanio) {
        super(peso, tamanio);
    }

    
    public double calcularPrecio() {
        return super.calcularPrecio() + (peso * tamanio * CAPACIDAD);
    }
}
