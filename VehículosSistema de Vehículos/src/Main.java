abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int año;
    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }
    public abstract void arrancar();
    public abstract void detener();
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }
}
class Automovil extends Vehiculo {
    private String tipoCombustible;
    public Automovil(String marca, String modelo, int año, String tipoCombustible) {
        super(marca, modelo, año);
        this.tipoCombustible = tipoCombustible;
    }
    @Override
    public void arrancar() {
        System.out.println("El automóvil está arrancando.");
    }
    @Override
    public void detener() {
        System.out.println("El automóvil se ha detenido.");
    }
    public void abrirPuertas() {
        System.out.println("Las puertas del automóvil se han abierto.");
    }
}
class Motocicleta extends Vehiculo {
    private int cilindraje;
    public Motocicleta(String marca, String modelo, int año, int cilindraje) {
        super(marca, modelo, año);
        this.cilindraje = cilindraje;
    }
    @Override
    public void arrancar() {
        System.out.println("La motocicleta está arrancando.");
    }
    @Override
    public void detener() {
        System.out.println("La motocicleta se ha detenido.");
    }
    public void hacerCaballito() {
        System.out.println("La motocicleta está haciendo un caballito.");
    }
}
class Camion extends Vehiculo {
    private double capacidadCarga;
    public Camion(String marca, String modelo, int año, double capacidadCarga) {
        super(marca, modelo, año);
        this.capacidadCarga = capacidadCarga;
    }
    @Override
    public void arrancar() {
        System.out.println("El camión está arrancando.");
    }
    @Override
    public void detener() {
        System.out.println("El camión se ha detenido.");
    }
    public void cargarMercancia() {
        System.out.println("El camión está cargando mercancía.");
    }
}
public class Main {
    public static void main(String[] args) {
        Automovil auto = new Automovil("Toyota", "Corolla", 2022, "Gasolina");
        Motocicleta moto = new Motocicleta("Yamaha", "R1", 2021, 1000);
        Camion camion = new Camion("Volvo", "FH16", 2020, 25.5);
        auto.mostrarInfo();
        auto.arrancar();
        auto.abrirPuertas();
        auto.detener();
        moto.mostrarInfo();
        moto.arrancar();
        moto.hacerCaballito();
        moto.detener();
        camion.mostrarInfo();
        camion.arrancar();
        camion.cargarMercancia();
        camion.detener();
    }
}