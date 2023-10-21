package baseball;

import static baseball.Constants.ALERT_END_CHOICE;
import static baseball.Constants.ALERT_INPUT;
import static baseball.Constants.ALERT_START;

public class Baseball {
    private final Answer answer = new Answer();
    private InputNumbers inputNumbers = new InputNumbers();
    private BallAndStrike ballAndStrike;
    private Result result = Result.DEFAULT;
    private InputChoice inputChoice = new InputChoice();

    public void run() {
        start();
        game();
        end();
    }

    private void start() {
        pickAnswerNumbers();
        alertStart();
    }

    private void game() {
        alertInput();
        readInputNumbers();
        getBallAndStrike();
        getResult();
        writeMention();
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

    private void alertEndChoice() {
        System.out.println(ALERT_END_CHOICE);
    }

    private void readInputChoice() {
        inputChoice.readInput();
    }

    private void decideEndOrNot() {
        if (inputChoice.getInputChoice() == 2) {
            // 게임 다시 시작
        }
    }
}
