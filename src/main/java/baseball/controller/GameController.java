package baseball.controller;

import static baseball.util.Constants.MAX_STRIKES;

import baseball.domain.ComputerNumbers;
import baseball.domain.Referee;
import baseball.util.InputValidation;
import baseball.view.InputView;
import baseball.view.OutPutView;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final ComputerNumbers computer;
    private final Referee referee;

    public GameController(ComputerNumbers computer, Referee referee) {
        this.computer = computer;
        this.referee = referee;
    }

    public void gameStart() {
        while (isGameInProgress()) {
            getPlayerInput();
        }
        printGameSet();
    }

    private boolean isGameInProgress() {
        return referee.getStrike() != MAX_STRIKES;
    }

    private void getPlayerInput() {
        OutPutView.displayInputNumberMessage();
        List<Integer> input = getNumbers();
        referee.reset();
        referee.checkStrikeAndBall(computer.getComputerNums(), input);
        printMessages();
    }

    private List<Integer> getNumbers() {
        List<String> numbers = inputNumbers();
        return stringToInteger(numbers);
    }

    private List<String> inputNumbers() {
        List<String> numbers = InputView.inputNumbers();
        InputValidation.validateInputNumbers(numbers);
        return numbers;
    }

    private List<Integer> stringToInteger(List<String> input) {
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void printGameSet() {
        OutPutView.displayGameSetMessage();
    }

    private void printMessages() {
        int strike = referee.getStrike();
        int ball = referee.getBall();
        OutPutView.displayBall(strike, ball);
        OutPutView.displayStrike(strike);
        OutPutView.displayNothingMatch(strike, ball);
    }
}