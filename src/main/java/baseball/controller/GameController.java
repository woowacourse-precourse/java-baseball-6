package baseball.controller;

import baseball.commom.constants.GameCommand;
import baseball.domain.BaseballNumber;
import baseball.dto.GameResultDto;
import baseball.service.BaseballService;
import baseball.view.Input;
import baseball.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final Input input;
    private final Output output;
    private final BaseballService baseballService;

    public GameController() {
        this.input = new Input();
        this.output = new Output();
        this.baseballService = new BaseballService();
    }

    public void decideAnswer() {
        baseballService.decideAnswer();
    }

    public void greet() {
        output.printGreet();
    }
    public void guess() {
        String guess = input.readGuess();
        List<Integer> numbers = Arrays.stream(guess.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        GameResultDto result = baseballService.judge(new BaseballNumber(numbers));
        output.printResult(result);
    }

    public void end() {
        output.printEnd();
        String command = input.readRestart();
        baseballService.processRestartMode(GameCommand.from(Integer.parseInt(command)));
    }

    public boolean isGameEnd() {
        return baseballService.isGameEnd();
    }
}
