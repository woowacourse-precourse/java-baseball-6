package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameConsole {
    private static final String REGEX_CONTINUE_OR_END = "^[1-2]{1}";

    public static void play(Game game) {
        game.initGame();
        do {
            game.playGame();
        } while (continueOrEnd());
        Console.close();
    }

    private static boolean continueOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputValue = Console.readLine();
        ValidateInput.validate(inputValue, REGEX_CONTINUE_OR_END, "1 또는 2숫자를 입력해주세요.");
        return inputValue.equals("1");
    }
}


