package baseball;

import baseball.io.ConsoleMessage;
import baseball.io.OutPut;
import baseball.model.BallCount;
import baseball.model.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;

public class BaseBallApp {

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    private final OutPut output;

    public BaseBallApp(OutPut output) {
        this.output = output;
    }

    public void run() throws IOException {
        output.gameStart();
        BaseBallGame baseBallGame = new BaseBallGame();

        while(true) {

            output.print(ConsoleMessage.ENTER_NUMBER.getMessage());
            String inputAnswer = Console.readLine();

            BallCount result = baseBallGame.play(inputAnswer);

            output.printResult(result.strike(), result.ball());

            if(baseBallGame.isFinished()) {
                output.print(ConsoleMessage.CORRECT_ANSWER.getMessage());
                output.print(ConsoleMessage.RESTART.getMessage());
                String command = Console.readLine();

                switch (command) {
                    case RESTART -> baseBallGame = new BaseBallGame();
                    case EXIT -> {
                        output.close();
                        Console.close();
                        return;
                    }
                    default -> throw new IllegalArgumentException(String.format("잘못된 명령어 입니다. - %s", command));
                }
            }
        }
    }
}
