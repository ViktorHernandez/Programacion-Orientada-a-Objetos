import java.util.ArrayList;
public class NumerosPares {
    public static void main(String[] args) {
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
