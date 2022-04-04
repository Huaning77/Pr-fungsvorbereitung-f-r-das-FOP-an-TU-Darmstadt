package Basis;

import java.util.Calendar;

class Fehlerbehandlung {

    // Es gibt Laufzeitfehler (Ausführung des Programms wird abgebrochen) und Fehler, die garnicht erst zur Übersetzung führen.
    // Um einen Laufzeitfehler (Abbruch des Programms) zu verhindern, gibt es versch. Möglichkeiten.
    // Bsp. für Laufzeitfehler:
                                    // Durch null teilen
                                    // auf Attribut / Methode von null zugreifen
                                    // auf nicht existierende Array-Index zugreifen

    public Fehlerbehandlung () {
    }

    // Exceptions:
                                    // Exceptions sind Fehlerbehandlungen während der Laufzeit eines Programms.
                                    // Sie sorgen dafür, dass die Abarbeitung eines Programms auch im unerwünschten Fall nicht abgebrochen wird, sondern eine selbstgeschriebene Basis.Fehlerbehandlung durchgefüht wird und das Programm weiterläuft.
    // Exception ist eine Klasse. Von dieser erben alle Exceptionklassen. Man kann auch eigene schreiben.

    // Bsp:

    // Throw:
    public char toUpperCase(char c) throws Exception {         // wirft eine Exception
        if (c < 'a' || c > 'z')                                // wenn c es kein Kleinbuchstabe ist
            throw new Exception("No lower-case letter!");      //      dies wird dann geprintet
        return (char) (c - 'a' + 'A');                         // oder c wird als Großbuchstabe C returnt
    }
    // Throws (genaue) Exception: kündigt eine Exception in der Methode an
    // Throw new Exception: es wird tatsächlich ein Exception Objekt geworfen
    //  wie bei einem return, wird die Ausführung direkt beendet
    //  und die Anweisung im Exception-objekt geworfen
    //  gefangen wird sie, wo die Methode ausgeführt wird:  (“No lower-case letter!“): -Konstruktor des Exception-Objekts (String)

    // Try-Catch-Block:
    public void tryCatchBlock() {
        char x = '3';
        char y;
        Fehlerbehandlung abc = new Fehlerbehandlung();
        try {                                                   // Methodenaufrufe, die eine Exception werfen, müssen in einen try-block
            y = abc.toUpperCase(x);                             // toUpperCase wirft Exception
            System.out.print("Reached this line?");             // wird übersprungen, wenn eine Exception geworfen wird, dann geht’s (direkt in den catch-block)
        }                                                       // Es können beliebig viele Anweisungen mit und ohne Exception im try-Block stehen
        // Zwischen try & catch Blöcken darf keine Anweisung stehen
        catch (Exception exc) {                               // wird ausgeführt, wenn im try-block eine Exception geworfen wird   // (Exception exc)(hier muss nicht die genaue Exception stehen)
            System.out.print(exc.getMessage());               // Methode .getMessage von Exception gibt den Kostruktor String zurück
        }
    }
}

// Exceptions, bzw Basis.Methoden überschreiben:
                    // In der überschreibenden Methode darf eine Exception-Klasse ersetzt werden durch eine direkt oder indirekt abgeleitete Exception-Klasse
class ExceptionUeberschreiben1 {

    public ExceptionUeberschreiben1 () {}
    public void m () throws Exception {}
}

class ExceptionUeberschreiben2 extends ExceptionUeberschreiben1 {

    public ExceptionUeberschreiben2 () {}
    public void m () throws IndexOutOfBoundsException {}
}

// Exceptions aus Lambda:
                    // Im Lambda-Ausdruck kann auch eine Exception geworfen werden.
                    // Um die Ausführung div.apply muss dann ein try-Block mit anschließend catch-Block
class ExceptionLambda {

    public interface MyBinaryIntFunction {
        int apply ( int m, int n ) throws Exception;
    }

    MyBinaryIntFunction div = (m , n) -> {
        if ( n == 0 ) throw new Exception("The divisor number can not be 0!");
        return m / n;
    };
}

// eigene Exceptionklassen definieren:
                    // eine Exception-Klasse ist eine direkt oder indirekt von Exception abgeleitete Klasse.
                    // Exceptionklassen variieren meist nur im Namen und Konstruktor.
class ExceptionSelbstDefinition extends Exception{          // direkt abgeleitet
    public ExceptionSelbstDefinition(){                     // Konstruktoren werden nicht vererbt, daher wird mit super der String-Konstruktor von Exception aufgerufen & befüllt
        super( "It's witching hour!" );
    }

    public int hourOfNow () throws ExceptionSelbstDefinition {      // hier wird sie angewandt
        Calendar cal = Calendar.getInstance();
        int hour = cal.get( Calendar.HOUR_OF_DAY );
        if (hour == 14) throw new ExceptionSelbstDefinition();       // falls es 14 Uhr ist, wird abgebrochen & Exception geworfen
        return hour;
    }                                                               // Ausführung muss in try-bl.
}

// Mehrere Exceptions in einer Methode:
class MehrereExceptions{
    public MehrereExceptions () {}

    public void printHour (int hour) throws IndexOutOfBoundsException,ExceptionSelbstDefinition {
        String exc = "Invalid hour:" + hour;
        if (hour<0 || hour>24) throw new IndexOutOfBoundsException( exc );                  // Es wird entweder IOB-Exc geworfen
        if (hour == 14) throw new ExceptionSelbstDefinition();                              // oder WHE-Exc geworfen
        System.out.println(hour);                                                           // , oder hour zurückgegeben
    }
}

// Exceptions weiterreichen, statt fangen:
class ExceptionWeiterreichen {}

// RuntimeExceptions:
                    // Alle RuntimeException und davon abgeleitete Basis.Klassen müssen nicht gefangen werden.
                    // alle Programmabbrüche zur Laufzeit resultieren daraus
                    // -> Grund dafür ist die Häufigkeit dieser Exceptions.
                        // ArithmeticException (Division durch 0) ist bspw eine RunTimeException, wenn diese gefangen werden müsste, müsste bei jeder Division ein try-catchBlock folgen.

// Trowable, Error:
        // public class Throwable { .......... }
        // public class Exception extends Throwable { .......... }
                    // Klasse Exception ist von Throwable abgeleitet, alle von Throwable abgeleiteten Basis.Klassen haben den try-catch Mechanismus.
        // public class Error extends Throwable { .......... }
                    // Error und abgeleitete Basis.Klassen werden geworfen, wenn eine Basis.Fehlerbehandlung nicht mehr sinnvoll ist und der beste Weg es ist die Anwendung abzubrechen
                    // Error Basis.Klassen werden in der Regel nicht mit try-catch abgefangen.

// AssertionError:
        // public class AssertionError extends Error {...}
                    // Klasse AssertionError wird wie folgt angewandt:
                    // if ( n < 0 || n % 2 == 1 ) throw new AssertionError ( “Bad n!“ );
                            // oder (gegenteilige Anweisung):
                    // assert n >= 0 && n % 2 == 0 : “Bad n!“;
                    // Es führt mit der Fehlermeldung direkt zum Programmabbruch
        // Der vielleicht entscheidende Unterschied ist aber, dass assertAnweisungen beim Kompilieren an- oder abgeschaltet werden können mit entsprechenden Setzungen für den Compiler.
        // Das heißt, in der Testphase kann man die assert-Anweisungen in einem Programm anschalten, um Fehler zu finden, nach der Testphase kann man sie ausschalten.

// 19/20 WS. 3
/**
class Exc1 extends Exception {
    public Exc1 ( Object obj ) {
        super( obj instanceof Number ? String.valueOf(((Number) obj).doubleValue()) : obj.toString() );
    }

    public static B m ( A[] b, int n, X y ) throws Exc1, Exc2, Exc3 {
        if ( n < 0 || n >= b.length )
            throw new Exc2 ( n );
        if ( b[n] == null )
            throw new Exc3();
        if ( ! b[n].test(...) )
        throw new Exc1 (357);
        return y.apply ( b[n] );
    }
}

 **/