package baseball2;

import java.util.List;

public class BaseballGame {

    private static final String REGAME = "1";

    Output output = new Output();
    Baseball baseball = new Baseball();
    List<Integer> newAnswer = baseball.makeNewAnswer();

    public void gameStart() {
        Input input = new Input();
        boolean playing = true;

        output.startMessage();
        while (playing) {
            output.inputYourNumberMessage();
            String userInput = input.getUserInput();
            String gameResult = baseball.countBallAndStrike(newAnswer, userInput);
            output.printResult(gameResult);
            boolean success = baseball.checkSuccess(gameResult);
            if (success) {
                output.endingMessage();
                output.retryOrQuitMessage();
                userInput = input.getUserInput();
                playing = regameOrQuit(userInput);
            }
        }
    }

    private boolean regameOrQuit(String userInput) {
        if (userInput.equals(REGAME)) {
            newAnswer = baseball.makeNewAnswer();
            return true;
        }
        output.endingMessage();
        return false;
    }
}
