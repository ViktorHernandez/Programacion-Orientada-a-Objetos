import java.util.ArrayList;
import java.util.Scanner;
public class VerificarNombre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombresDefinidos = new ArrayList<>();
        nombresDefinidos.add("Clark Kent");
        nombresDefinidos.add("Diana Prince");
        nombresDefinidos.add("Peter Parker");
        nombresDefinidos.add("Bruce Banner");
        while (true) {
            System.out.print("Ingresa tu nombre para identificar tu identidad superheroica (o escribe 'salir' para terminar): ");
            String nombreUsuario = scanner.nextLine().trim();
            if (nombreUsuario.equalsIgnoreCase("salir")) {
                System.out.println("Identificacion de identidad comprobada, puede proseguir a la sala de reuniones.");
                break;
            }
            boolean nombreEncontrado = false;
            for (String nombre : nombresDefinidos) {
                if (nombreUsuario.equalsIgnoreCase(nombre)) {
                    nombreEncontrado = true;
                    if (nombreUsuario.equalsIgnoreCase("Clark Kent")) {
                        System.out.println("Identificación: Clark Kent, alias ´Superman´. Bienvenido Superman");
                    } else if (nombreUsuario.equalsIgnoreCase("Diana Prince")) {
                        System.out.println("Identificación: Diana Prince, alias ´Wonder Woman´. Bienvenida Wonder Woman");
                    } else if (nombreUsuario.equalsIgnoreCase("Peter Parker")) {
                        System.out.println("Identificación: Peter Parker, alias: ´Hommbre Araña´. Bienvenido Hommbre Araña");
                    } else if (nombreUsuario.equalsIgnoreCase("Bruce Banner")) {
                        System.out.println("Identificación: Bruce Banner, alias: ´Hulk´. Bienvenido Hulk");
                    } else {
                        System.out.println("¡Hola, " + nombreUsuario + "!");
                    }
                    break;
                }
            }
            if (!nombreEncontrado) {
                if (nombreUsuario.isEmpty()) {
                    System.out.println("No ingresaste ningún nombre. Por favor, intenta nuevamente.");
                } else if (nombreUsuario.length() < 3) {
                    System.out.println("El nombre ingresado no coincide con ninguna base de datos. ¿Podrías ingresarlo denuevo?");
                } else {
                    System.out.println("Bienvenido, " + nombreUsuario + ", no estas registrado en la base de datos. ¿Quieres registrarte? (sí/no)");
                    String respuesta = scanner.nextLine().trim();
                    if (respuesta.equalsIgnoreCase("sí") || respuesta.equalsIgnoreCase("si")) {
                        nombresDefinidos.add(nombreUsuario.substring(0, 1).toUpperCase() + nombreUsuario.substring(1).toLowerCase());
                        System.out.println("Nombre registrado exitosamente.");
                    } else {
                        System.out.println("Entiendo. Sigamos.");
                    }
                }
            }
        }
        scanner.close();
    }
}