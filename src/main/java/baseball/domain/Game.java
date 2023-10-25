package baseball.domain;

import static baseball.constant.BaseballConstant.GAME_EXIT_MESSAGE;
import static baseball.constant.BaseballConstant.GAME_START_MESSAGE;
import static baseball.constant.BaseballConstant.GRADE_BALL;
import static baseball.constant.BaseballConstant.GRADE_NOT_THING;
import static baseball.constant.BaseballConstant.GRADE_SPACE;
import static baseball.constant.BaseballConstant.GRADE_STRIKE;
import static baseball.constant.BaseballConstant.NUMBER_OF_TARGET;

import baseball.model.Score;

public class Game {
    private final Player player = new Player();
    private final Computer computer = new Computer();

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void initGame() {
        computer.initTargets();
    }

    public void start() {
        do {
            roundStart();
        } while (isPlayerLose());
        System.out.println(GAME_EXIT_MESSAGE);
    }

    private void roundStart() {
        player.predict();
        computer.gradePredictions(player);
        printScore();
    }

    private void printScore() {
        Score score = player.getScore();
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println(GRADE_NOT_THING);
            return;
        }

        String scoreString = "";
        if (score.getBall() != 0) {
            scoreString += score.getBall() + GRADE_BALL;
            if (score.getStrike() == 0) {
                System.out.println(scoreString);
                return;
            }
            scoreString += GRADE_SPACE;
        }
        if (score.getStrike() != 0) {
            scoreString += score.getStrike() + GRADE_STRIKE;
        }
        System.out.println(scoreString);
    }

    private boolean isPlayerLose() {
        return player.getScore().getStrike() != NUMBER_OF_TARGET;
    }
}