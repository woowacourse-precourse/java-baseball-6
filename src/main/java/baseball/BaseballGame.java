package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private int ball;
    private int strike;
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;
    private final Player player;
    private final Computer computer;

    public BaseballGame() {
        ball = 0;
        strike = 0;
        computerNumbers = new ArrayList<>();
        playerNumbers = new ArrayList<>();
        this.player = new Player();
        this.computer = new Computer();
    }

    public void play() {
        printStart();
        computerNumbers = getComputerNumber();
        while(strike != 3) {
            initBallCounts();
            playerNumbers = getPlayerNumbers();
            compareNumbers();
            printResult();
            askRestart();
        }
    }

    private String askRestart() {
        return player.answerRestart();
    }

    private void initBallCounts() {
        ball = 0;
        strike = 0;
    }

    private void printResult() {
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if(ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if(strike == 0) {
            System.out.println(ball + "볼");
        } else if(ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
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
        List<Integer> playerNumbers = player.getNumbers();
        return playerNumbers;
    }

    private List<Integer> getComputerNumber() {
        List<Integer> computerNumbers = computer.selectNumbers();
        return computerNumbers;
    }

    private void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}

