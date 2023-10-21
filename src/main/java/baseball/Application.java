package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void startBaseball() {

    }

    public static List<Integer> createBaseballAnswerNumberList() {
        return new ArrayList<>();
    }

    public static void playBaseball() {
    }

    public static List<Integer> inputBaseballNumberList() {
        String inputString = "";
        validateBaseballNumbers(inputString);
        List<Integer> baseballNumberList = new ArrayList<>();
        return baseballNumberList;
    }

    public static void validateBaseballNumbers(String inputString) {
    }

    public static int[] checkBaseballResult(List<Integer> answerNumberList, List<Integer> inputNumberList) {
        int strike = 0, ball = 0;
        return new int[] {strike, ball};
    }

    public static void printBaseballResult(int[] baseballCount) {
    }
}
