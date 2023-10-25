package baseball;

import java.util.List;

public class BaseballGame {

    private static final String REGAME = "1";

    Output output = new Output();
    Input input = new Input();
    ExceptionChecker exceptionChecker = new ExceptionChecker();
    Baseball baseball = new Baseball();

    List<Integer> computerAnswer;
    String userInput;
    boolean playing = true;

    public void gameStart() {
        computerAnswer = baseball.makeNewAnswer();
        output.startMessage();
        while (playing) {
            output.inputYourNumberMessage();
            userInput = input.inputOnConsole();
            exceptionChecker.checkAnswerInputException(userInput);
            String gameResult = baseball.countBallAndStrike(computerAnswer, userInput);
            output.printResult(gameResult);
            boolean success = baseball.ifSuccess(gameResult);
            if (success) {
                runAfterSuccess();
            }
        }
    }

    private void runAfterSuccess() {
        output.endingMessage();
        output.retryOrQuitMessage();
        userInput = input.inputOnConsole();
        exceptionChecker.checkRegameOrQuitInputException(userInput);
        playing = regameOrQuit(userInput);
    }

    private boolean regameOrQuit(String userInput) {
        if (userInput.equals(REGAME)) {
            computerAnswer = baseball.makeNewAnswer();
            return true;
        }
        output.endingMessage();
        return false;
    }
}
