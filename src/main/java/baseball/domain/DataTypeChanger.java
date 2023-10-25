package baseball.domain;

import java.util.ArrayList;
import java.util.List;
public class DataTypeChanger {

    private static final int ALIGN_POSITION = 1;

    public static List<CompareNumber> compareNumberFormat(List<Integer> generatedBall) {
        ArrayList<CompareNumber> compareNumbers = new ArrayList<>();
        generatedBall.forEach(v -> {
            compareNumbers.add(new CompareNumber(compareNumbers.size() + ALIGN_POSITION, v));
        });
        return compareNumbers;
    }

    public static List<CompareNumber> compareStringNumberFormat(List<String> generatedBall) {
        ArrayList<CompareNumber> compareNumbers = new ArrayList<>();
        generatedBall.forEach(v -> {
            compareNumbers.add(new CompareNumber(compareNumbers.size() + ALIGN_POSITION, castInteger(v)));
        });
        return compareNumbers;
    }

    private static int castInteger(String v) {
        return Integer.parseInt(v);
    }

}
