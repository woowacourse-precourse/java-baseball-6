package baseball.view;

import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String getPlayerInput() {
        System.out.print(UIMessage.INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        InputValidator.validatePlayNumber(input);
        return input;
    }

    public int gameContinue() {
        System.out.println(UIMessage.RESTART_OR_END.getMessage());
        String input = Console.readLine();
        InputValidator.validateGameContinue(input);
        return Integer.parseInt(input);
    }

    public void showIntro() {
        System.out.println(UIMessage.GAME_INTRO.getMessage());
    }

    public void showResult(int strike, int ball) {
        String resultMessage = getResultMessage(strike, ball);
        System.out.println(resultMessage);
    }

    private String getResultMessage(int strike, int ball) {
        StringBuilder resultMessage = new StringBuilder();

        if (ball > 0) {
            resultMessage.append(ball).append(UIMessage.BALL.getMessage());
        }
        if (strike > 0) {
            if (resultMessage.length() > 0) {
                resultMessage.append(" ");
            }
            resultMessage.append(strike).append(UIMessage.STRIKE.getMessage());
        }
        if (resultMessage.length() == 0) {
            resultMessage.append(UIMessage.NOTHING.getMessage());
        } else if (strike == 3) {
            resultMessage.append("\n").append(UIMessage.END_MESSAGE.getMessage());
        }

        return resultMessage.toString();
    }
}
