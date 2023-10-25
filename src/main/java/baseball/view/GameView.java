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
        if(strike > 0 && ball == 0) {
            System.out.println(strike + UIMessage.STRIKE.getMessage());
            if(strike == 3) {
                System.out.println(UIMessage.END_MESSAGE);
            }
        }

        else if(strike == 0 && ball > 0) {
            System.out.println(ball + UIMessage.BALL.getMessage());
        }

        else if(strike == 0 && ball == 0) {
            System.out.println(UIMessage.NOTHING);
        }

        else {
            System.out.println(ball + UIMessage.BALL.getMessage() + " " + strike + UIMessage.STRIKE.getMessage());
        }
    }
}
