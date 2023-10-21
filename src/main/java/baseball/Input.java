package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int[] userInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = (input.charAt(i) - '0');
        }
        return numbers;
    }
    public boolean restart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String input = Console.readLine();

        if (input.equals("1")) return true;
        if (input.equals("2")) return false;

        throw new IllegalArgumentException();
    }

    private boolean isValidInput(String input) {
        if (input.length() != 3) return false;

        boolean[] duplicationCheck = new boolean[10];
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9' || duplicationCheck[(c - '0')]) return false;
            duplicationCheck[(c - '0')] = true;
        }

        return true;
    }
}
