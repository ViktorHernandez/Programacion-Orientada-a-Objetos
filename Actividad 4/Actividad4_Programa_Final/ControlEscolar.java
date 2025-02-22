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
    public MateriaBase() {
        this.nombre = "";
        this.clave = "";
        this.creditos = 0;
        this.horasSemanales = 0;
    }
    public MateriaBase(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }
    public MateriaBase(MateriaBase otraMateria) {
        this.nombre = otraMateria.nombre;
        this.clave = otraMateria.clave;
        this.creditos = otraMateria.creditos;
        this.horasSemanales = otraMateria.horasSemanales;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public int getHorasSemanales() {
        return horasSemanales;
    }
    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }
    public abstract void imprimirDetalles();
}
class Profesor implements Persona {
    private String nombre;
    private String numeroNomina;
    private double sueldoPorHora;
    private MateriaBase materia;
    public Profesor() {
        this.nombre = "";
        this.numeroNomina = "";
        this.sueldoPorHora = 0.0;
        this.materia = null;
    }
    public Profesor(double sueldoPorHora) {
        this.nombre = generarNombreAleatorio();
        this.numeroNomina = generarNumeroNomina();
        this.sueldoPorHora = sueldoPorHora;
        this.materia = null;
    }
    public Profesor(Profesor otroProfesor) {
        this.nombre = otroProfesor.nombre;
        this.numeroNomina = otroProfesor.numeroNomina;
        this.sueldoPorHora = otroProfesor.sueldoPorHora;
        this.materia = otroProfesor.materia != null ? new MateriaBase(otroProfesor.materia) : null;
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
    public void setNumeroNomina(String numeroNomina) {
        this.numeroNomina = numeroNomina;
    }
    public double getSueldoPorHora() {
        return sueldoPorHora;
    }
    public void setSueldoPorHora(double sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }
    public MateriaBase getMateria() {
        return materia;
    }
    public void setMateria(MateriaBase materia) {
        this.materia = materia;
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
    public Alumno() {
        this.nombre = "";
        this.matricula = "";
        this.edad = 0;
        this.curso = null;
    }
    public Alumno(int edad) {
        this.nombre = generarNombreAleatorio();
        this.matricula = generarMatricula();
        this.edad = edad;
        this.curso = null;
    }
    public Alumno(Alumno otroAlumno) {
        this.nombre = otroAlumno.nombre;
        this.matricula = otroAlumno.matricula;
        this.edad = otroAlumno.edad;
        this.curso = otroAlumno.curso;
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
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
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
    public Materia() {
        super();
    }
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        super(nombre, clave, creditos, horasSemanales);
    }
    public Materia(Materia otraMateria) {
        super(otraMateria);
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
    public Curso() {
        this.nombre = "";
        this.materia1 = null;
        this.materia2 = null;
        this.materia3 = null;
    }
    public Curso(String nombre, MateriaBase materia1, MateriaBase materia2, MateriaBase materia3) {
        this.nombre = nombre;
        this.materia1 = materia1;
        this.materia2 = materia2;
        this.materia3 = materia3;
    }
    public Curso(Curso otroCurso) {
        this.nombre = otroCurso.nombre;
        this.materia1 = otroCurso.materia1 != null ? new MateriaBase(otroCurso.materia1) : null;
        this.materia2 = otroCurso.materia2 != null ? new MateriaBase(otroCurso.materia2) : null;
        this.materia3 = otroCurso.materia3 != null ? new MateriaBase(otroCurso.materia3) : null;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public MateriaBase getMateria1() {
        return materia1;
    }
    public void setMateria1(MateriaBase materia1) {
        this.materia1 = materia1;
    }
    public MateriaBase getMateria2() {
        return materia2;
    }
    public void setMateria2(MateriaBase materia2) {
        this.materia2 = materia2;
    }
    public MateriaBase getMateria3() {
        return materia3;
    }
    public void setMateria3(MateriaBase materia3) {
        this.materia3 = materia3;
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
        MateriaBase historia = new Materia("Historia Universal", "HIS101", 4, 6);
        Curso curso1 = new Curso("Ciencias Exactas", algebra, biologia, historia);
        Profesor profesor1 = new Profesor(200.0);
        profesor1.asignarMateria(algebra);
        profesor1.imprimirDetalles();
        Alumno alumno1 = new Alumno(19);
        alumno1.asignarCurso(curso1);
        alumno1.imprimirDetalles();
    }
}