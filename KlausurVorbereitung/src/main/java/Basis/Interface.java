package Basis;// Interfaces:
                // In Interfaces werden Basis.Methoden nicht implementiert, sondern nur ohne Implementation definiert.
                // -> nur Parameter, Name und Rückgabetyp (Ausnahme: default Basis.Methoden)

interface Interface1 {                                      // public kann weggelassen werden
    int N = 1;                                              // Klassenkonstante
    void m1 ();                                             // funktionale Methode
    static void m2 (int i) {System.out.println(i);}         // Klassenmethode
    default void m3 () {}                                   // default Methode
}

// public
                // Alle Basis.Methoden in einem Interface sind public, daher kann man es weglassen.
                // Bei der Implementation eines Interfaces in einer Klasse müssen die Basis.Methoden Public sein.
class InterfaceImpl1 implements Interface1 {
    @Override
    public void m1() {}

    @Override
    public void m3() {}
}

// abstract
                // Wenn mindestens eine der Basis.Methoden aus dem Interface nicht implementiert wird, so ist die Klasse, die das Interface implementiert abstract. (da sie dann mind eine abstracte Methode hat)
                // Wenn eine Klasse 2 oder mehr Interfaces mit den selben Basis.Methoden implementiert, so muss die Methode nur ein mal implementiert werden, Bedingung ist, dass Rückgabetyp, Name und Parameter identisch sind.
abstract class InterfaceImpl2 implements Interface1 {
    @Override
    public void m1() {}
}

interface Interface2 {}

// mehrfach vererben
                // Ein Interface kann ein anderes Interface erweitern, durch Basis.Vererbung – genau wie bei Basis.Klassen.
                // Interfaces können mehrfach vererben. (Im Gegensatz zu Basis.Klassen)
interface Interface3 extends Interface1,Interface2 {}

// Mehrfachvererbungsproblem:
                // Damit es nicht das Mehrfachvererbungsproblem (mehrere Supertypen vererben die gleiche Methode mit unterschiedlicher Implementation) gibt, bricht der Compailer mit einer Fehlermeldung ab.
                // Um das zu lösen muss man die Methode in der Klasse implementieren.

// Klassenkonstante in Interface
                // int N = 1;
                // Ein Interface kann implizit public, static und final (alles auf einmal) Klassenkonstanten haben.
                // Jedes Attribut eines Interfaces ist implizit public, static und final und somit eine Klassenkonstante. (Basis.Klassen können Attribute haben, die nicht public sind)

// Klassenmethode in Interface
                // static void m2 (int i) {System.out.println(i);}
                // Ein Interface kann implementierte Klassenmethoden haben. (implizit public).
                // Diese muss implementiert sein im Interface und ist dann auf viele verschiedene Basis.Klassen anwendbar.

// Default Methode in Interface
                // default void m3 () {}
                // Ein Interface kann implementierte Objektmethoden haben. (in Form von Default Basis.Methoden).
                // Es sind ganz normale Objektmethoden, die von einem Objekt der implementierenden Klasse aufgerufen werden kann. Aber in Interfaces muss das Schlüsselwort default davor.

// Implementation von Interfaces:
                // beliebig viele Interfaces möglich
class InterfaceImpl3 implements Interface1, Interface2, Interface3 {
    @Override
    public void m1() {}

    @Override
    public void m3() {}
}

// Funktional Interface:
                // Ein Funktional Interface ist ein Interface mit genau einer funktionalen Methode (einer Methode ohne Implementation, sprich keinen Methodenrumpf hat).
interface Interface4 {
    int N = 1;                                              // Klassenkonstante
    void m1 ();                                             // funktionale Methode
    static void m2 (int i) {System.out.println(i);}         // Klassenmethode
    default void m3 () {}                                   // default Methode
}

// Lambda-Ausdruck:
                // Ein Lambda-Ausdruck ist die Implementation einer funktionalen Methode eines funktionalen Interfaces, ohne eine extra Klasse zu erstellen.
interface IntToDoubleFunction1 {
    double applyAsDouble (int n);
}

interface IntToDoubleFunction2 {
    double applyAsDouble (int n, double x);
}

class IntToDoubleFunctionImpl implements IntToDoubleFunction1{
    private double x;
    public IntToDoubleFunctionImpl (double factor) {
        this.x = factor;
    }
    @Override
    public double applyAsDouble(int n) {
        return n*x;
    }
}

class IntToDoubleFunctionImplAufruf {
    public double ohneLambda () {
        IntToDoubleFunction1 itdF1 = new IntToDoubleFunctionImpl(10);     // Klassenerstellung: Basis.IntToDoubleFunctionImpl
        return itdF1.applyAsDouble(10);
    }
    public double mitLambda () {
        IntToDoubleFunction1 itdF2 = n -> n*10;                                 // Keine Klassenerstellung nötig, nur das Interface mit funktionaler Methode.
                                                                                // Der Compailer erzeugt selbst eine anonyme Klasse, die das Interface implementiert. Aus dem Lambda-Ausdruck wird dann die funktionale Methode gebildet.
        return itdF2.applyAsDouble(10);
    }

    public void komplexLambda () {
        IntToDoubleFunction2 itdF3 = (int n, double x) -> {                     // Die Klammern sind pflicht bei mehr als einem Parameter.
            System.out.println(n);
            System.out.println(x);
            return x;
        };
        IntToDoubleFunction2 itdF4 = (n, x) -> {                                // Die Typen können weggelassen werden (der Compailer kennt sie ja aus dem Interface)
            System.out.println(n);
            System.out.println(x);
            return x;
        };
    }

    public static double applyFct ( IntToDoubleFunction1 fct, int n ) {
        return fct.applyAsDouble ( n );
    }
    double y = IntToDoubleFunctionImplAufruf.applyFct ( x -> x * 3.14, 10 );  // Lambda-Ausdruck als Parameter
                                                                                 // Function wird ausgeführt, obwohl die Interface Methode Basis.IntToDoubleFunction1 in keiner Klasse implementiert wurde.
                                                                                 // -> im Lambda Ausdruck x->x*3.14 wird sie aber implementiert
}

// Anonyme Klasse:
                // Im Quelltext:        IntToDoubleFunction fct2 = x -> x * y; oder ... = ( int x ) -> { return x*y }
                //                      double z = fct2.applyAsDouble ( 11 );
                // Compailer:           class <<AnonymousClass>> implements IntToDoubleFunction {
                //                              double a;
                //                              public <<AnonymousClass>> ( double a ) {
                //                                  this.a = a;
                //                              }
                //                              public double applyAsDouble ( int x ) {
                //                                  return x * a;
                //                              }
                //                      }
                //                      IntToDoubleFunction fct2 = new <<AnonymousClass>> ( y );

class LambdaAusfuerung implements IntToDoubleFunction2{

    @Override
    public double applyAsDouble(int n, double x) {
        return Math.max(n,x);
    }

    // Ausführung:
    IntToDoubleFunction2 itdF5 = new LambdaAusfuerung();
    IntToDoubleFunction2 itdF6 = (n,x)->{return Math.max(n,x);};
    IntToDoubleFunction2 itdF7 = Math::max;
    // Aufruf:
    double i = itdF7.applyAsDouble(3, 2.17);
}