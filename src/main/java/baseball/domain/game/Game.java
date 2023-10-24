package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.input.Input;
import baseball.domain.output.Output;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private final Input input;
    private final Computer computer;
    private final Output output;

    private static Integer STRIKE;
    private static Integer BALL;

    private static Integer BALL_COUNT;
    private static Integer STRIKE_COUNT;


    public void startGame() {
        STRIKE = 0;
        BALL = 0;
        List<String> computerNumber = computer.makeRandomNumbers();
        baseBallGame(computerNumber);
    }

    public void baseBallGame(List<String> computerNumber) {
        while (STRIKE != 3) {
            output.printGetNumberMessage(); // "숫자를 입력해주세요 :"
            String guessNumber = input.getExpectationNumber();
            input.checkInputNumbers(guessNumber);
            setBallsAndStrikes(computerNumber, guessNumber);
            output.printTotalMessage(BALL, STRIKE);
        }
        output.printAllStrikeMessage(STRIKE);
        checkRestartGame();
    }

    public void setBallsAndStrikes(List<String> computerNumbers, String guessNumber) {
        BALL_COUNT = 0;
        STRIKE_COUNT = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            countBallAndStrike(computerNumbers, computerNumbers.get(i), String.valueOf(guessNumber.charAt(i)));
        }
        BALL = BALL_COUNT - STRIKE_COUNT;
        STRIKE = STRIKE_COUNT;
    }

    public void countBallAndStrike(List<String> computerNumbers, String computerNumber, String guessNumber) {
        if (isGuessNumberContainsAnswer(computerNumbers, guessNumber)) {
            BALL_COUNT += 1;
            checkNumberEquals(computerNumber, guessNumber);
        }
    }

    public void checkNumberEquals(String computerNumber, String guessNumber) {
        if (computerNumber.equals(guessNumber)) {
            STRIKE_COUNT += 1;
        }
    }

    public Boolean isGuessNumberContainsAnswer(List<String> computerNumbers, String guessNumber) {
        return computerNumbers.contains(guessNumber);
    }

    public void checkRestartGame() {
        output.printRestartOrNotMessage();

        String opinion = input.getRestartOrNot();
        Console.close();

        switch (opinion) {
            case "1":
                startGame();
                break;
            case "2":
                return;
            default:
                output.printNumberIsNoneMessage();
        }
    }

    public Game(Input input, Computer computer, Output output) {
        this.input = input;
        this.computer = computer;
        this.output = output;
    }
}
