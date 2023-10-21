package baseball;

import static baseball.Constants.ALERT_END_CHOICE;
import static baseball.Constants.ALERT_INPUT;
import static baseball.Constants.ALERT_START;

import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    private final Answer answer = new Answer();
    private InputNumbers inputNumbers = new InputNumbers();
    private BallAndStrike ballAndStrike;
    private Result result = Result.DEFAULT;
    private InputChoice inputChoice = new InputChoice();
    private Restart restart = new Restart();

    public void run() {
        while (restart.getRestart()) {
            start();
            game();
            end();
        }
        Console.close();
    }

    private void start() {
        pickAnswerNumbers();
        alertStart();
    }

    private void game() {
        while (true) {
            alertInput();
            readInputNumbers();
            getBallAndStrike();
            getResult();
            writeMention();
            if (isAnswer()) {
                break;
            }
        }
    }

    private void end() {
        alertEndChoice();
        readInputChoice();
        decideEndOrNot();
    }

    private void pickAnswerNumbers() {
        answer.pickAnswerNumbers();
    }

    private void alertStart() {
        System.out.println(ALERT_START);
    }

    private void alertInput() {
        System.out.print(ALERT_INPUT);
    }

    private void readInputNumbers() {
        inputNumbers.readInput();
    }

    private void getBallAndStrike() {
        ballAndStrike = new BallAndStrike();
        ballAndStrike.set(inputNumbers.getInputNumbers(), answer.getAnswer());
    }

    private void getResult() {
        result = result.getResult(ballAndStrike);
    }

    private void writeMention() {
        Mention mention = new Mention(result, ballAndStrike);
        System.out.println(mention.getMention());
    }

    private Boolean isAnswer() {
        return result == Result.ANSWER;
    }

    private void alertEndChoice() {
        System.out.println(ALERT_END_CHOICE);
    }

    private void readInputChoice() {
        inputChoice.readInput();
    }

    private void decideEndOrNot() {
        if (inputChoice.getInputChoice() == 2) {
            restart.stop();
        }
    }
}
