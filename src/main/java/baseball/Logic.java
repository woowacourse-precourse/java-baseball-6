package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Logic {
    private final Utils utils = new Utils();
    public int[] calculateResult(int[] userGuess, List<Integer> computer) {
        int[] result = new int[2]; // [strike, ball]

        for (int i = 0; i < 3; i++) {
            if (userGuess[i] == computer.get(i)) {
                result[0]++; // strike
            } else if (computer.contains(userGuess[i])) {
                result[1]++; // ball
            }
        }

        return result;
    }

    public int[] getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }

        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            guess[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        if (utils.hasDuplicate(guess)) {
            throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
        }

        return guess;
    }

    public boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if ("2".equals(restart)) {
            return false;
        }

        if (!"1".equals(restart)) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }

        return true;
    }
}
