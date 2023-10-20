package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_SIZE = 3;
    private static final String INPUT_RESTART = "1";
    private static final String INPUT_NUMBER_FORMAT = "[1-9]{3}";
    private static final String INPUT_CHOICE_FORMAT = "[1|2]";

    public static void main(String[] args) {

        PrintResult.START.printMessage();

        String choiceOfUser = INPUT_RESTART;
        while (choiceOfUser.equals(INPUT_RESTART)) {

            List<Integer> computer = makeRandomNumber();

            boolean isAnswer = false;
            while (!isAnswer) {
                PrintResult.WRITE.printMessage();

                String input = Console.readLine();
                validateInputNumber(input);

                List<Integer> user = changeStringToList(input);

                isAnswer = compare(computer, user);
            }
            choiceOfUser = Console.readLine();
            validateInputChoice(choiceOfUser);
        }
    }

    private static List<Integer> changeStringToList(String input) {
        List<Integer> user = new ArrayList<>();
        for (String splitInput : input.split("")) {
            user.add(Integer.parseInt(splitInput));
        }
        return user;
    }

    private static void validateInputNumber(String input) {
        if (!input.matches(INPUT_NUMBER_FORMAT)) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) == input.charAt(1)) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(2) == input.charAt(0)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputChoice(String choice) {
        if (!choice.matches(INPUT_CHOICE_FORMAT)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean compare(List<Integer> computer, List<Integer> user) {

        int ball = 0;
        int strike = 0;

        for (int computerIndex = 0; computerIndex < 3; computerIndex++) {
            Integer computerNumber = computer.get(computerIndex);
            if (!user.contains(computerNumber)) {
                continue;
            }
            if (user.indexOf(computerNumber) == computerIndex) {
                strike += 1;
                continue;
            }
            ball += 1;
        }
        return printResult(ball, strike);
    }

    private static boolean printResult(int ball, int strike) {

        if (ball == 0 && strike == 0) {
            PrintResult.NOTHING.printMessage();
            return false;
        }
        if (strike == NUMBER_SIZE) {
            PrintResult.STRIKE.printMessage(strike);
            PrintResult.CORRECT.printMessage();
            PrintResult.NEXT.printMessage();
            return true;
        }
        if (ball == 0) {
            PrintResult.STRIKE.printMessage(strike);
            return false;
        }
        if (strike == 0) {
            PrintResult.BALL.printMessage(ball);
            return false;
        }
        PrintResult.BOTH.printMessage(ball, strike);
        return false;
    }
}
