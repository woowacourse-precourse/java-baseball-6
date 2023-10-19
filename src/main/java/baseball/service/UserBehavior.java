package baseball.service;

import exception.CheckException;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static constant.Constant.*;

public class UserBehavior {
    private CheckException checkException = new CheckException();
    private Output output = new Output();
    private final List<Integer> computerNumbers;
    private int strike;
    private int ball;

    public UserBehavior(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;

    }

    public int input() {
        try {
            String inputNumbers[] = setStart();
            checkException.checkAll(inputNumbers);
            countResult(inputNumbers);
            while (result()) {
                output.printFin();
                return Integer.parseInt(Console.readLine());
            }
            return input();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private String[] setStart() {
        strike = 0;
        ball = 0;
        output.printGameStart();
        return Console.readLine().split(SPLIT);
    }

    private void countResult(String[] inputNumbers) {
        int first = Integer.parseInt(inputNumbers[0]);
        check(0, first);
        int second = Integer.parseInt(inputNumbers[1]);
        check(1, second);
        int third = Integer.parseInt(inputNumbers[2]);
        check(2, third);
    }

    private void check(int index, int number) {
        if (computerNumbers.get(index) == number) {
            strike++;
            return;
        }
        if (computerNumbers.contains(number))
            ball++;
    }

    private boolean result() {
        if (strike == LENGTH) {
            output.printResult(strike+STRIKE);
            return true;
        }
        String message = "";
        if (ball > 0)
            message += ball+BALL + " ";
        if (strike > 0)
            message += strike+STRIKE;
        if (message.equals(""))
            message += NOTHING;
        output.printResult(message);
        return false;
    }
}
