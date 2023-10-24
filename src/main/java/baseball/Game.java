package baseball;

import static baseball.Constants.ALERT_INPUT;
import static baseball.Constants.ALERT_START;
import static baseball.Constants.END_CHOICE;

import baseball.end.InputChoice;
import baseball.end.Restart;
import baseball.game.BallAndStrike;
import baseball.game.Mention;
import baseball.game.Result;
import baseball.start.Answer;
import baseball.start.InputNumbers;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Answer answer;
    private InputNumbers inputNumbers;
    private BallAndStrike ballAndStrike;
    private Result result;
    private InputChoice inputChoice;
    private Restart restart;

    public Game() {
        answer = new Answer();
        inputNumbers = new InputNumbers();
        ballAndStrike = new BallAndStrike();
        result = Result.DEFAULT;
        inputChoice = new InputChoice();
        restart = new Restart();
    }

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
        inputNumbers.readInputNumbers();
    }

    private void getBallAndStrike() {
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
        System.out.println(END_CHOICE);
    }

    private void readInputChoice() {
        inputChoice.readInputChoices();
    }

    private void decideEndOrNot() {
        if (inputChoice.getInputChoice() == 2) {
            restart.stop();
        }
    }
}
