package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.input.Input;
import baseball.domain.output.Output;
import baseball.domain.util.Judgement;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private final Input input;
    private final Computer computer;
    private final Output output;
    private final Judgement judgement;

    private static Integer STRIKE;
    private static Integer BALL;

    public void startGame() {
        setStrikeAndBallZero();
        List<String> computerNumber = computer.makeRandomNumbers();
        baseBallGame(computerNumber);
    }

    private void baseBallGame(List<String> computerNumber) {
        while (STRIKE != 3) {
            setStrikeAndBallZero();
            output.printGetNumberMessage(); // "숫자를 입력해주세요 :"
            String guessNumber = input.getExpectationNumber();
            input.checkInputNumbers(guessNumber);
            setBallsAndStrikes(computerNumber, guessNumber);
            output.printTotalMessage(BALL, STRIKE);
        }
        output.printAllStrikeMessage();
        checkRestartGame();
    }

    public void setBallsAndStrikes(List<String> computerNumbers, String guessNumber) {

        for (int i = 0; i < computerNumbers.size(); i++) {
            countBallAndStrike(computerNumbers, computerNumbers.get(i), String.valueOf(guessNumber.charAt(i)));
        }
    }

    public void countBallAndStrike(List<String> computerNumbers, String computerNumber, String guessNumber) {
        if (judgement.isGuessNumberContainsAnswer(computerNumbers, guessNumber)) {
            BALL += 1;
            checkNumberEquals(computerNumber, guessNumber);
        }
    }

    public void checkNumberEquals(String computerNumber, String guessNumber) {
        if (computerNumber.equals(guessNumber)) {
            STRIKE += 1;
            BALL -= 1;
        }
    }

    public void checkRestartGame() {
        output.printRestartOrNotMessage();

        String opinion = input.getRestartOrNot();

        switch (opinion) {
            case "1":
                startGame();
                break;
            case "2":
                Console.close();
                return;
            default:
                output.printNumberIsNoneMessage();
        }
    }

    public void setStrikeAndBallZero() {
        BALL = 0;
        STRIKE = 0;
    }

    public Game(Input input, Computer computer, Output output, Judgement judgement) {
        this.input = input;
        this.computer = computer;
        this.output = output;
        this.judgement = judgement;
    }
}
