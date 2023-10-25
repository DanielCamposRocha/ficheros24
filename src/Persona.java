public class Persona {
    private final String nombre;
    private final String DNI;
    private int edad;
    private Double salario;
    private  boolean borrado=false;

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Persona(String nombre, String DNI, int edad, Double salario) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }


    public String getDNI() {
        return DNI;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Persona llamada " + nombre + ", con DNI= " + DNI + ", edad= " + edad +" y salario= " + salario +", borrado=" + borrado ;
    }
}
