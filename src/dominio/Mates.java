package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;
import java.util.stream.Stream;

public class Mates{
    //EJERCICIO 12
    public static void defincion(){
        System.out.println("una expresion lambda define el comportamiento de una funcion que voy a usar solo uan vez");
    }

    //EJERCICIO 13
    public static double integracionTrapecio(DoubleUnaryOperator f, double a, double b){
        double f_a=f.applyAsDouble(a);
        double f_b=f.applyAsDouble(b);
        double media=(f_a+f_b)/2;
        return (b-a)*media;
    }

    //EJERCICIO 14
    // 1. Generar un stream de números mediante el método estático of de la clase IntStream.
    public static void generarStreamOf() {
        IntStream stream1 = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("Stream generado con of:");
        stream1.forEach(System.out::println);  
    }
    
    // 2. Generar un stream de números mediante el método estático range de la clase IntStream.
    public static IntStream generarStreamRange() {
        IntStream stream2 = IntStream.range(1, 6); // Genera números del 1 al 5
        System.out.println("\nStream generado con range:");
        stream2.forEach(System.out::println);
    }

    // 3. Generar un stream de números mediante el método estático iterate de la clase IntStream.
    public static IntStream generarStreamIterate() {
        IntStream stream3 = IntStream.iterate(1, n -> n + 2).limit(5); // Genera los primeros 5 números impares empezando por 1
        System.out.println("\nStream generado con iterate:");
        stream3.forEach(System.out::println);
    }  

    // 4. Generar un stream de números aleatorios utilizando el método doubles de la clase Random.
    public static Stream<Double> generarStreamDoubles() {
        Random random = new Random();
        Stream<Double> stream4 = random.doubles(5).boxed(); // Genera 5 números aleatorios entre 0.0 (inclusive) y 1.0 (exclusive)
        System.out.println("\nStream generado con doubles:");
        stream4.forEach(System.out::println);
    } 
    
    //EJERCICIO 15
    //ejercicio 2 apartado 1
    public static int suma(int n){return IntStream.rangeClosed(0, n).sum();}

    //ejercicio2 apartado2
    public static int factorial(int n){return IntStream.rangeClosed(1, n).reduce(1,(x,y)->x*y);}
    
    //ejercicio2 apartado3
    public static int potencia(int base, int exponente){
        return IntStream.rangeClosed(1, exponente)
        .reduce(1, (acumulador, indice) -> acumulador * base);
    }
    
    //ejercicio2 apartado4
    public static int sumaLista(List<Integer> lista)
    {
        return lista.stream().mapToInt(Integer :: intValue).sum();
    }
    
    //ejercicio2 apartado5
    public static double media(List<Double> lista)
    {
        //el or else se usa para que si la lista esta vacia devuelva 0
        return lista.stream().mapToInt(Double :: intValue).average().orElse(0);
    }

    //ejercicio2 apartado6
    static double desviacion(List<Double> lista)
    {
        double x = media(lista);
        double media = media(lista.stream().mapToDouble(Double :: doubleValue).map(e -> Math.pow(e - x, 2)).boxed().collect(Collectors.toList()));
        return Math.sqrt(media);
    }

    //ejercicio2 apartado7
    static int sumaPares(int n)
    {
        int suma = IntStream
        .rangeClosed(1, n)
        .filter(e -> e%2 == 0)
        .sum();
        return suma;
    }

    //ejercicio2 apartado8
    public static int sumaEnterosPares(List<Integer> listaenteros ){
        int suma=listaenteros
        .stream()
        .filter(n->n%2==0)
        .mapToInt(Integer :: intValue)
        .sum();
        return suma;
    }
    
    //ejercicio2 apartado9
    public static ArrayList<Integer> obtenerLista(List<Integer> lista){
        ArrayList<Integer> array = new ArrayList<>();
        lista.stream()
        .filter(e -> e%2 == 0)
        .forEach(array::add);
        return array;
    }

    //ejercicio2 apartado10
     static ArrayList<Integer> listaPar(int n)
    {
        ArrayList<Integer> array = new ArrayList<>();
        IntStream.rangeClosed(2, n)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .filter(e -> e % 2 == 0)
        .forEach(e -> array.add(e));
        return array;
    }

    //ejercicio2 apartado11
    public static int productoEscalar(List<Integer> lista1, List<Integer> lista2){
        int producto=IntStream.range(0, lista1.size()).map(i->lista1.get(i)*lista2.get(i)).sum();
        return producto;
    }
    //ejercicio2 apartado12
    public static int elementonesimoFibonacci(int n){
        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
        .limit(n)
        .reduce((a, b) -> b)
        .orElse(new int[]{0, 1})[0];
    }

    //EJERCICIO 16 supongo que con ejercicio 13 se refiere al apartado de el ejercicio 2 
    public static double fibonacci() {
        double fib_13 = Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                        .limit(13)
                        .reduce((a, b) -> b)
                        .orElse(new int[]{0, 1})[1];

        double fib_12 = Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                              .limit(13)
                              .reduce((a, b) -> b)
                              .orElse(new int[]{0, 1})[0];

        return fib_13 / fib_12;
    }
}