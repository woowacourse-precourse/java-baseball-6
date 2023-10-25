package baseball.domain;

import static baseball.constant.BaseballConstant.NUMBER_OF_TARGET;

import baseball.model.Score;

public class Game {
    private final Player player = new Player();
    private final Computer computer = new Computer();

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void initGame() {
        computer.initTargets();
    }

    public void start() {
        do {
            roundStart();
        } while (isPlayerLose());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void roundStart() {
        player.predict();
        computer.gradePredictions(player);
        printScore();
    }

    private void printScore() {
        Score score = player.getScore();
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (score.getBall() != 0) {
            System.out.print(score.getBall() + "볼");
            if (score.getStrike() != 0) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
        if (score.getStrike() != 0) {
            System.out.println(score.getStrike() + "스트라이크");
        }
    }

    private boolean isPlayerLose() {
        return player.getScore().getStrike() != NUMBER_OF_TARGET;
    }
}