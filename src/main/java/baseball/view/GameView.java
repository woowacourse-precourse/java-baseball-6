package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameView {

    public List<Integer> getPlayerInput() {
        String input = Console.readLine();
        validateGameContinue(input);

        List<Integer> playNumber = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int number = Character.getNumericValue(input.charAt(i));
            playNumber.add(number);
        }
        return playNumber;
    }

    public int gameContinue() {
        String input = Console.readLine();
        validateGameContinue(input);

        return Integer.parseInt(input);
    }

    private void validatePlayNumber(String input) {
        if (!isInteger(input) || !isThreeDigit(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private void validateGameContinue(String input) {
        if (!isInteger(input) || !isOneOrTwo(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private boolean isInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력값입니다.");
        }
        return false;
    }

    private boolean isThreeDigit(String input) {
        int number = Integer.parseInt(input);
        if (number >= 100 && number <= 999) {
            return true;
        }
        return false;
    }

    private boolean isOneOrTwo(String input) {
        int number = Integer.parseInt(input);
        if (number == 1 || number == 2) {
            return true;
        }
        return false;
    }

}
