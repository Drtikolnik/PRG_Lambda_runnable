package lambdy.dil05;

import java.util.ArrayList;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lekce05 {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Podle snímku odkomentuj právě jedno volání.
        ukazkaLimit();
        ukazkaSeznam();
        zachyceni(); // 5.1
        soucet(); // 5.2
        propojeni(); // 5.3, rozšiřující
    }

    // Ukázka zachycení limitu.
    static void ukazkaLimit() {
        final int limit = 10;
        Runnable r = () -> System.out.println(limit);
        r.run();

    }

    // Ukázka změny obsahu seznamu.
    static void ukazkaSeznam() {
        List<String> names = new ArrayList<>();

        Runnable read = () -> System.out.println(names);
        names.add("Eva");
        names.add("Adam");
        read.run();
    }

    // Úloha 5.1. Výstup 2.
    static void zachyceni() {


        //A
        int x = 1;
        Runnable a = () -> System.out.println(x);
        a.run();

        //B
        int changing = 1;
        changing++;
        final int snapshot =  changing;
        Runnable b = () -> System.out.println(snapshot);
        changing++;
        b.run();

    }

    // Úloha 5.2. Pro [1, 2, 3] výstup 6. Pro [] výstup 0.
    static void soucet() {
        List<Integer> numbers = List.of(1, 2, 3);

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);

    }

    // Rozšiřující úloha 5.3. Výstup Adam a Alena na dvou řádcích.
    static void propojeni() {
        List<String> names = List.of("Eva", "", "Adam", "Alena");
        String prefix = "A";

        Predicate<String> startsWithPrefix = s -> s.startsWith(prefix);
        Function<String, Student> studentFactory = Student::new;
        Supplier<List<Student>> listFactory = ArrayList::new;
        Consumer<Student> print = s -> System.out.println(s.getName());
        List<Student> selected = listFactory.get();

        for (String name : names) {

            if (startsWithPrefix.test(name)) {
                Student student = studentFactory.apply(name);
                selected.add(student);
                print.accept(student);

            }

        }



    }
}