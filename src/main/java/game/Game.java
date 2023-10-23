package game;

import judge.*;
import player.*;

public class Game {
    User user;
    Computer computer;

    public Game() {
        user = new User();
        computer = new Computer();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.setNumber();

        this.turn(true);
    }

    private void turn(boolean start) {
        while (start) {
            System.out.print("숫자를 입력해주세요 : ");
            user.setNumber();

            Score score = Judge.calculateScore(user, computer);
            score.printScore();

            start = setNextTurn(score);
        }
    }

    //todo: SRP 고려
    private boolean setNextTurn(Score score) {
        if (!score.isCorrect())
            return true;

        if (user.chooseGameEnd())
            return false;

        computer.setNumber();
        return true;
    }

}
