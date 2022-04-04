package Basis;

class Basic {
    public Basic (int x, int y, Direction direction, int numberOfCoins) {}
}

enum Direction {
    RECHT,
    UNTEN,
    LINK,
    OBEN
}

// Basis.Vererbung:
            // Wenn man eine Klasse von einer anderen Klasse erbenlassen möchte, schreibt man extends hinter den Klassennamen.
            // Erben bedeutet, dass die Basis.Methoden und Variablen und möglice Verknüpfungen (z.B. FopBot World) kopiert werden, allerdings noch neue hinzugefügt werden können, die im Orginal nicht existieren.
            // Basis.Basic(Klassenname) ist die Basisklasse von Basis.Vererbung(Klassenname), Basis.Vererbung ist also abgeleitet.
            // Keine Mehrfachvererbung möglich

class Vererbung extends Basic{
    private int delay;
    public Vererbung (int x, int y, Direction direction, int numberOfCoins, int delay) {        // Konstruktor der Erbenden Klasse:
        super(x,y,direction,numberOfCoins);                                                             // Der Konstruktor der Klasse Basis.Vererbung ruft den Konstruktor der Klasse Basis.Basic auf.
                                                                                                        // Mit super wird der Konstruktor der Basisklasse (oder der Basisklasse der Basisklasse etc) aufgerufen und mit den Anfangswerten befüllt.
                                                                                                        // Der Aufruf des Konstruktors der Basisklasse muss immer die erste Anweisung im Konstruktor der abgeleiteten Klasse sein.
        this.delay = delay;                                                                             // this.delay ist eine exklusive Variable der Klasse Basis.Vererbung, muss also zusätzlch in den Konstruktor aufgenommen werden.
    }

    public int getDelay() {
        return delay;
    }
    public void setDelay(int delay) {
        this.delay = delay;
    }
}

// Arrays mit gemischten Klasse:
            // Man kann durch Basis.Vererbung Arrays erstellen mit gemischten Basis.Klassen.
            // Die Objekte müssen aber direkt oder indirekt von der Klasse abgeleitet sein.
class VererbungArray {
    Basic[ ] basics = new Basic[2];
    public VererbungArray () {
        basics[0] = new Basic(0,10,Direction.LINK,100);
        basics[1] = new Vererbung(1,2,Direction.OBEN,200,1);
    }
}


// Basisklasse:
            // public class X extends Y {}
                    // Bei Basis.Vererbung ist hier Basis.Basic die Basisklasse
            // public class X {}
                    // Ohne Basis.Vererbung ist Object die Basisklasse (java.lang.Object aus der Standardbibliothek)

// Subtypen:
            // Alle von einer Klasse, einem Interface (in)direkt abgeleiteten Basis.Klassen, Interfaces.
                    // public class X
                    // public class Y extends X
                    // public class Z extends Y
                                // Y,Z sind Subtypen von X; Z ist Subtyp von Y.
            // Jede Klasse, die durch eine Kette von „extends“ und „implements“ aus einem Interface abgeleitet ist, ist ein Subtyp dieses Interface.

// Statischer Typ:
            // X a = new Y();
                        // public class X {
                        //    public int n1;
                        //    public void m1() { ... }
                        // }
                        // public class Y extends X {
                        //    public int n2;
                        //    public void m1() { ... }
                        // }
            // Der statische Typ einer Referenz ist der, mit dem sie verknüpft wird.
            // X ist der statische Typ von a.
            // Dieser Typ ist unveränderlich mit der Referenz verknüpft, daher der Begriff statischer Typ.

            // a.n1 = 1;
                        // -> es darf auf n1 zugegriffen werden, da der statische Typ X n1 enthält.
            // a.n2 = 2;  // falsch
                        // -> es darf nicht auf n2 zugegriffen werden, da der statische Typ X n2 nicht enthält.
            // a.m1();
                        // -> es darf auf m1 zugegriffen werden, da der statische Typ X m1 enthält.
                        // Es wird dann aber auf die implementation des dynamischen Typs Y zugegriffen, da die Methode dort verändert wurde.

            // Der statische Typ entscheidet auf welche Attribute und Basis.Methoden zugegriffen werden darf.

// Dynamischer Typ:
            // Der dynamische Typ einer Referenz ist der Typ des Objekts, auf das diese Referenz verweist.
            // Y ist der dynamische Typ von a.
            // Der dynamische Typ muss immer entweder gleich dem statischen Typ oder ein Subtyp des statischen Typs sein.
            // Der dynamische typ kann sich häufig ändern.