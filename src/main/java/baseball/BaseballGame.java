package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import constant.Message;
import constant.Numeric;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int strike = 0, ball = 0;
    Validator validator = new Validator();

    protected void startSystem() {
        sayStart();
        runGames();
    }

    private void runGames() {
        runOneGame();
        if (determineRestart()) {
            runGames();
        }
    }

    private void runOneGame() {
        setBallStrikeZero();
        List<Integer> computer = getRandomThreeNum();
        while (strike != Numeric.NUMBER_OF_INPUT) {
            runOneRound(computer);
        }
        sayEndGame();
    }

    private void runOneRound(List<Integer> computer) {
        setBallStrikeZero();
        List<Integer> user = getThreeNum();
        calculateBallStrike(user, computer);
        sayBallStrike(ball, strike);
    }

    private void sayStart() {
        System.out.println(Message.START_SYSTEM_MESSAGE);
    }

    private void setBallStrikeZero() {
        ball = 0;
        strike = 0;
    }

    private List<Integer> getRandomThreeNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Numeric.NUMBER_OF_INPUT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<Integer> getThreeNum() throws IllegalArgumentException {
        List<Integer> user = new ArrayList<>();
        System.out.print(Message.REQUIRE_NUMBER_MESSAGE);
        String input = Console.readLine();
        validator.validateStringLength(input);
        for (int i = 0; i < Numeric.NUMBER_OF_INPUT; i++) {
            char charValue = input.charAt(i);
            Integer intValue = charValue - '0';
            validator.validateNumberRange(intValue);
            validator.validateDuplicateNumbers(user, intValue);
            user.add(intValue);
        }
        return user;
    }

    private void calculateBallStrike(List<Integer> user, List<Integer> computer) {
        setBallStrikeZero();
        for (int i = 0; i < user.size(); i++) {
            int number = user.get(i);
            determineBallOrStrike(number, i, computer);
        }
    }

    private void determineBallOrStrike(Integer number, int i, List<Integer> computer) {
        for (int j = 0; j < Numeric.NUMBER_OF_INPUT; j++) {
            Integer numberInList = computer.get(j);
            if (number.equals(numberInList) && i == j) {
                strike += 1;
                break;
            } else if (number.equals(numberInList) && i != j) {
                ball += 1;
                break;
            }
        }
    }

    private void sayBallStrike(int ball, int strike) {
        // else 사용 X
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        } else if (ball != 0 && strike == 0) {
            System.out.printf("%d볼", ball);
        } else if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크", strike);
        } else if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        System.out.println();
    }

    private void sayEndGame() {
        System.out.printf(Message.END_GAME_MESSAGE);
    }

    private Boolean determineRestart() throws IllegalArgumentException {
        System.out.println(Message.ASK_RESTART_MESSAGE);
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
