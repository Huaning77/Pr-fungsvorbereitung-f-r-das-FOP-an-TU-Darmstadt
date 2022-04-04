package Basis;

class Zugriffsrechte {
}
// Basis.Zugriffsrechte:
            // private:   -nur in der Klasse sichtbar
            // nichts:    -im ganzen Package sichtbar
            // protected: -im ganzen Package und in (in)direkt abgeleiteten Basis.Klassen sichtbar
            // public:    -protected und zusätzlich überall wo das Package importiert wurde.
            //            -Basis.Klassen können nur public, oder nichts sein
            //            -nur eine Klasse, Enumeration etc darf in einer Datei public sein, muss Name der Datei sein.
            // Referenztypen: - noch net gecheckt  ?
            //                - Referenztypen sind Basis.Klassen, Enums, Arraytypen und Interfaces