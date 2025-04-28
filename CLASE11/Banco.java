package CLASE11;
public class Banco {
    private int id;
    private String nombre;
    private Cuenta cuenta;

    public Banco(int id, String nombre, Cuenta cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }


    public void mostrarCliente(Cliente cliente){
        System.out.println(cliente);
    }

    public String toString(){
        return "Banco {id:" + id + ", nombre:" + nombre + ", Cuenta[" + cuenta + "]}";
   
     }
     }


    