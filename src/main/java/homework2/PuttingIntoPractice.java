package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("Task1");
        transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("Task2");
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .forEach(System.out::println);
        System.out.println("Task3");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(x -> Objects.equals(x.getCity(), "Cambridge"))
                .sorted(Comparator.comparing(Trader::getCity))
                .forEach(System.out::println);
        System.out.println("Task4");
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .forEach(System.out::println);
        System.out.println("Task5");
        boolean task5 = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(x -> Objects.equals(x.getCity(), "Milan"));
        System.out.println(task5);
        System.out.println("Task6");
        int sum = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge")).
                mapToInt(Transaction::getValue).sum();
        System.out.println(sum);
        System.out.println("Task7");
        int max = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.naturalOrder())
                .get();
        System.out.println(max);
        System.out.println("Task8");
        Transaction task8 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get();
        System.out.println(task8);
    }
}
