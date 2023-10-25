package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;
    private static final String INPUT_RESTART = "1";
    private static final String INPUT_NUMBER_FORMAT = "[1-9]{3}";
    private static final String INPUT_CHOICE_FORMAT = "[1|2]";

    public static void main(String[] args) {

        PrintResult.START.printMessage();

        String choiceOfUser = INPUT_RESTART;
        while (choiceOfUser.equals(INPUT_RESTART)) {

            Computer computer = new Computer();

            boolean isAnswer = false;
            while (!isAnswer) {
                PrintResult.WRITE.printMessage();

                String input = Console.readLine();
                validateInputNumber(input);

                User user = new User(input);

                isAnswer = compare(computer, user);
            }
            choiceOfUser = Console.readLine();
            validateInputChoice(choiceOfUser);
        }
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

    private static boolean compare(Computer computer, User user) {

        List<Integer> computerNumber = computer.getNumber();
        List<Integer> userNumber = user.getNumber();

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            Integer oneNumber = computerNumber.get(i);
            if (!userNumber.contains(oneNumber)) {
                continue;
            }
            if (userNumber.indexOf(oneNumber) == i) {
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
