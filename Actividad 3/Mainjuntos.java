import java.util.Scanner;
class Producto {
    private String codigo;
    private String tipo;
    private double costo;
    private double impuesto;
    public Producto() {}
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public double getCosto() { return costo; }
    public double getImpuesto() { return impuesto; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCosto(double costo) { this.costo = costo; }
    public void setImpuesto(double impuesto) { this.impuesto = impuesto; }
    public void muestraProducto() {
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: $" + costo);
        System.out.println("Impuesto: " + impuesto + "%");
    }
    public double calcularPrecio(double utilidad) {
        double precioAntesImpuesto = costo + (costo * utilidad / 100);
        return precioAntesImpuesto + (precioAntesImpuesto * impuesto / 100);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        System.out.println("Ingrese los datos del primer producto:");
        ingresarDatos(producto1, scanner);
        System.out.println("\nIngrese los datos del segundo producto:");
        ingresarDatos(producto2, scanner);
        System.out.println("\nDatos del primer producto:");
        producto1.muestraProducto();
        System.out.println("\nDatos del segundo producto:");
        producto2.muestraProducto();
        System.out.println("\nComparación de productos:");
        System.out.println(compararProductos(producto1, producto2));
        scanner.close();
    }
    public static void ingresarDatos(Producto producto, Scanner scanner) {
        System.out.print("Código: ");
        producto.setCodigo(scanner.nextLine());
        System.out.print("Tipo: ");
        producto.setTipo(scanner.nextLine());
        while (true) {
            try {
                System.out.print("Costo: ");
                producto.setCosto(Double.parseDouble(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor numérico válido para el costo.");
            }
        }
        while (true) {
            try {
                System.out.print("Impuesto (%): ");
                producto.setImpuesto(Double.parseDouble(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor numérico válido para el impuesto.");
            }
        }
    }
    public static String compararProductos(Producto p1, Producto p2) {
        double precio1 = p1.calcularPrecio(20);
        double precio2 = p2.calcularPrecio(20);
        if (precio1 > precio2) {
            return "El producto con mayor precio es:\n" + p1.getCodigo() + " - " + p1.getTipo() + " con un precio de $" + precio1;
        } else if (precio2 > precio1) {
            return "El producto con mayor precio es:\n" + p2.getCodigo() + " - " + p2.getTipo() + " con un precio de $" + precio2;
        } else {
            return "Ambos productos tienen el mismo precio de venta.";
        }
    }
}