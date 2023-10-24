package baseball;

import java.util.stream.Stream;

public class Util {
    public Util() {
    }

    public static boolean checkForDuplicates(String... array) {
        Long distinctCount = Stream.of(array).distinct().count();
        return array.length != distinctCount;
    }

}
