package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        PrintResult.START.printMessage();

        String choiceOfUser = "1";
        while (choiceOfUser.equals("1")) {

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            boolean isAnswer = false;
            while (!isAnswer) {
                PrintResult.WRITE.printMessage();
                String input = Console.readLine();

                if (!input.matches("[1-9]{3}")) {
                    throw new IllegalArgumentException();
                }
                isAnswer = compare(computer, input);
            }
            choiceOfUser = Console.readLine();
        }
    }

    private static boolean compare(List<Integer> computer, String input) {

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            String computerNumber = Integer.toString(computer.get(i));
            if (!input.contains(computerNumber)) {
                continue;
            }
            int indexOfInput = input.indexOf(computerNumber);
            if (indexOfInput == i) {
                strike += 1;
            } else {
                ball += 1;
            }
        }
        return printResult(ball, strike);
    }

    private static boolean printResult(int ball, int strike) {

        if (ball == 0 && strike == 0) {
            PrintResult.NOTHING.printMessage();
            return false;
        }
        if (strike == 3) {
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
