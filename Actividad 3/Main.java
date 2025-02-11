import java.util.Scanner;
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
        try {
            System.out.print("Código: ");
            producto.setCodigo(scanner.nextLine());
            System.out.print("Tipo: ");
            producto.setTipo(scanner.nextLine());
            System.out.print("Costo: ");
            producto.setCosto(Double.parseDouble(scanner.nextLine()));
            System.out.print("Impuesto (%): ");
            producto.setImpuesto(Double.parseDouble(scanner.nextLine()));
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos. Inténtelo de nuevo.");
            scanner.nextLine(); // Limpiar el buffer
            ingresarDatos(producto, scanner);
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