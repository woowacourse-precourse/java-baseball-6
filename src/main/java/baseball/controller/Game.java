package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.Input;
import baseball.view.Output;

public class Game {
    private final String RESTART_STRING = "1";
    private final int SUCCESS = 3;
    private Computer computer;
    private Player player;

    public Game() {
    }

    /**
     * 게임 시작
     */
    public void run() {
        startGame();
        boolean again;
        do {
            doGame();
            again = checkNewGame();
        } while (again);
        endGame();
    }

    //유저 및
    private void doGame() {
        this.computer = new Computer();
        this.player = new Player();
        boolean isSuccess;
        computer.generateRandomNums();
        do {
            initNums();
            isSuccess = battle();
        } while (!isSuccess);
    }

    private boolean battle() {
        int strike;
        int ball;
        strike = checkStrike();
        ball = checkContainNums() - strike;
        StringBuilder sb = new StringBuilder();
        if (ball != 0)
            sb.append(ball).append("볼");
        if (strike != 0) {
            if (ball != 0)
                sb.append(" ");
            sb.append(strike).append("스트라이크");
        }
        if (strike == 0 && ball == 0)
            sb.append("낫싱");
        Output.battleResult(sb.toString());
        return strike == SUCCESS;
    }

    private int checkContainNums() {
        int ContainNums = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.getNums().contains(player.getNums().get(i)))
                ContainNums++;
        }
        return ContainNums;
    }

    private int checkStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.getNums().get(i).equals(player.getNums().get(i)))
                strike++;
        }
        return strike;
    }

    private void initNums() {
        Output.initNums();
        player.initNums(Input.InputNumbers());
    }

    /**
     * 게임 시작 출력
     */
    private void startGame() {
        Output.startGame();
    }

    private void endGame() {
        Output.endGame();
    }

    private boolean checkNewGame() {
        Output.checkNewGame();
        String init = Input.InputAgainNumbers();
        checkEndGame(init);
        return init.equals(RESTART_STRING);
    }

    private void checkEndGame(String init) {
        Validator.checkEndGame(init);
    }
}
