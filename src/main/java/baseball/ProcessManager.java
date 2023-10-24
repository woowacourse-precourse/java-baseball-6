package baseball;

import static baseball.utils.message.message.OutputMessage.END;
import static baseball.utils.message.message.OutputMessage.NUMBER_REQUEST;
import static baseball.utils.message.message.OutputMessage.START;
import static baseball.utils.message.message.OutputMessage.SUCCESS;

import baseball.domain.computer.Computer;
import baseball.domain.computer.DefaultBaseballAlgorithm;
import baseball.view.input.Input;
import baseball.view.output.Output;
import java.util.List;

public class ProcessManager {

    private final Input input;
    private final Output output;

    public ProcessManager(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void runBaseballGame() {
        output.printlnMessage(START);
        Computer computer = new Computer(new DefaultBaseballAlgorithm());
        GameContext gameContext = new GameContext();
        while (gameContext.isGameContext()) {
            List<Integer> randomNumber = computer.generateRandomNumber();
            runEachSet(computer, randomNumber);

            output.printlnMessage(END);

            gameContext.updateContext(input.endInput());
        }
    }

    private void runEachSet(Computer computer, List<Integer> randomNumber) {
        while (computer.isEachSetContext()) {
            output.printMessage(NUMBER_REQUEST);
            String baseballInput = input.baseballInput();

            String baseballResult = computer.checkBallAndStrike(randomNumber, baseballInput);
            output.printlnMessage(baseballResult);

            computer.updateEachSetContext(baseballResult);
        }
        output.printlnMessage(SUCCESS);
        computer.clearEachSetContext();
    }
}
