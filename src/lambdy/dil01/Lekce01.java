package lambdy.dil01;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.*;

public class Lekce01 {
    public static void main(String[] args) {
        // Odkomentuj prave jedno volani podle pracovniho snimku.
        // Prvni spusteni je bez vypisu; zatim neni zapnuta zadna uloha.
        ukazkaRunnable();
        runnablePrinter();
        spojeni();
        kalkulacka();
        // porovnaniDelek();
        // formatovani();
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaRunnable() {
        /*
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Ahoj");
            }
        };
        task.run();
        */
        Runnable task = () -> System.out.println("Ahoj");
        task.run();

        // TODO ukazka: postupuj podle pracovniho snimku.
    }

    // Uloha 1.1. Tři řádky: Welcome, Java a prázdný řádek.
    static void runnablePrinter() {
        Runnable printerTask = () -> System.out.println("Welcome");
        printerTask.run();

        Printer printer = (String text) -> System.out.println(text);
        printer.print("JAVA");
        printer.print("");

    }

    // Uloha 1.2. Výpis AB a B. Prázdný řetězec nezpůsobí chybu.
    static void spojeni() {
        Concatenator concatenator = ( a,  b) -> System.out.println(a + b);
        concatenator.concatenate("modro", "oký");
        concatenator.concatenate("", "");

    }

    // Uloha 1.3. Pro (10, 4): 14, 40, 6. Pro (-2, 0): -2, 0, -2.
    static void kalkulacka() {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        IO.println(add.compute(10, 4));
        IO.println(subtract.compute(10, 4));
        IO.println(multiply.compute(10, 4));
        IO.println(add.compute(-2, 0));
        IO.println(subtract.compute(-2, 0));
        IO.println(multiply.compute(-2, 0));




    }

    // Uloha 1.4. Znaménka výsledků jsou záporné, záporné, nula.
    static void porovnaniDelek() {
        // TODO 1.4: Porovnání délek. Zde pis sve reseni.
    }

    // Uloha 1.5. Pro Tom: Hello, Tom / WELCOME, TOM / User: Tom. Pro prázdné jméno zůstane jen prefix.
    static void formatovani() {
        // TODO 1.5: MessageFormatter. Zde pis sve reseni.
    }
}
