package baseball.func;

import camp.nextstep.edu.missionutils.Console;

public class MakePlayerNumber {
    public int[] getPlayerNumber() {
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String userInput = Console.readLine();

            if (isValidInput(userInput)) {
                int[] userArray = new int[3];
                for (int i = 0; i < 3; i++) {
                    userArray[i] = Character.getNumericValue(userInput.charAt(i));
                }
                return userArray;
            } else {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 3자리 서로 다른 숫자를 입력하세요.");
            }
        }
    }

    private boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) || input.chars().filter(ch -> ch == c).count() != 1) {
                return false;
            }
        }
        return true;
    }
}
