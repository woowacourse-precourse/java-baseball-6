package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataTypeChanger {

    public static List<CompareNumber> compareNumberFormat(List<Integer> generatedBall) {
        ArrayList<CompareNumber> compareNumbers = new ArrayList<>();
        generatedBall.forEach(v -> {
            compareNumbers.add(new CompareNumber(compareNumbers.size() + 1, v));
        });
        return compareNumbers;
    }
    public static List<CompareNumber> compareStringNumberFormat(List<String> generatedBall) {
        ArrayList<CompareNumber> compareNumbers = new ArrayList<>();
        generatedBall.forEach(v -> {
            compareNumbers.add(new CompareNumber(compareNumbers.size() + 1, Integer.parseInt(v)));
        });
        return compareNumbers;
    }

}
