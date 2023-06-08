package lab5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMethods {
    public static double averageValue(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static List<String> toUpperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .map(string -> "_new_" + string)
                .toList();
    }

    public static List<Integer> getListOfSquares(List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(val -> val.getKey() * val.getKey())
                .toList();
    }

    public static List<String> getStringStartsWith(Collection<String> collection, char letter) {
        return collection.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == letter)
                .sorted()
                .toList();
    }

    public static <T> T getLastElement(Collection<T> collection) throws Exception {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(Exception::new);
    }

    public static int getEvenSum(int[] list) {
        return Arrays.stream(list)
                .filter(i -> (i & 1) == 0)
                .sum();
    }

    public static Map<Character, String> getListOfMaps(List<String> list) {
        return list.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toMap(k -> k.charAt(0), v -> v.substring(1)));
    }
}
