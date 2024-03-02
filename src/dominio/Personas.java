package dominio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import dominio.Persona;

public class Personas {
    public List<Persona> listaPersonas;
    
    public Personas() {
            this.listaPersonas = new ArrayList<>();
    }
    
    public void annadirPersona(Persona persona) {
            listaPersonas.add(persona);
    }
    
    public Persona elMasJoven() {
        return listaPersonas.stream()
        .min((p1, p2) -> p1.getFechaDeNacimiento().compareTo(p2.getFechaDeNacimiento()))
        .orElse(null);
    }
    
    public long calcularSumaEdades() {
        return listaPersonas.stream()
        .mapToLong(Persona::calcularEdad)
        .sum();
    }
    
    public long calcularEdadMinima() {
        return listaPersonas.stream()
        .mapToLong(Persona::calcularEdad)
        .min()
        .orElse(0);
    }
    
    public double calcularMediaDeEdad() {
        return listaPersonas.stream()
        .mapToLong(Persona::calcularEdad)
        .average()
        .orElse(0);
    }
}
    
