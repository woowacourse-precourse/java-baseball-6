package baseball;

import baseball.io.ConsoleMessage;
import baseball.io.OutPut;
import baseball.model.BallCount;
import baseball.model.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;

public class BaseBallApp {

    private static final int DIGIT = 3;
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    private final OutPut output;

    public BaseBallApp(OutPut output) {
        this.output = output;
    }

    public void run() throws IOException {
        output.gameStart();
        BaseBallGame baseBallGame = new BaseBallGame(DIGIT);

        while(true) {

            output.print(ConsoleMessage.ENTER_NUMBER.getMessage());
            String inputAnswer = Console.readLine();

            if(!InputValidator.isValidatedAnswer(DIGIT, inputAnswer)) {
                throw new IllegalArgumentException(
                        String.format("%d자리 숫자가 아닌 잘못된 입력값 입니다. - %s", DIGIT, inputAnswer));
            }

            BallCount result = baseBallGame.play(inputAnswer);

            output.printResult(result.getStrike(), result.getBall());

            if(baseBallGame.isCorrectedAnswer(DIGIT, result)) {
                output.print(ConsoleMessage.CORRECT_ANSWER.getMessage());
                output.print(ConsoleMessage.RESTART.getMessage());
                String command = Console.readLine();

                switch (command) {
                    case RESTART -> baseBallGame = new BaseBallGame(DIGIT);
                    case EXIT -> {
                        output.close();
                        Console.close();
                        return;
                    }
                    default -> throw new IllegalArgumentException(String.format("잘못된 명령어입니다. - %s", command));
                }
            }
        }
    }
}
