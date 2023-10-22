package baseball;

import baseball.ballcount.BallCount;
import baseball.ballcount.BallCountCalculate;
import baseball.game.Game;
import baseball.game.GameProcess;
import baseball.input.InputService;
import baseball.output.PrintService;

public class BaseBallGame implements Game {

    @Override
    public void execute(GameProcess gameProcess) {
        String value = Computer.createValue();
        PrintService.start();
        while (true) {
            PrintService.input();
            String input = InputService.readLine();
            PrintService.inputValue(input);
            Validate.validateInputValue(input);
            int strike  = BallCountCalculate.getStrike(value, input);
            int ball  = BallCountCalculate.getBall(value, input);
            BallCount ballCount = new BallCount(strike, ball);
            PrintService.result(ballCount);
            if(strike == 3) {
                PrintService.end();
                break;
            }
        }
        gameProcess.checkGameContinue(InputService.readLine(), new BaseBallGame(), gameProcess);
        InputService.close();
    }
}
