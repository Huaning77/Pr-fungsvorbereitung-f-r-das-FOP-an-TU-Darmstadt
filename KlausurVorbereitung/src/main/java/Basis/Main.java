package Basis;

import java.util.Arrays;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws Exception {
        MethodenUeberladen mU = new MethodenUeberladen(1);
        mU.m(123, 79.21);
        mU.m ( 3.14, 321 );
        // mU.m ( 123, 321 );

        Methoden me = new Methoden();
        me.variableParameterzahl1( 'a', 1.41, 2.71, 3.14 );          // Objektmethode
        Methoden.variableParameterzahl2('a', 1.41, 2.71, 3.14 );     // Klassenmethode

        DefinierenVSInitialisieren dVSi = new DefinierenVSInitialisieren(1);    // Definieren VS Initialisieren!   1
        System.out.println (dVSi.m);                                            // 0
        dVSi.seiteneffekte();
        System.out.println (dVSi.m);                                            // 0
        dVSi.m = 3;
        System.out.println (dVSi.m);                                            // 5
        System.out.println (DefinierenVSInitialisieren.pi);                     // 3.14
        // System.out.println (dVSi.pi);                                        // Static member 'Basis.DefinierenVSInitialisieren.pi' accessed via instance reference
        dVSi.m = 5;
        DefinierenVSInitialisieren.pi = 3;
        System.out.println (dVSi.m);                                            // 5
        System.out.println (DefinierenVSInitialisieren.pi);                     // 3.0

        // Basis.Initializer initializer = new Basis.Initializer();
        System.out.println (Initializer.DAY_OF_WEEK);                           // the day of week calculated from sunday, Dienstag -> 3

        // Basis.DefinierenVSInitialisieren dVSi3 = new Basis.DefinierenVSInitialisieren(11);  // Definieren VS Initialisieren!   11
        // Basis.DefinierenVSInitialisieren dVSi1 = new Basis.DefinierenVSInitialisieren();    // Definieren VS Initialisieren!   12
        // Basis.DefinierenVSInitialisieren1 dVSi2 = new Basis.DefinierenVSInitialisieren1(11);// Definieren VS Initialisieren!   12   //super


        DefinierenVSInitialisieren dVSi3 = new DefinierenVSInitialisieren(11);  // Definieren VS Initialisieren!   11           // public Basis.DefinierenVSInitialisieren (int definierenVSInitialisieren)
        DefinierenVSInitialisieren dVSi1 = new DefinierenVSInitialisieren();    // Definieren VS Initialisieren!   123          // public Basis.DefinierenVSInitialisieren () {this (123);}
        DefinierenVSInitialisieren dVSi2 = new DefinierenVSInitialisieren(11);  // Definieren VS Initialisieren!   11           // public Basis.DefinierenVSInitialisieren (int definierenVSInitialisieren)

        DefinierenVSInitialisieren1 dVSi5 = new DefinierenVSInitialisieren1();      // Definieren VS Initialisieren!   123      // public Basis.DefinierenVSInitialisieren1 () {super();}
        DefinierenVSInitialisieren1 dVSi4 = new DefinierenVSInitialisieren1(1234);  // Definieren VS Initialisieren!   123      // public Basis.DefinierenVSInitialisieren1 (int definierenVSInitialisieren1) {super();}
                                                                                    // Definieren VS Initialisieren!   1234     // public Basis.DefinierenVSInitialisieren1 (int definierenVSInitialisieren1) {super(definierenVSInitialisieren1);}

        System.out.println(dVSi4.n);                                                // Direkt die Variable der Basisklasse aufzurufen

        ForSchleife fS1 = new ForSchleife();        // 0
                                                    // 1
                                                    // 2
                                                    // 3
                                                    // 4

        Array1 array = new Array1();
        System.out.println(Arrays.deepToString(array.a)); // [[0.0, 0.0], [0.0, 0.0], [0.0, 0.0]]
        System.out.println(array.a.length);               // 3
        System.out.println(Arrays.deepToString(array.ArrayInitializer1(array.a)));
                                                          // [[0.0, 1.0], [0.0, 1.0], [0.0, 1.0]]
        System.out.println(Arrays.deepToString(array.ArrayInitializer2(array.a)));
                                                          // [[0.0, 1.0], [0.0, 3.14], [0.0, 15.700000000000001]]   // 3.14 * 5 = 15.7

        Calendar month1 = Calendar.getInstance();
        SwitchAnweisung sA = new SwitchAnweisung();
        sA.showTheSpecial1(1);                         // Winter depression...
        sA.showTheSpecial2(13);                        // ???

        Bedingungsoperator bedingungsoperator = new Bedingungsoperator();
        System.out.println(bedingungsoperator.bO(5));                   // The integer is 8?
        System.out.println(bedingungsoperator.bO(8));                   // The integer is 8!

        Fehlerbehandlung fehlerbehandlung = new Fehlerbehandlung();
        System.out.println(fehlerbehandlung.toUpperCase('d'));          // D
        // System.out.println(fehlerbehandlung.toUpperCase('!'));          // Exception in thread "main" java.lang.Exception: No lower-case letter!
        fehlerbehandlung.tryCatchBlock();                                  // No lower-case letter!

        System.out.println();
        System.out.println("********************");
        try {
            ExceptionLambda el = new ExceptionLambda();
            System.out.println(el.div.apply(0,1));                   // m/n = 0
            System.out.println("The value of n is not 0!");                 // The value of n is not 0!
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ExceptionLambda el1 = new ExceptionLambda();
            el1.div.apply(0,0);
            System.out.println("The value of n is not 0!");
        } catch (Exception e) {
            System.out.println(e.getMessage());                             // The divisor number can not be 0!
        }

        System.out.println("********************");
        try {
            ExceptionSelbstDefinition esd = new ExceptionSelbstDefinition();
            System.out.println(esd.hourOfNow());                            // 14  // It's witching hour!
        } catch (ExceptionSelbstDefinition e) {                             // oder einfach Exception hier
            System.out.println(e.getMessage());
        }

        MehrereExceptions mE = new MehrereExceptions();
        System.out.println("********************");
        try {
            mE.printHour(14);
        } catch (ExceptionSelbstDefinition e) {
            System.out.println(e.getMessage());                             // It's witching hour!
        }
        System.out.println("********************");
        try {
            mE.printHour(25);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());                             // Invalid hour:25
        }

        System.out.println("********************");
        try {
            mE.printHour(13);                                               // 13
        } catch (ExceptionSelbstDefinition | IndexOutOfBoundsException e) { // Es wird nur ein try-block benötigt, aber für jede Exc. ein catch-block
            System.out.println(e.getMessage());
        }

        System.out.println("********************");
        Jahreszeit a = Jahreszeit.SOMMER;
        if( a == Jahreszeit.SOMMER ) {
            System.out.println("es ist warm");                              // es ist warm
        }
        // Um nicht immer die Klasse vor den Enumbegriff zu schreiben, kann man in der Klasse die Enumklasse importieren. ???

        switch (a) {
            case WINTER: System.out.println("es schneit"); break;
            case SOMMER: System.out.println("die Sonne lacht"); break;
            default: break;
        }

        IntToDoubleFunctionImplAufruf itdFIA = new IntToDoubleFunctionImplAufruf();
        System.out.println(itdFIA.mitLambda());                             // 100.0
    }
}
