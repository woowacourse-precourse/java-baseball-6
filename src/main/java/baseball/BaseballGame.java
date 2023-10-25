package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int ball;
    private int strike;
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;

    public BaseballGame() {
        ball = 0;
        strike = 0;
        computerNumbers = new ArrayList<>();
        playerNumbers = new ArrayList<>();
    }

    public void play() {
        printStart();
        computerNumbers = getComputerNumber();
        while(strike != 3) {
            playerNumbers = getPlayerNumbers();
            compareNumbers();
        }
    }



    private void compareNumbers() {
        for(int i = 0; i < 3; i++) {
            if (playerNumbers.get(i) == computerNumbers.get(i)) {
                strike++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
    }

    private List<Integer> getPlayerNumbers() {
        Player player = new Player();
        List<Integer> playerNumbers = player.getNumbers();
        return playerNumbers;
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

