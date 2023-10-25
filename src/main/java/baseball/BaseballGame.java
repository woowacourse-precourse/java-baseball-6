package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int ball;
    private int strike;

    public BaseballGame() {
        this.ball = 0;
        this.strike = 0;
    }

    public void play() {
        printStart();
        List<Integer> computerNumbers = getComputerNumber();
        List<Integer> playerNumbers = new ArrayList<>();
        while(strike != 3) {
            playerNumbers = getPlayerNumbers();
        }
    }

    private List<Integer> getPlayerNumbers() {
        Player player = new Player();
        List<Integer> playerNumbers = player.getNumbers();
    }

    private List<Integer> getComputerNumber() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.selectNumbers();
        return computerNumbers;
    }

    private void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}

