package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final Player player;
    private int ball;
    private int strike;
    private String restart;
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;


    public BaseballGame() {
        this.player = new Player();
        this.ball = 0;
        this.strike = 0;
        this.restart = "";
        this.computerNumbers = new ArrayList<>();
        this.playerNumbers = new ArrayList<>();
    }

    public void start() {
        printStart();
        do {
            play();
        } while(restart.equals("1"));
    }

    private void play() {
        initBallCounts();
        computerNumbers = getComputerNumber();
        while(strike != 3) {
            initBallCounts();
            playerNumbers = getPlayerNumbers();
            compareNumbers();
            printResult();
        }
        printEnd();
        restart = askRestart();
    }

    private void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
                this.strike++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                this.ball++;
            }
        }
    }

    private List<Integer> getPlayerNumbers() {
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

