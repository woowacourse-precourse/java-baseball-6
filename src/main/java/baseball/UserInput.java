package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String input = Console.readLine();
            if (input.matches("\\d{3}")) {
                return input;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int input = Integer.parseInt(Console.readLine());
            if (String.valueOf(input).matches("[12]")) {
                return input;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
