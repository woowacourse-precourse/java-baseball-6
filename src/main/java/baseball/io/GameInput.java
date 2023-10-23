package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {
    public static int baseBallNumber() {
        String userInput = Console.readLine();
        return baseBallNumber(userInput);
    }

    static int baseBallNumber(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다!");
        }
    }

    public static int afterGame() {
        String userInput = Console.readLine();
        return afterGame(userInput);
    }

    static int afterGame(String userInput) {
        if (userInput.equals("1") || userInput.equals("2")) {
            return Integer.parseInt(userInput);
        }
        throw new IllegalArgumentException("게임 재시작 및 완전 종료 선택 입력이 될 수 없는 입력입니다!");
    }
}
