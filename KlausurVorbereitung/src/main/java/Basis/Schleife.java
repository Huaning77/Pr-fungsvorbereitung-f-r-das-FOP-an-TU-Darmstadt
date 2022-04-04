package Basis;

import java.util.Calendar;

class ForSchleife {

    int[] i1 = new int[5];

    // For-Schleife:
    public ForSchleife () {

        // for ( Initialisierung eines integers meist 0; Anzahl der Durchläufe; Erhöhung des Integers pro Durchlauf ) {Anweisung}
        for( int i = 0; i < 5; i++ ) {
            i1[i] = i;
        }

        // Verkürzte For-Schleife:
        // for ( Datentyp name : Arrayname ) {Anweisung}
                // Der name wird den Komponenten in den einzelnen Durchläufen übergeben.
                // Mit der verkürzten for schleife kann man die Komponenten eines Arrays nach aufsteigenden Indizes durchlaufen lassen.
        for ( int n : i1 ) {
            System.out.println(n);  // 0,1,2,3,4
        }

        // Verschachtelte For-Schleife:
        // for (int i=0; i<2; i++ ) {
        //      for (int i=0; i<4; i++) {
        //           myRobot.putCoin();
        //           myRobot.move();
        //      }
        //      myRobot.turnLeft();
        //      myRobot.move();
        //      myRobot.turnLeft();
        // }
        // -> viermal wird innere Anweisung ausgeführt, dann einmal äußere, dann wieder 4 mal innere... So wird ein 2x4 Rechteck gefüllt.
    }
}

class WhileSchleife {
    boolean b = true;
    boolean c = true;
    int i;

    public WhileSchleife () {
        // while ( boolsche Bedingung, meist Methode() ) {Anweisung}
                // Mit while-Schleifen können Anweisungen solange hintereinander ausgeführt werden, wie die Bedingung erfüllt ist
        while (b & c) {
            i = 1;
            b = false;
            c = false;
        }
    }
}

class DoWhileSchleife {
    boolean b = true;
    boolean c = true;
    int i;

    public DoWhileSchleife () {
        // do {Anweisung} while (boolsche Bedingung, meist Methode());
                // while-Schleifen, bei der Anweisung mind. einmal ausgeführt wird.
        do {
            i++;
            b = false;
            c = false;
        }
        while (b && c);
    }
}

class BreakUndContinue {
    // break;
            // wird in Schleifen verwendet, um direkt ans Ende der Schleife zu springen
    // continue;
            // Wird in Schleifen verwendet, um den Schleifendurchlauf abzubrechen und an den Anfang der Schleife zu springen
}

class IfAnweisung {
    boolean a = true;
    int i = 0;

    public IfAnweisung () {
        // if(boolsche Bedingung) {Anweisung}
                // Anweisung wird einmalig ausgeführt, wenn boolsche Bedingung true zurückliefert
        if (a) {
            a = false;
            i++;
        }
    }
}

class Array1 {

    public Array1 () {}

    // Deklarierung eines Arrays: Variable des typs Array wird erstellt
            // Datentyp[] Name = new Datentyp[länge];
    int[] is = new int[5];

    public void ForSchleife () {
    // Länge eines Arrays:
            // name.length
        for (int i = 0; i < is.length; i++) {

    // Initialisierung eines Arrays:
            // Name [0] = new Datentyp(Konstruktor);
            is[i] = i;
        }
    }

    // Basis.Methoden mit Arrays ausführen:
    //          for ( int j = 0; j < robots.length; j++ ) {
    //                  robots[j].putCoin();
    //                  robots[j].move();
    //          }

    // zweidimensionales Arrays:
            // Wenn der Komponententyp eines Arrays ein „Array von ...“ ist, so spricht man von einem zweidimensionalem Array.
    double[ ][ ] a = new double [3][2];
    public double[][] ArrayInitializer1 (double[ ][ ] a) {
        for (int i=0; i<3; i++ ) {
            for (int l=0; l<2; l++) {
                a[i][l] = l;
            }
        }
        return a;
    }

    public double[][] ArrayInitializer2 (double[ ][ ] a) {
        a[1][1] = 3.14;
        a[2][1] = 5 * a[1][1];
        return a;
    }
}

class SwitchAnweisung {

    public SwitchAnweisung () {}

    // switch (ganzzahliger Typ, Enum oder String){
    //          case ...Typ,Enum,String... :
    //                  ...
    //                  break;
    //
    //          case ... Typ,Enum,String...:
    //                  ...
    //                  break;
    //          default:
    //                  ...
    //  }

    /**
    Calendar month = Calendar.getInstance();
    public void showTheSpecial (Calendar month) {
        switch (month) {
            case Calendar.JANUARY:
                System.out.println("It's ski season!");
                break;
            case Calendar.FEBRUARY:
                System.out.println ("Winter depression...");
                break;
            case Calendar.MARCH:
                System.out.println("It's March!");
                break;
            case Calendar.APRIL:
                System.out.println ("It's April!");
                break;
            case Calendar.MAY:
                System.out.println("It's May!");
                break;
            case Calendar.JUNE:
                System.out.println ("It's June!");
                break;
            case Calendar.JULY:
                System.out.println("It's July!");
                break;
            case Calendar.AUGUST:
                System.out.println ("It's August!");
                break;
            case Calendar.SEPTEMBER:
                System.out.println("It's September!");
                break;
            case Calendar.OCTOBER:
                System.out.println ("It's October!");
                break;
            case Calendar.NOVEMBER:
                System.out.println("It's November!");
                break;
            case Calendar.DECEMBER:
                System.out.println ("It's December!");
                break;
            default:
                break;
        }
     }
     **/

    public void showTheSpecial1 (int i) {
        switch (i) {
            case Calendar.JANUARY:
                System.out.println("It's ski season!");
                break;
            case Calendar.FEBRUARY:
                System.out.println ("Winter depression...");
                break;
            case Calendar.MARCH:
                System.out.println("It's March!");
                break;
            case Calendar.APRIL:
                System.out.println ("It's April!");
                break;
            case Calendar.MAY:
                System.out.println("It's May!");
                break;
            case Calendar.JUNE:
                System.out.println ("It's June!");
                break;
            case Calendar.JULY:
                System.out.println("It's July!");
                break;
            case Calendar.AUGUST:
                System.out.println ("It's August!");
                break;
            case Calendar.SEPTEMBER:
                System.out.println("It's September!");
                break;
            case Calendar.OCTOBER:
                System.out.println ("It's October!");
                break;
            case Calendar.NOVEMBER:
                System.out.println("It's November!");
                break;
            case Calendar.DECEMBER:
                System.out.println ("It's December!");
                break;
            default:
                System.out.println ("???");
                break;
        }
    }

    public void showTheSpecial2 (int i) {
        switch (i) {
            case Calendar.JANUARY -> System.out.println("It's ski season!");
            case Calendar.FEBRUARY -> System.out.println("Winter depression...");
            case Calendar.MARCH -> System.out.println("It's March!");
            case Calendar.APRIL -> System.out.println("It's April!");
            case Calendar.MAY -> System.out.println("It's May!");
            case Calendar.JUNE -> System.out.println("It's June!");
            case Calendar.JULY -> System.out.println("It's July!");
            case Calendar.AUGUST -> System.out.println("It's August!");
            case Calendar.SEPTEMBER -> System.out.println("It's September!");
            case Calendar.OCTOBER -> System.out.println("It's October!");
            case Calendar.NOVEMBER -> System.out.println("It's November!");
            case Calendar.DECEMBER -> System.out.println("It's December!");
            default -> System.out.println("???");
        }
    }
}

class Bedingungsoperator {

    // Datentyp name = boolscherAusdruck ? Wert1 : Wert 2;
                // Mit einem Basis.Bedingungsoperator kann man 2 Möglichkeiten definieren.
                // Bspw. 2 verschiedene int Werte speichern, je nach boolschem Wert.
                // Hier wird bei true der Wert 1 gespeichert, ansonsten 3.
    public Bedingungsoperator () {}
    String s;
    public String bO (int i) {
        return s = i == 8 ? "The integer is 8!" : "The integer is 8?";
    }
}