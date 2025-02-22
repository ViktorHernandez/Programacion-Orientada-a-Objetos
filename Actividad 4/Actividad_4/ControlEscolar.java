import java.util.Random;
interface Persona {
    String getNombre();
    void setNombre(String nombre);
}
abstract class MateriaBase {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;
    public MateriaBase(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }
    public String getNombre() {
        return nombre;
    }
    public String getClave() {
        return clave;
    }
    public int getCreditos() {
        return creditos;
    }
    public int getHorasSemanales() {
        return horasSemanales;
    }
    public abstract void imprimirDetalles();
}
class Profesor implements Persona {
    private String nombre;
    private String numeroNomina;
    private double sueldoPorHora;
    private MateriaBase materia;
    public Profesor(double sueldoPorHora) {
        this.nombre = generarNombreAleatorio();
        this.numeroNomina = generarNumeroNomina();
        this.sueldoPorHora = sueldoPorHora;
        this.materia = null;
    }
    private String generarNumeroNomina() {
        return String.valueOf(new Random().nextInt(90000) + 10000);
    }
    private String generarNombreAleatorio() {
        String[] nombres = {"Kazuki Tanaka", "Ananya Patel", "Viktor Ivanov", "Fatima Al-Farsi", 
                            "Leandro Carvalho", "Sven Jorgensen", "Amara Okafor", "Mireille Dubois", 
                            "Tenzing Gyatso", "Ewa Kowalska"};
        return nombres[new Random().nextInt(nombres.length)];
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumeroNomina() {
        return numeroNomina;
    }
    public double getSueldoPorHora() {
        return sueldoPorHora;
    }
    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }
    public void asignarMateria(MateriaBase materia) {
        if (this.materia == null) {
            this.materia = materia;
        } else {
            System.out.println("El profesor ya tiene una materia asignada.");
        }
    }
    public double calcularSueldoSemanal() {
        return (materia != null) ? materia.getHorasSemanales() * sueldoPorHora : 0.0;
    }
    public void imprimirDetalles() {
        System.out.println("=========================================");
        System.out.println("Profesor: " + nombre);
        System.out.println("Número de Nómina: " + numeroNomina);
        System.out.println("Materia: " + (materia != null ? materia.getNombre() : "No asignada"));
        System.out.println("Sueldo Semanal: " + calcularSueldoSemanal());
        System.out.println("=========================================");
    }
}
class Alumno implements Persona {
    private String nombre;
    private String matricula;
    private int edad;
    private Curso curso;
    public Alumno(int edad) {
        this.nombre = generarNombreAleatorio();
        this.matricula = generarMatricula();
        this.edad = edad;
        this.curso = null;
    }
    private String generarMatricula() {
        return "A" + (new Random().nextInt(900) + 100);
    }
    private String generarNombreAleatorio() {
        String[] nombres = {"Zubair Khan", "Isla MacLeod", "Dmitry Petrov", "Chinwe Eze", 
                            "Aiko Yamamoto", "Rajesh Iyer", "Salvador Mendez", "Yasmine El-Baz", 
                            "Jürgen Müller", "Lina Popescu"};
        return nombres[new Random().nextInt(nombres.length)];
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMatricula() {
        return matricula;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void asignarCurso(Curso curso) {
        this.curso = curso;
    }
    public void imprimirDetalles() {
        System.out.println("-----------------------------------------");
        System.out.println("Alumno: " + nombre);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Edad: " + edad);
        System.out.println("Curso: " + (curso != null ? curso.getNombre() : "No asignado"));
        System.out.println("-----------------------------------------");
    }
}
class Materia extends MateriaBase {
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        super(nombre, clave, creditos, horasSemanales);
    }
    @Override
    public void imprimirDetalles() {
        System.out.println("  - Materia: " + getNombre());
        System.out.println("    Clave: " + getClave());
        System.out.println("    Créditos: " + getCreditos());
        System.out.println("    Horas Semanales: " + getHorasSemanales());
    }
}
class Curso {
    private String nombre;
    private MateriaBase materia1;
    private MateriaBase materia2;
    private MateriaBase materia3;
    public Curso(String nombre, MateriaBase materia1, MateriaBase materia2, MateriaBase materia3) {
        this.nombre = nombre;
        this.materia1 = materia1;
        this.materia2 = materia2;
        this.materia3 = materia3;
    }
    public String getNombre() {
        return nombre;
    }
    public int obtenerCreditosTotales() {
        return materia1.getCreditos() + materia2.getCreditos() + materia3.getCreditos();
    }
    public void imprimirDetalles() {
        System.out.println("=========================================");
        System.out.println("Curso: " + nombre);
        System.out.println("Créditos Totales: " + obtenerCreditosTotales());
        materia1.imprimirDetalles();
        materia2.imprimirDetalles();
        materia3.imprimirDetalles();
        System.out.println("=========================================");
    }
}
public class ControlEscolar {
    public static void main(String[] args) {
        MateriaBase algebra = new Materia("Álgebra", "ALG202", 6, 10);
        MateriaBase biologia = new Materia("Biología", "BIO303", 5, 8);
        MateriaBase historia = new Materia("Historia Universal", "HIS404", 4, 7);
        MateriaBase programacion = new Materia("Programación", "PROG505", 6, 12);
        MateriaBase literatura = new Materia("Literatura", "LIT606", 4, 6);
        Curso cursoCiencias = new Curso("Ciencias Naturales", algebra, biologia, historia);
        Curso cursoTecnologia = new Curso("Tecnología Avanzada", programacion, algebra, literatura);
        Profesor profe1 = new Profesor(180);
        Profesor profe2 = new Profesor(200);
        Profesor profe3 = new Profesor(170);
        profe1.asignarMateria(algebra);
        profe2.asignarMateria(biologia);
        profe3.asignarMateria(programacion);
        Alumno alumno1 = new Alumno(19);
        Alumno alumno2 = new Alumno(21);
        Alumno alumno3 = new Alumno(18);
        alumno1.asignarCurso(cursoCiencias);
        alumno2.asignarCurso(cursoTecnologia);
        alumno3.asignarCurso(cursoCiencias);
        profe1.imprimirDetalles();
        profe2.imprimirDetalles();
        profe3.imprimirDetalles();
        alumno1.imprimirDetalles();
        alumno2.imprimirDetalles();
        alumno3.imprimirDetalles();
        cursoCiencias.imprimirDetalles();
        cursoTecnologia.imprimirDetalles();
    }
}