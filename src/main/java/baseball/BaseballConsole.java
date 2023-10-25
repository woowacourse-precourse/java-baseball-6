package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballConsole {

    public static void startBaseballShell() {
        while (true) {
            startNewGame();

        }
    }

    private static void startNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame game = new BaseballGame();
        while (true) {
            String answer = getInput("숫자를 입력해주세요 : ", "\\d\\d\\d");
            game.setUserNumbers(answer);

        }
    }

    public static String getInput(String message, String regex) {
        System.out.print(message);
        String userInput = Console.readLine();
        if (!userInput.matches(regex)) {
            throw new IllegalArgumentException(userInput + "은 형식에 맞지 않습니다.");
        }
        return userInput;
    }


}
