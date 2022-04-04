package Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

// Wrapper Klassen
            //- Für die Mittel der Generizität brauchen wir Wrapper klassen.
            //- In Java können keine primitiven Datentypen in dem Konzept der Generics genommen werden.
            //- Nur Referenztypen (Klassen mit Objekten) sind erlaubt.
            // Für jeden primitiven Datentyp braucht man also eine Stellvertreterklasse auch Wrapperklasse genannt.
class WrapperKlassen {

    // Boolean bo1 = new Boolean(true);
    Boolean bo = Boolean.TRUE;

    // Character ch1 = new Character('?');
    Character ch = '?';

    // Byte by = new Byte(123);
    Byte by1 = (byte) 100;
    // Byte by2 = new Byte(String.valueOf(100));

    // Short sh = new Short(-12345);
    Short sh1 = (short) -12345;
    // Short sh2 = new Short(String.valueOf(-12345));

    // Integer in = new Integer(12345678);
    Integer in = 12345678;                                      // BOXING

    // Long lo = new Long(45678901234);
    Long lo = 45678901234L;

    // Float fl = new Float(3.14);
    Float fl = (float) 3.14;

    // Double dou = new Double(2.71E17);
    Double dou = 2.71E17;

    public WrapperKlassen () {
        System.out.println(bo);
        System.out.println(bo.booleanValue());
        System.out.println(ch);
        System.out.println(by1);
        // System.out.println(by2);
        System.out.println(sh1);
        // System.out.println(sh2);
        System.out.println(in);                                  // UNBOXING
        System.out.println(in.intValue());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(lo);
        System.out.println(fl);
        System.out.println(dou);
    }

    public Integer m () {return 1;}                              // Integer in = new Integer (1); macht Compailer automatisch
}

// Typparameter:
            //- Typparameter sind Platzhalter für Referenztypen
            //- Typparameter sind Klassen,Arraytypen od Interfaces
            //- Bei primitiven Datentypen nimmt man die stellvertretenden Wrapperklassen
            //- Ein Typparameter kann auch weitere Typparameter enthalten:
            //- Bei Typparametern ist kein Downcast und kein instancoof möglich
class Typparameter {
    // Pair < String, Pair<Integer,Double> > pair7 = new Pair < String, Pair<Integer,Double> > ( s, pair5 );
}

// Generische Klassen:
            // Zugriffsrechte class name <Typparameter, Typparameter2, ...> {}
class Pair <T1, T2> {
            //- T1 und T2 sind Platzhalter für 2 Referenztypen.
            //- Klasse GenerischeKlassen ist generisch, sie ist mit T1 und T2 parametrisiert.
            //- T1 und T2 sind Typparameter der Klasse GenerischeKlassen.
            //- Erst bei der Einrichtung von Variablen und Objekten der Klasse werden T1 und T2 festgelegt.
            //- Der Vorteil ist, dass man Methoden, Attribute, Listen etc mit Datentyp T erstellen kann und erst beim Einrichten eines Objekt, dass die Methode etc aufruft sich für einen Datentyp entscheiden muss.

            //- Durch den Typparameter T1, können Objekte von Pair unterschiedliche Attributtypen haben.
            //- Ebenso können Rückgabetypen von Methoden generische Typen haben.
    private T1 attribute1;
    private T2 attribute2;

    public Pair (T1 a1, T2 a2) {
        this.attribute1 = a1;
        this.attribute2 = a2;
    }

    public T1 getAttribute1() {
        return attribute1;
    }
    public void setAttribute1(T1 attribute1) {
        this.attribute1 = attribute1;
    }
    public T2 getAttribute2() {
        return attribute2;
    }
    public void setAttribute2(T2 attribute2) {
        this.attribute2 = attribute2;
    }

    public void PairImpl () {
        Integer i = 123;
        Double d = 3.14;
        Pair < Integer, Double > pair = new Pair <> (i,d);
        Integer i1 = pair.getAttribute1();                      //- So können die Methoden aufgerufen werden
        System.out.println(i1.intValue());
        System.out.println(pair.getAttribute1());
        Integer i2 = 234;
        pair.setAttribute1(i2);

        Pair < Integer, Integer > pair1 = new Pair <> (i,i2);   //- Es hätten auch beide Typparameter mit dem gleichen Typ instanziiert werden können -> Pair<Integer, Integer>
        System.out.println(pair1.getAttribute2());
    }
}

// Generische Methoden:
            // Zugriffsrechte <Typparameter1, Typparameter2, ...> Rückgabetyp<Typparameter1, Typparameter2, ...> name (formaler Parameter) {}
            //- Es müssen nicht immer ganze Klassen generisch sein.
            //- Es können auch einzelne Methoden generisch sein.
class Pair1<T1, T2> {

    private T1 attribute1;
    private T2 attribute2;
    public Pair1 (T1 a1, T2 a2) {
        this.attribute1 = a1;
        this.attribute2 = a2;
    }

    public Pair1 () {}

           //- <T1, T2> der Methode makePair ist der Typparameter der Methode.
           //- Pair1<T1, T2> ist der Rückgabetyp.
           //-> Die Methode erstellt ein neues Pair1 Objekt
    public <T1, T2> Pair1<T1, T2> makePair (T1 t1, T2 t2) {
        return new Pair1<>(t1, t2);
    }

    public T1 getAttribute1() {
        return attribute1;
    }
    public void setAttribute1(T1 attribute1) {
        this.attribute1 = attribute1;
    }
    public T2 getAttribute2() {
        return attribute2;
    }
    public void setAttribute2(T2 attribute2) {
        this.attribute2 = attribute2;
    }

    //- So wird die Methode verwendet.
    //- Die Typparameter werden durch A und B instanziiert und es wird jeweils ein Objekt davon für den Parameter erschaffen.
    //- Es kann auch sein, dass Klasse und Methode zwei unterschiedliche Typparameter besitzen.
    public void makePair1 () {
        Pair1<T1, T2> pair1 = new Pair1<>();
        Pair1<A,B> pair11 = pair1.makePair(new A(), new B());
    }
}

// Eingeschränkter Typparameter:
            //- Wenn eine Klasse bestimmte Methoden übernehmen soll, muss man den Typparameter beschränken.
            //- In diesem Beispiel darf man alle Typen von in(direkt) erbenden Klassen von X(Integer) verwenden, sowie X(Integer) selbst.
            //- Dadurch kann man mit einem Objekt des Typs alle Methoden von X aufrufen.
class TypparameterEingeschraenkter1 < T extends Integer > {}
            //- In diesem Bespiel muss die Klasse von X(Integer) abgeleitet sein und die Interfaces 1,2 und 3 implementieren.
class TypparameterEingeschraenkter2 < T extends Integer & Int1 & Int2 & Int3 > {}
interface Int1 {}
interface Int2 {}
interface Int3 {}

// Wildcards:
            // public double m ( X<? extends Number> n ) {}
                        //- Mit Fragezeichen und extends vor dem Typ Number wird festgelegt, dass der Typ des Parameters n entweder Number oder abgeleitet von Number sein muss bspw. Die Wrapper Klassen
                        //- Bei wildcards ist die Methode nicht generisch
                        //- Nur einzelne Parameter der Methode sind generisch
            // public String m ( X<?> obj ) {}
                        //- Auch ein einzelnes Fragezeichen ist möglich, dann ist der Typ „extends object“, also nur von Object abgeleitete Klassen
                        //-> Durch ? extends ... wird also ein Hirarchielimit nach oben gesetzt – nur erbenden Klassen. Werte dürfen nur gelesen werden, aber nicht überschrieben.
                        //-> Durch ? super ... kann man ein Hirarchielimit nach unten setzen – nur Basisklassen, Interfaces. Werte dürfen nur überschrieben werden, aber nicht gelesen.
class A {}
class B {}

// Comperator:

// Iterator:
            //- Zu jeder Klasse, die das Interface Collection implementiert, gibt es eine eigene Iterator-Klasse, die das generische Interface Iterator implementiert.
            //- Dieses Interface können wir daher zum formalen Parameter jedes Iterators machen.

            // Iterator<Typparameter> iteratorname = liste.iterator ();
            // Iterator<Number> it1 = c1.iterator ();
            //- Der Iterator geht die einzelnen Listenelemente durch und startet vor dem ersten.

            //- mit it1.next() kann man das erste Element der Liste aufrufen.
            //- mit der boolschen Methode .hasNext(), kann man die gesamte Liste durchlaufen.
            // while ( it1.hasNext() )
            //          System.out.print ( it1.next().doubleValue() );

            // Kurzform Forschleife Iterator:
            //- Für Iteratoren gibt es eine besondere Kurzschreibweise der forSchleife.
                        // for ( ein neus Objekt des Typparameters der Liste : name der liste )     System.out.print ( Objekt );
                        // for ( String str : coll )                                                System.out.print ( str );

// Collections: (interface)
            //- Collections sind Sammlungen von Objekten eines bestimmten Typs, der als generischer Typparameter offengehalten ist.
            //- Alle Collection Klassen implementieren das Interface Collection, nicht zu verwechseln mit Klasse Collections.
            //- Das Interface List erweitert Collection.
            //- Beispiele für Collectionklassen sind: Vector, LinkedList, ArrayList, TreeSet, HashSet
            //- Alle haben andere Vorteile.
// Methoden des Interfaces Collection, das alle Colletions implementieren.
            // add(Object) -> fügt ein Objekt als Element in die Liste ein
            // addAll(andere Collection) -> fügt alle Elemente einer anderen Collection in die Collection
            // size -> gibt als int die Anzahl der Elemente zurück.
            // isEmpty -> liefert true zurück, wenn size 0 ist.
            // contains(Object) -> gibt boolsch an ob das Objekt Element der Collection ist (oder ein identischer Wert). (geht auch mit null)
            // containsall(andere Collection) -> prüft ob alle Elemente einer anderen Collection in der Collection sind.
            // clear -> leert die gesamte Collection.
            // remove(Object) -> liefert true zurück, wenn das Element vorkommt und entfernt es.
class CollectionsIteratorImpl {
    public CollectionsIteratorImpl () {

        // ArrayList:
        Collection<Number> c1 = new ArrayList<>();
                //- Interface Collection als statischer Typ, der mit Klasse Number instanziiert wird.
                //- ArrayList ist der dynamische Typ.
                //- Objekt c1 wird erschaffen.
                //- Der leere Konstruktor erstellt eine leere Sammlung von Elementen.

        for ( int i=0; i<100; i++ ) {
            c1.add (i);
        }
                //- So wird die ArrayList mit Zahlen von 1 bis 100 gefüllt.
                //- Füllmethode: Collectionname.add(Element);
                //- Man kann auch sowohl Integer, als auch Double und Float in eine Collection packen.
                //- Collections die nur Collections implementieren, haben keine Reihenfolge, wie eine Menge.

        Iterator<Number> it1 = c1.iterator();
        while ( it1.hasNext() ) {
            System.out.print ( it1.next().doubleValue() );
        }
    }

    public boolean containsNull (Collection<? extends Number> coll) {
        return coll.contains(null);
    }
                //- Der aktuale Parameter muss eine Collection sein, deren Inhalt von Number erbt (z.B. eine int-Collection).
                //- Es wird nur lesend auf die Liste zugegriffen.
                //- Alles was in dem Methodenrumpf steht muss auch für Number möglich sein.
    // Dies nennt man In-Parameter.

    public void addPi (Collection<? super Double> coll) {
        coll.add(Math.PI);
    }
                //- Der aktuale Parameter muss eine Collection sein, deren Inhalt eine Basisklasse von Double ist (z.B. eine int-Collection).
                //- Es wird nur schreibend auf die Liste zugegriffen.
    // Dies nennt man Out-Parameter.


    // LinkedList:
                // public void processAll (Consumer<T> consumer) {
                //     for (ListItem<T> p = head; p != null; p = p.next) {
                //          consumer.accept(p.key);
                //     }
                // }

}
//
// List: (interface)
            //- Das Interface List erweitert ds Interface Collection.
            //- Alle Collections, die das Interface List implementieren haben eine Rangfolge mit Index.
            //- Die Elemete können wie bei einem Array über einen Index angesprochen werden.
            //- Der Index wird Position genannt.
// Methoden des Interfaces List, das einige Colletions implementieren
            // indexOf(Object) -> liefert den Index des ersten vorkommens zurück, wenn nicht, dann -1.
            // set(Index, Object) -> der Wert der an der Stelle war wird durch den Eingabewert ersetzt und zurückgegeben.
            // add(Index, Object) -> setzt einen Wert an die Stelle des Parameters und verschiebt, alles was danach kommt einen Platz nach hinten.
            // get(Index) -> liefert Element am Index zurück.


// Listen von Lambda-Ausdrücken:

// ListItem:
            // ListItem ist ein Item, dass sich mit anderen Items verketten lässt, wie eine Kette deren Glieder man nur über einen Durchlauf der vorigen Glieder abfragen kann.
            // Sie startet mit einem head und endet mit einem tail.
// Inhalt des ListItem:
            // ListItem:                    ListItem<T> current = new ListItem<T>();
            // Wert eines Elements:         current.key
            // Wert eines Elements vgl:     current.key.equals(param);
            // Anfangselement:              ListItem<T> head;           // current.next = head;
            // Schlusselement:              ListItem<U> tail;
            // darauffolgender Wert:        current.next
            // Abbruchbedingung:            current.next = null;
            // Durchlaufschleife:           for( ListItem<T> p = head; p!= null; p = p.next ){}
            // Neues Listenelement (vorne):
                        // 1. Erstellen:                            ListItem<T> tmp = new ListItem<T>();
                        // 2. Key bestimmen:                        tmp.key = key;
                        // 3. vor das erste Glied (head) hängen:    tmp.next = head;
                        // 4. als erstes Glied (head) benennen:     head = tmp;
            // Neues Listenelement (mitte):
                        // 1. Erstellen:                                    ListItem<T> tmp = new ListItem<T>();
                        // 2. Listendurchlauf bis dem Glied nachdem es eingefügt werden soll.
                        // 3. Key bestimmen:                                tmp.key = key;
                        // 4. vor das nächste Glied (p.next) hängen:        tmp.next = p.next;
                        //              ( p und tmp sind noch nicht verbunden, aber beide sind mit p.next verbunden )
                        // 5. hinter das p Glied hängen:                    p.next = tmp;
                        //              (nun wurde das Glied zwischen rein geschoben und erst vorne, dann hinten verbunden)



