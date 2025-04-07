public class Main {
    public static void main(String[] args) {
        Equipaje[] Equipajes = new Equipaje[5];
        Equipajes[0] = new Bodega(100.0, 10.0);
        Equipajes [1] = new Bodega(200.0, 5.0);
        Equipajes [2]= new Cabina(150.0, 20.0);
        Equipajes [3] = new Cabina(80.0, 15.0);
        Equipajes [4] = new Bodega(120.0, 8.0);

        PrecioTotal solucion = new PrecioTotal(Equipajes);
        solucion.mostrarTotales();
    }
}
