package Generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main (String[] args) {
        WrapperKlassen wk = new WrapperKlassen();       // true         // true
                                                        // ?
                                                        // 100
                                                        // -12345
                                                        // 12345678     // 12345678     // 2147483647       // -2147483648
                                                        // 45678901234
                                                        // 3.14
                                                        // 2.71E17

        List<String> woerter = Arrays.asList("Welt","PC","Hallo","Tag");
        //1. Stream erstellen
        Stream<String> woerterStream = woerter.stream();
        //2. beliebig viele intermediate Operations
        Stream<String> woerterStreamSortiert = woerterStream.sorted(); //mit Comparator -> ...alphabetisch
        Stream<String> woerterStreamSoGefiltert = woerterStreamSortiert.filter(string -> string.length() > 3);
        Stream<String> woerterStreamSoGeGross = woerterStreamSoGefiltert.map(String::toUpperCase);
        //oder einfacher:
        Stream<Object> opt = woerterStream.sorted().filter(string -> string.length() > 3).map(String::toUpperCase);
        //3. terminale Operation
        woerterStreamSoGeGross.forEach(System.out::println); //-> "Hallo" "Welt"
    }
}

