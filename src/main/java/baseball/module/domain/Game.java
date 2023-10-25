package baseball.module.domain;

import static baseball.global.constant.Game.SIZE;

import java.util.Iterator;

public class Game {
    private int strike;
    private int ball;

    private static Computer computer;

    public Game() {
        this.strike = 0;
        this.ball = 0;
        computer = Computer.generate();
    }

    public void init() {
        strike = 0;
        ball = 0;
    }

    public void play(Iterator<Integer> playerNumbers) {
        Iterator<Integer> computerNumbers = computer.getComputerNumbers();

        for (int i = 0; i < SIZE; i++) {
            int computerNum = computerNumbers.next();
            int playerNum = playerNumbers.next();

            if (computerNum == playerNum) {
                strike++;
            } else if (computer.contains(playerNum)) {
                ball++;
            }
        }
    }

    public int getStrikeCnt() {
        return strike;
    }

    public int getBallCnt() {
        return ball;
    }
}