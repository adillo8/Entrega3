package aplicacion;
import dominio.Mates;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Principal {
    public static void main(String[] args) {
        // Ejercicio 12: Llamada al método de la definición
        Mates.defincion();
        
        // Ejercicio 13: Integración por el método del trapecio
        double resultado = Mates.integracionTrapecio(x -> x * x, 0, 1);
        System.out.println("Resultado de la integración por el método del trapecio: " + resultado);

        // Ejercicio 14: Generación de streams
        Mates.generarStreamOf();
        Mates.generarStreamRange();
        Mates.generarStreamIterate();
        Mates.generarStreamDoubles();

        // Ejercicio 15: Operaciones con streams
        System.out.println("Suma de los primeros 10 números naturales: " + Mates.suma(10));
        System.out.println("Factorial de 5: " + Mates.factorial(5));
        System.out.println("Potencia de 2 elevado a 3: " + Mates.potencia(2, 3));

        List<Integer> listaEnteros = List.of(1, 2, 3, 4, 5);
        System.out.println("Suma de los elementos de la lista: " + Mates.sumaLista(listaEnteros));

        List<Double> listaDoubles = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println("Media de la lista de números: " + Mates.media(listaDoubles));

        System.out.println("Desviación estándar de la lista de números: " + Mates.desviacion(listaDoubles));

        System.out.println("Suma de los primeros 10 números pares: " + Mates.sumaPares(10));

        List<Integer> listaPares = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Suma de los números pares de la lista: " + Mates.sumaEnterosPares(listaPares));

        List<Integer> listaParesObtenidos = Mates.obtenerLista(listaPares);
        System.out.println("Lista de números pares obtenida: " + listaParesObtenidos);

        System.out.println("Lista de números pares hasta 10: " + Mates.listaPar(10));

        List<Integer> lista1 = List.of(1, 2, 3);
        List<Integer> lista2 = List.of(4, 5, 6);
        System.out.println("Producto escalar de las listas: " + Mates.productoEscalar(lista1, lista2));

        // Ejercicio 12: Elemento n-ésimo de Fibonacci
        int n = 10;
        System.out.println("El elemento " + n + " de la secuencia de Fibonacci es: " + Mates.elementonesimoFibonacci(n));

        // Ejercicio 16: Fibonacci
        System.out.println("Proporción áurea: " + Mates.fibonacci());
    }
}

