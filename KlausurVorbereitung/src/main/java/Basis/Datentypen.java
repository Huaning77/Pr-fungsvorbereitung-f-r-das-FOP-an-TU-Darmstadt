package Basis;

// Komplexe Datentypen:
                // Bsp: String.
                            //- Komplexe Datentypen sind Basis.Klassen, Enums und (Interfaces?)
                            //- Selbstgeschriebene Basis.Klassen können als Datentyp genutzt werden
                            //- String ist eine Klasse, die in der Java Standartbibliothek existiert
                            //- Man kann String auch selbst rekonstruieren
class DatentypenKomplex {}
                // String:
                            //- Ist vorgefertigte Klasse in Java
                            //- Ein String ist eine Zeichenkette
                            //- Leere Strings sind auch möglich „“
                // Stringmethoden:
                            //> stringname.length – gibt länge des strings als int zurück.
                            //> stringname.charAt(int) – gibt Zeichen an gewissem Index zurück, als char. (erstes Zeichen hat Index 0)
                            //> stringname.indexOf(char) – gibt Index des ersten Vorkommens eines Zeichens in int an.

// Primitive Datentypen:
                // ganze Zahlen: Bsp. 1; int 7/2=3, da die Nachkommastelle abgeschnitten wird.
                                // integer: 32 bits
                                // byte:     8 bits
                                // short:   16 bits
                                // long:    64 bits
                // logik:
                            // boolean: liefert true oder false zurück
                            // && und, || oder, ! nicht
                // gebrochene Zahlen:
                            // float:
                            // double:
                // Zeichen:
                            // char: einzelne Schriftzeichen Bsp: ‘a‘,‘Z‘,‘1‘,‘?‘ werden intern als Zahlen kodiert
                // Literale:
                            // null: Man kann die Referenz einer Variablen od Konstante auf einen symbolischen Wert null setzen. Es gibt keine Speicheradresse, auf die gezeigt wird
                            // fürt man eine Methode mit null auf oder greift auf es zu, kommt eine Fehlermeldung.
                // Garbage Collector:
                            // Der Gerbage Collector sammelt automatisch Objekte, für die Speicherplatz reserviert ist, die aber nicht mehr angesprochen werden können, um einen Systemabsturz zu verhindern.
                            // Bsp für Objekte, die nicht abgesprochen werden können: while ( true ) X x = new X();
                            // Programm erstellt unzählige neue x Objekte und reserviert, wegen „new“ immer wieder einen neuen Speicherplatz. Die alten Objekte werden nicht entfernt.

// Klasse als Datentyp aufrufen:
                // MyString abc = new MyString();