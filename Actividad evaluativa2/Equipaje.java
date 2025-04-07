public class Equipaje {
    private double peso;
    private double tamanio;
    private double precioBase;

    // Constructor
    public Equipaje(double peso, double tamanio) {
        this.peso = peso;
        this.tamanio = tamanio;
        this.precioBase = 1000.0; // Precio base por defecto
    }

    public double calcularPrecio() {
        return precioBase; 
    }
}