import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {
        List<Integer> numbers = new ArrayList<>();
        int[] array = {1, 2, 3, 4, -4, -5, 6, 7, 0, 8, 9, -10};

        for (int i = 0; i < 25; i++) {
            numbers.add((int) (Math.random() * 40 - 10));
        }

//        numbers.add(5);
//        numbers.add(1);
//        numbers.add(18);
//        numbers.add(-9);
//        numbers.add(47);
//        numbers.add(12);
        System.out.println("Task 1: ");

        System.out.println("For array");
        System.out.println(IntStream.of(array).average().getAsDouble());
        System.out.println((double) IntStream.of(array).reduce(Integer::sum).getAsInt() / array.length);

        System.out.println("For collection");
        System.out.println(numbers.stream()
                .mapToInt(s -> s)
                .average()
                .getAsDouble()
        );

        System.out.println(numbers.stream()
                .mapToDouble(p -> p)
                .reduce(Double::sum)
                .getAsDouble() / numbers.size()
        );
//---------------------------2----------------------------------------------
        System.out.println("Task 2: ");

        List<Integer> minvalue = new ArrayList<>();
//        for (int i = 0; i < 25; i++) {
//            minvalue.add((int) (Math.random() * 40 - 10));
//        }
        minvalue.add(5);
        minvalue.add(1);
        minvalue.add(18);
        minvalue.add(-9);
        minvalue.add(47);
        minvalue.add(12);

        System.out.println("Arrays");
        System.out.println(IntStream.of(IntStream.of(array).min().getAsInt(),
                IntStream.of(array)
                        .boxed()
                        .collect(Collectors.toList())
                        .indexOf(IntStream.of(array).min().getAsInt()))
                .boxed()
                .collect(Collectors.toList()));

        System.out.println("Collection");
        System.out.println(minvalue.stream().mapToInt(i -> i).min().getAsInt() +
                minvalue.stream()
                        .mapToInt(i -> i)
                        .boxed()
                        .collect(Collectors.toList())
                        .indexOf(minvalue.stream().mapToInt(i -> i).min().getAsInt()));
//---------------------------3----------------------------------------------
        System.out.println("Task 3: ");

        System.out.println(IntStream.of(array).filter(number -> number == 0).count());
//---------------------------4----------------------------------------------
        System.out.println("Task 4: ");

        System.out.println(IntStream.of(array).filter(number -> number > 0).count());
//---------------------------5----------------------------------------------
        System.out.println("Task 5: ");

        int multiplier = 10;
        System.out.println(IntStream.of(array).mapToObj(number -> number * multiplier).collect(Collectors.toList()));
    }
}
