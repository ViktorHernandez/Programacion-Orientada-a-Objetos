import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SuperheroAndEvenNumbers {
    public static void main(String[] args) {
        verificarNombre();
        numerosPares();
    }
    public static void verificarNombre() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> nombresDefinidos = new HashMap<>();
        nombresDefinidos.put("Clark Kent", "Superman");
        nombresDefinidos.put("Diana Prince", "Wonder Woman");
        nombresDefinidos.put("Peter Parker", "Hombre Araña");
        nombresDefinidos.put("Bruce Banner", "Hulk");
        while (true) {
            System.out.print("Ingresa tu nombre para identificar tu identidad superheroica (o escribe 'salir' para terminar): ");
            String nombreUsuario = scanner.nextLine().trim();
            if (nombreUsuario.equalsIgnoreCase("salir")) {
                System.out.println("Identificación de identidad comprobada, puede proseguir a la sala de reuniones.");
                break;
            }
            boolean nombreEncontrado = false;
            for (Map.Entry<String, String> entry : nombresDefinidos.entrySet()) {
                if (nombreUsuario.equalsIgnoreCase(entry.getKey())) {
                    nombreEncontrado = true;
                    System.out.println("Identificación: " + entry.getKey() + ", alias: '" + entry.getValue() + "'. Bienvenido " + entry.getValue());
                    break;
                }
            }
            if (!nombreEncontrado) {
                if (nombreUsuario.isEmpty()) {
                    System.out.println("No ingresaste ningún nombre. Por favor, intenta nuevamente.");
                } else if (nombreUsuario.length() < 3) {
                    System.out.println("El nombre ingresado no coincide con ninguna base de datos. ¿Podrías ingresarlo de nuevo?");
                } else {
                    System.out.println("Bienvenido, " + nombreUsuario + ", no estás registrado en la base de datos. ¿Quieres registrarte? (sí/no)");
                    String respuesta = scanner.nextLine().trim();
                    if (respuesta.equalsIgnoreCase("sí") || respuesta.equalsIgnoreCase("si")) {
                        System.out.print("Por favor, ingresa el alias de superhéroe: ");
                        String aliasUsuario = scanner.nextLine().trim();
                        nombresDefinidos.put(nombreUsuario.substring(0, 1).toUpperCase() + nombreUsuario.substring(1).toLowerCase(), aliasUsuario);
                        System.out.println("Nombre registrado exitosamente como '" + aliasUsuario + "'.");
                    } else {
                        System.out.println("Entiendo. Sigamos.");
                    }
                }
            }
        }
        scanner.close();
    }
    public static void numerosPares() {
        ArrayList<Integer> numerosPares = new ArrayList<>();
        int i = 2;
        while (i <= 100) {
            numerosPares.add(i);
            i += 2;
        }
        int suma = 0;
        for (int numero : numerosPares) {
            suma += numero;
        }
        double promedio = suma / (double) numerosPares.size();
        System.out.println("Lista de números pares del 2 al 100:");
        for (int numero : numerosPares) {
            System.out.print(numero + " ");
        }
        System.out.println("\n\nSuma de los números pares: " + suma);
        System.out.println("Promedio de los números pares: " + promedio);
        int mayor = numerosPares.get(numerosPares.size() - 1);
        int menor = numerosPares.get(0);
        System.out.println("Mayor número par: " + mayor);
        System.out.println("Menor número par: " + menor);
    }
}
