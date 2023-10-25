package baseball;

import static baseball.Constants.ALERT_INPUT;
import static baseball.Constants.ALERT_START;
import static baseball.Constants.END_CHOICE;

import baseball.end.Restart;
import baseball.end.RestartChoice;
import baseball.game.BallAndStrike;
import baseball.game.Mention;
import baseball.game.Result;
import baseball.start.ComputerNumbers;
import baseball.start.PlayerNumbers;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private ComputerNumbers computerNumbers;
    private PlayerNumbers playerNumbers;
    private BallAndStrike ballAndStrike;
    private Result result;
    private RestartChoice restartChoice;
    private Restart restart;

    public Game() {
        computerNumbers = new ComputerNumbers();
        playerNumbers = new PlayerNumbers();
        ballAndStrike = new BallAndStrike();
        result = Result.DEFAULT;
        restartChoice = new RestartChoice();
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
        computerNumbers.pickAnswerNumbers();
    }

    private void alertStart() {
        System.out.println(ALERT_START);
    }

    private void alertInput() {
        System.out.print(ALERT_INPUT);
    }

    private void readInputNumbers() {
        playerNumbers.readInputNumbers();
    }

    private void getBallAndStrike() {
        ballAndStrike.set(playerNumbers.getPlayerNumbers(), computerNumbers.getComputerNumbers());
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
        restartChoice.readInputChoices();
    }

    private void decideEndOrNot() {
        if (restartChoice.getRestartChoice() == 2) {
            restart.stop();
        }
    }
}
