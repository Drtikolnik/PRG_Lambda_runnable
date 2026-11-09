package lambdy.dil03_funkcinalni_rozhrani;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

public class Lekce03 {
    public static void main(String[] args) {
        // Odkomentuj prave jedno volani podle pracovniho snimku.
        // Prvni spusteni je bez vypisu; zatim neni zapnuta zadna uloha.
        // ukazkaConsumer();
        // ukazkaPredikaty();
        // ukazkaSupplier();
        consumer();
        interval();
        transformace();
        // dodavatele();
        // pozdrav();
        // jmena();
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaConsumer() {
        Consumer<String> print = tex ->{
            System.out.println(tex);
        };
        print.accept("Java");

        Consumer<String> length = s -> System.out.println(s.length());
        Consumer<String> both = print.andThen(length);


        System.out.println("=============");
        both.accept("Java");
        both.accept("");
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaPredikaty() {

        //otazka a odpoved
        Predicate<Integer> positive = n -> n > 0;
        Predicate<Integer> even = n -> n % 2 == 0;
        System.out.println(positive.test(-5));
        System.out.println(even.test(0));

        //skladani podminek
        Predicate<Integer> positiveEven = positive.and(even);
        Predicate<Integer> positiveOrEven = positive.or(even);
        System.out.println(positiveEven.test(4));
        System.out.println(positiveEven.test(3));
        System.out.println(positiveOrEven.test(-2));

        //negace a rovnost
        Predicate<Integer> odd = even.negate();
        Predicate<Integer> odd2 = Predicate.not(even);
        Predicate<String> isJava = Predicate.isEqual("Java");
        System.out.println(odd.test(3));
        System.out.println(odd2.test(4));
        System.out.println(isJava.test("java"));

        //delka a retezce
        Predicate<String> longerThan5 = s -> s.length() > 5;
        Predicate<String> shorterThan10 = s -> s.length() < 10;
        Predicate<String> suitable = longerThan5.and(shorterThan10);
        System.out.println(suitable.test("Lambda")); // true
        System.out.println(suitable.test("Functional")); // false


    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaSupplier() {
        Supplier<Double> random = () -> Math.random();
        double a = random.get();
        double b = random.get();
        System.out.println(a);
        System.out.println(b);
    }

    // Uloha 3.1. Čtyři řádky: Java, 4, prázdný řádek, 0.
    static void consumer() {
        // TODO 3.1: Consumer. Zde pis sve reseni.
        Consumer<String> print = tex ->{
            System.out.println(tex);
        };

        print.accept("Java");

        Consumer<String> length = s -> System.out.println(s.length());
        Consumer<String> both = print.andThen(length);


        System.out.println("=============");
        both.accept("Java");
        both.accept("");
    }

    // Uloha 3.2. inRange: false, true, true, false. outside má vždy opačný výsledek.
    static void interval() {
        int[] values = {10, 11, 100, 101};

        Predicate<Integer> above10 = n-> n>10;
        Predicate<Integer> atMost100 = n-> n<=100;
        Predicate<Integer> inRange =  above10.and(atMost100);
        Predicate<Integer> outside =  above10.and(atMost100).negate();



        for (int n=0; n<values.length; n++) {
            System.out.print(inRange.test(values[n])+ " ");
        }
    }

    // Uloha 3.3. Vysledek: JAVA / Vysledek: s koncovou mezerou / Java.
    static void transformace() {
        Function<String, String> trim = s -> s.strip();
        Function<String, String> upper = s -> s.toUpperCase(Locale.ROOT);
        Function<String, String> lower = s -> s.toLowerCase(Locale.ROOT);
        Function<String, String> prefix = s -> "Vysledek: " + s;

        Function<String, String> all = trim.andThen(upper).andThen(lower.andThen(prefix));
        Function<String, String> same = Function.identity();
        System.out.println(all.apply(" java "));
        System.out.println(all.apply("  "));
        System.out.println(same.apply(" Java "));
// Vysledek: JAVA




    }

    // Uloha 3.4. Pevné testy: vyborne, nedostatecne, 09:05. Náhodná známka i aktuální čas se mění.
    static void dodavatele() {
        IntFunction<String> describe = grade -> switch (grade){
            case 1 -> "vyborne";
            case 2 -> "chvalitebne";
            case 3 -> "dobre";
            case 4 -> "dostatecne";
            case 5 -> "nedostatecne";
            default -> throw new IllegalStateException("znamka");
        };
        System.out.println(describe.apply(1));
        System.out.println(describe.apply(5));
        Supplier<String> grade = () -> describe.apply(1+(int)(Math.random()*5));
        System.out.println(grade.get());

        DateTimeFormatter hhmm = DateTimeFormatter.ofPattern("HH:mm");
        Supplier<String> time = () -> LocalTime.now().format(hhmm);
        System.out.println(time.get());
        System.out.println(LocalTime.of(9, 5).format(hhmm));


    }

    // Uloha 3.5. Celkem tři řádky Ahoj; volání s nulou nic nepřidá.
    static void pozdrav() {
        // TODO 3.5: Vlastní Greeting. Zde pis sve reseni.
    }

    // Uloha 3.6. Výpis ADAM a ALENA. Pro prázdný seznam žádný výpis.
    static void jmena() {
        List<String> names = List.of("Eva", "", "Adam", "Alena");
        // TODO 3.6: Zpracování jmen. Zde pis sve reseni.
    }
}
