package Basis;

import java.awt.*;
import java.util.Calendar;

class DefinierenVSInitialisieren {

    // Variablen:
    int m;      // Definition:      int m;  m wird vorübergehend auf Nullwert gesetzt
                                // Nullwert: Zahlentypen: 0
                                //           Char:  ́\u0000 ́
                                //           Boolean: false
                                //           Referenztypen: null
    int n = 29; // Initialisierung:  n = 29;
                                //  Datentyp, name
    double d = 20.0;
    double definierenVSInitialisieren;
    float f = 3.0F;                 // Objektattribute:
                                                            // jedes Objekt der Klasse kann darauf zugreifen und es verändern;
                                                            // allerdings sind die Veränderungen Objektgebunden und können nur von den jeweiligen Objekt aufgerufen werden. Sie synchronisieren sich nicht.
    static double pi = 3.14;        // Klassenattribute:    // jedes Objekt der Klasse kann darauf zugreifen und es verändern;
                                                            // allerdings gibt es nur einen Wert, der immer synchronisiert wird. pi ist also Klassengebunden.
                                                            // Deshalb kann man direkt mit der Klasse auf pi zugreifen -> Basis.DefinierenVSInitialisieren.pi = 123;
                                                            // Dies ist sinnvoll bei Konstanten, z.B. PI

    // Konstante:         bekommt final, Datentyp, Name wird initialisiert, kann aber nicht verändert werden.
    final int Abc = 0; //这里名字要大写吗?

    // Constructor / Konstruktor:
                                    // Methode, die beim Einrichten eines Klassenobjekts (durch new Operator) aufgerufen wird.
                                    // Public Klassenname(Konstruktorfüllung) {Klasseninhalt}

                                    // Man schreibt Konstruktoren, um neuen Klassenobjekten einen Anfangswert zu geben.
                                    // Konstruktoren, können genauso, wie Basis.Methoden überladen werden. Wie unten.
    public DefinierenVSInitialisieren (int definierenVSInitialisieren) {System.out.println("Definieren VS Initialisieren!   " + definierenVSInitialisieren);}
    // public Basis.DefinierenVSInitialisieren (int m) {System.out.println("Definieren VS Initialisieren!");}      // 'Basis.DefinierenVSInitialisieren(int)' is already defined in 'Basis.DefinierenVSInitialisieren'
                                                                                                             // Obwohl die Attribute vershiedene Namen besitzen, tauscht auch dieser Fehler auf.
    // public Basis.DefinierenVSInitialisieren () {System.out.println("Definieren VS Initialisieren!   " + 12);}
    public DefinierenVSInitialisieren () {
        this (123);
    }                  // this:
                                                                                            // ebenso kann man mit this den Konstruktor derselben aufrufen.
                                                                                            // Hier wird ein zweiter Konstruktor erstellt, der den ersten Konstruktor mit dem Wert 123 aufruft.
    public DefinierenVSInitialisieren (double definierenVSInitialisieren) {this.definierenVSInitialisieren = definierenVSInitialisieren;}
                                    // Ein Objekt der Klasse Basis.DefinierenVSInitialisieren bekommt beim Initialisieren direkt eine Länge zugewiesen.
                                    // Durch this.length wird die Attribute length nur für das Objekt gesetzt

    // Methode:

                    // Getter and Setter:
    int length;
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
                    // this:
                                // Mit dem Schlüsselwort this kann man in einer Methode das Attribut der Klasse ansprechen.
                                // So muss man sich nicht immer neue Namen für den Parameter ausdenken.
                                // Es wird also das Attribut der Klasse mit dem Parameter initialisiert. Ohne Fehler, obwohl sie den selben Namen haben.

    // Lokale Variablen:  sind Variablen, die in einer Methode definiert sind.
                        // Außerhalb der Methode kann man sie nicht verwenden. Der Scope der Variable ist also der Methodenrumpf.
    public void lokaleVariablen () {
        int i = 0;
    }

    // Rechtsausdrücke：- Primitive Datentypen(z.B. int, boolean)
    //                  - String
    //                  - Methode mit Rückgabewert
    //                  - Null
    //                  - Aktualer Parameter (a.meth ( 4 * 5 + 3 );)
    //                  - Rückgabewert (return 5 * 6 + 4;)
    //                  Jeder Rechtsausdruck hat einen Wert und einen Typ

    // Linksausdrücke: - int n=...
    //                 - Arraykomponente (a[])
    //                 - Attribut (a.i;)
    //                 Jeder Linksausdruck verweist auf eine Speicherstelle

    // Seiteneffekte:
    public void seiteneffekte () {
        System.out.println (++n);    // 30
        System.out.println (n--);    // 30
        System.out.println (n);      // 29
        System.out.println (--n);    // 28
        System.out.println (n++);    // 28
        System.out.println (n);      // 29

        System.out.println (d);      // 20.0
        System.out.println (f);      // 3.0
        d*=f;                        // d = d*f
        System.out.println (d);      // 60.0
    }

    public void objekt () {
        // Referenz: jedes Objekt besitzt eine Referenz = Speicherort. Dort wird der Name und die Attribute abgespeichert.
        // Der dynamische Typ ist weder gleich dem statischen Typ noch Subtyp des statischen Typs. Daher hätte das Objekt nicht unbedingt alle Funktionalitäten, die man über die Referenz ansprechen kann.

        // Objekt:      Referenztyp Objektname = new Klassenname();
                     // Referenztyp: meist Klassenname, kann aber auch (in)direkt abgeleitete Klasse sein.
                                    // Quasi der Datentyp, also wie das Objekt gespeichert wird.
                     // new        : sucht ausreichend ungenutzten Speicherplatz für das Objekt. Mehr nicht.
    }
}

class Initializer {

    // Der static initializer ist eine Methode, die zu Beginn des Programms ausgeführt wird.
    // In diesem Bespiel wird zu Beginn des Programms der Tag auf den aktuellen Wochentag gesetzt.
    // Der Hauptsinn ist, Klassenkonstanten zu initialisieren in Fällen, in denen es nicht möglich oder sinnvoll ist, sie schon in der Definition zu initialisieren.
    public static final int DAY_OF_WEEK;
    static{
        DAY_OF_WEEK = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }
}

class Klassen {
    // Klassenkopf + Klassenrumpf (Attribute, Basis.Methoden)
    // Basis.Klassen class = new Basis.Klassen(); // Objekte (can use all Attribute, Basis.Methoden) der Klasse zu erstellen
}

class Identifier {
    // Basis.Identifier sind selbst ausgewählt Namen: die Basis.Klassen(Basis.DefinierenVSInitialisieren1),
    //                                              Variablen(int definierenVSInitialisieren1),
    //                                              Objekten(dVSi_1),
    //                                              Basis.Methoden(objekt)
    //                                          zugeschrieben werden.
    DefinierenVSInitialisieren1 dVSi_1 = new DefinierenVSInitialisieren1(111);
            // “a-Z”, “”0-9”, ”_,$”
            // 1. Zeichen keine Ziffer
            // nicht gleich einem Schlüsselwort
}

class DefinierenVSInitialisieren1 extends DefinierenVSInitialisieren {

    // super:
    // Mit dem Schlüsselwort super ruft man bei einer Erbenden Klasse, den Konstruktor der Basisklasse auf.
    public DefinierenVSInitialisieren1 (int definierenVSInitialisieren1) {
        super(definierenVSInitialisieren1);
    }
    // public Basis.DefinierenVSInitialisieren1 (int definierenVSInitialisieren1) {super();}
    public DefinierenVSInitialisieren1 () {
        super();
    }

    // Ebenso kann man mit super Basis.Methoden und Attribute der Basisklasse aufrufen.
    public void objekt() {super.objekt();}          // objekt kommt zweimal vor, dennoch führt es zu keinem Namenskonflikt
    // super.definierenVSInitialisieren = 12345; //不知道为什么无法继承?            // n kommt zweimal vor, dennoch führt es zu keinem Namenskonflikt.
    // int n = 123;
}

abstract class KlassenAbstract {
    private Point pos;

    // AbstractKlassen werden oft verwendet, um Eigenschaften und Fähigkeiten einer allgemeinen Typgruppe zu definieren, deren abgeleitete Unterklassen diese dann weiter spezifizieren.
    abstract void bewegDich(int h, int v);
    // Eine abstrakte Klasse ist eine Klasse mit mind 1 abstrakten Methode
    // Abstrakte Basis.Methoden haben keinen Methodenrumpf.
    // Klasse kann beliebig viele abstrakte Basis.Methoden haben (aber auch nicht abstrakte)
    public Point getPos() {
        return pos;
    }
    public void setPos(Point pos) {
        this.pos = pos;
    }

    // keine Objekte der abstracten Klasse (mit Operator new) erzeugen
    // erzeugt Objekte von der abgeleiteten Klasse
    // Eine Referenz einer abstrakten Klasse ist auch erlaubt.
    // Y erbt von X   Y b = new Y();
    //                X c = new Y();
}

class Methoden {
    private int length;
    int i1;
    static int i2;
    // Methodendefinition:
    // Modifier                 Rückgabetyp        Basis.Identifier      Exceptions      (Parameter)     {Methodenrumpf}
    // (public,static)          (void, int...)     ()              (name)          (int n)         (was macht diese Methode)

    // Methodenaufruf:
    // Objektname.Methodenname(Parameter);

    public Methoden () { System.out.println("Basis.Methoden!");}

    // Rückgabetyp: Bei Ausführung der Methode erhält man immer eine Rückgabe.
    //              int,
    //              void: Liefern nichts zurück, haben keinen Rückgabetypen
    //                    Verändern in der Regel (idR) nur Variablenwerte der Basis.Klassen
    public int getLength() {
        return length;
    }
    public void setlength(int newlength) {
        length = newlength;
    }

    // Parameter: formaler und aktualer Parameter
    // formaler Parameter: Alles, bei der Methodendefinition in der Parameterliste steht, ist ein formaler Parameter.
    //                     public Rückgabetyp Methodenname(formaler Parameter){Methodenrumpf}
    // aktualer Parameter: Alles was bei dem Methodenaufruf in der Parameterliste steht, ist ein aktualer Parameter.
    //                     Im Prinzip sind das lokale Variablen der Methode, die beim Aufruf initialisiert werden.
    //                     Objektname.Methodenname(aktualer Parameter);
    //                     Der aktuale parameter muss nicht denselben Typ, wie der formale Parameter haben.
    //                     Er muss nur in den Typ des formalen P. konvertierbar sein (z.B. wenn er ein Subtyp ist; oder int in double)

    public void variableParameterzahl1( char c, double... args ) {}
    public static void variableParameterzahl2( char c, double... args ) {}
    // Durch die drei Punkte am Typ des Parameters wird ein Array des Datentyps erstellt (hier also vom Typ double)
    // nameObjekt.variableParameterzahl (  ́d ́, 1.41, 2.71, 3.14 );
    // Der Compiler macht aus den Werten des aktualen Parameters direkt ein Array.

    // Klassenmethoden: „Eine Klassenmethode darf nicht auf das Objekt zugreifen, mit dem es aufgerufen wurde.“
    //                  (darf nicht generische Typparameter verwenden)
    //                  Methode darf auf kein Objektattribut / keine Objektmethode zugreifen
    //                  Auf ein Klassenattribut / eine Klassenmethode darf sie zugreifen
    public static void klassenmethoden () {
        // i1 = 1; // Objektattribut // Non-static field 'i1' cannot be referenced from a static context
        i2 = 1;    // Klassenattribut
        // Basis.Methoden.variableParameterzahl1( 'a', 1.41, 2.71, 3.14 );        // Objektmethode
        Methoden m = new Methoden();
        m.variableParameterzahl1( 'a', 1.41, 2.71, 3.14 );        // ?为什么这里可以
        Methoden.variableParameterzahl2( 'a', 1.41, 2.71, 3.14 ); // Klassenmethode
    }
}

// Basis.Methoden überschreiben
// das Zugriffsrecht darf bei der überschriebenen Methode nur „öffentlicher“ werden oder gleich bleiben.    ?
// der Rückgabetyp der Methode darf nur ein Subtyp sein oder gleich bleiben.                                ?
// bei primitiven Datentypen muss er gleich bleiben.                                                        ?
// exceptionklassen dürfen durch abgeleitete exceptionklassen (EK) ersetzt werden.                          ?
class MethodenUeberschreiben {
    public void m1() {}
    public void m2() {}
}
class MethodenUeberschreibenExtend extends MethodenUeberschreiben {
    public void m2() {} // wird bei der Basis.Vererbung eine Methode gleich benannt, so wird sie überschrieben.
                        // So kann man Basis.Methoden abändern.
                        // Hier wird m2 in Y überschrieben.
    public void m3() {}
}

// Basis.Methoden überladen:
// haben 2 Basis.Methoden den gleichen Namen, aber unterschiedliche Parameter, so wird sie nicht überschrieben, sondern überladen.
// die beiden Basis.Methoden sind eindeutig zu unterscheiden und für java unterschiedliche namen.
class MethodenUeberladen {
    public MethodenUeberladen ( int i ) { System.out.println("Basis.MethodenUeberladen!" + i );}
    public void m () {}
    public void m ( int i ) {}
    public void m ( double d ) {}
    public void m ( int i, double d ) {} // mU.m(123, 79.21);
    public void m ( double d, int i ) {} // mU.m ( 3.14, 321 );
    //mU.m ( 123, 321 );
    // hier kommt es allerdings zur Fehlermeldung, da nicht klar ist welche Methode gemeint ist.
    // Ambiguous method call: both 'Basis.MethodenUeberladen.m(int, double)' and 'Basis.MethodenUeberladen.m(double, int)' match
}


