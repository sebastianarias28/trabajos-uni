public class Equipaje {
    private static final double PESO_POR_DEFECTO = 10.0;
    private static final double TAMANIO_POR_DEFECTO = 4.5;
    private static final double PRECIO_BASE_POR_DEFECTO = 1000.0;

    private double peso;
    private double tamanio;
    private double precioBase;

    // Constructor con peso y tamanio
    public Equipaje(double peso, double tamanio) {
        this.peso = peso;
        this.tamanio = tamanio;
        this.precioBase = PRECIO_BASE_POR_DEFECTO;
    }

    // Constructor con precioBase
    public Equipaje(double precioBase) {
        this.peso = PESO_POR_DEFECTO;
        this.tamanio = TAMANIO_POR_DEFECTO;
        this.precioBase = precioBase;
    }

    // Constructor sin parámetros
    public Equipaje() {
        this.peso = PESO_POR_DEFECTO;
        this.tamanio = TAMANIO_POR_DEFECTO;
        this.precioBase = PRECIO_BASE_POR_DEFECTO;
    }

    public double calcularPrecio() {
        return precioBase;
    }

    // Getters
    public double getPeso() {
        return peso;
    }

    public double getTamanio() {
        return tamanio;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}