package game;

import static judge.Judge.calculateScore;

import player.Computer;
import player.User;
import judge.Score;

public class Game {
    User user;
    Computer computer;

    public Game() {
        user = new User();
        computer = new Computer();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.setNumbers();

        this.turn();
    }

    private void turn() {
        boolean start = true;
        while (start) {
            System.out.print("숫자를 입력해주세요 : ");
            user.setNumbers();

            Score score = calculateScore(user, computer);
            score.printScore();

            if (!score.isCorrect()) {
                continue;
            }

            if (user.chooseGameEnd()) {
                start = false;
            } else {
                computer.setNumbers();
            }
        }
    }
}
