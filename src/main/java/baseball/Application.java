package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static class Result {
        String message;
        boolean isContinue;

        Result(String message, boolean isContinue) {
            this.message = message;
            this.isContinue = isContinue;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void repeatGame() {

    }

    public static void repeatRound(List<Integer> computer) {

    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        return computer;
    }

    public static Result compareTwoNumber(List<Integer> computer, List<Integer> user) {
        Result result = null;
        return result;
    }

    public static List<Integer> input(int inputLength) {
        List<Integer> user = new ArrayList<>();
        return user;
    }

    public static void output(String outputMessage) {

    }
}
