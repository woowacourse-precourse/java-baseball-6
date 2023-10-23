package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class DataTypeChanger {
    public static List<Integer> mapToInt(List<String> userBalls) {
        return userBalls.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
