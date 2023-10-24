package baseball;

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
        output.printlnMessage("숫자 야구를 시작합니다.");
        Computer computer = new Computer(new DefaultBaseballAlgorithm());
        GameContext gameContext = new GameContext();
        while (gameContext.isGameContext()) {
            List<Integer> randomNumber = computer.generateRandomNumber();
            runEachSet(computer, randomNumber);

            output.printlnMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            gameContext.updateContext(input.endInput());
        }
    }

    private void runEachSet(Computer computer, List<Integer> randomNumber) {
        while (computer.isEachSetContext()) {
            output.printMessage("숫자를 입력해주세요 : ");
            String baseballInput = input.baseballInput();

            String baseballResult = computer.checkBallAndStrike(randomNumber, baseballInput);
            output.printlnMessage(baseballResult);

            computer.updateEachSetContext(baseballResult);
        }
        output.printlnMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        computer.clearEachSetContext();
    }
}
