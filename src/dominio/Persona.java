package dominio;
import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    //metdodo constructor
    public Persona() {
    }

    public Persona(String nombre, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public long calcularEdad() {
        return LocalDate.now().getYear() - fechaDeNacimiento.getYear();
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
}
