public class PrecioTotal {
    private double totalPrecios;
    private double totalBodega;
    private double totalCabina;
    private Equipaje[] equipajes;

    public PrecioTotal(Equipaje[] equipajes) {
        this.equipajes = equipajes;
        calcularTotales();
    }

    public void calcularTotales() {
        for (Equipaje equipaje : equipajes) {
            double precio = equipaje.calcularPrecio();
            totalPrecios += precio;
            if (equipaje instanceof Bodega) {
                totalBodega += precio;
            } else if (equipaje instanceof Cabina) {
                totalCabina += precio;
            }
        }
    }

    public void mostrarTotales() {
        System.out.println("Total Equipaje: " + totalPrecios);
        System.out.println("Total Bodega: " + totalBodega);
        System.out.println("Total Cabina: " + totalCabina);
    }
}
