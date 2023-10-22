package baseball.view;

import baseball.util.GameCommand;

public class InputView {
    private final String GUESS_PROMPT = "숫자를 입력해주세요 : ";
    private final String GAME_OVER_MESSAGE =
            "게임을 새로 시작하려면 " + GameCommand.GAME_RESTART.getCommand() + ", 종료하려면 " + GameCommand.GAME_OVER.getCommand()
                    + "를 입력하세요.";

    public void printGuessPrompt() {
        System.out.print(GUESS_PROMPT);
    }

    public void printGameOverMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }
}
