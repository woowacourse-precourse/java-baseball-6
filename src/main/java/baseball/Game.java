package baseball;

import java.util.List;

public class Game {

    private final int LENGTH = 3;
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private int ball;
    private int strike;
    private boolean flag;

    public void playBaseballGame() {
        ComputerNumber computer = new ComputerNumber();
        System.out.println(computer.getComputerNumbers());
        this.flag = true;
        while (flag) {
            Player player = new Player();
            player.setPlayerNumbers();

            initializeCount();

            checkBallAndStrike(computer.getComputerNumbers(), player.getPlayerNumbers());

            if (this.strike == LENGTH) {
                this.flag = false;
                System.out.println(SUCCESS_MESSAGE);
            }
        }

    }

    private void initializeCount() {
        this.ball = 0;
        this.strike = 0;
    }

    private void checkBallAndStrike(List<Character> computer, List<Character> player) {
        for (int i = 0; i < LENGTH; i++) {
            checkStrike(computer, player, i);
            checkBall(computer, player, i);
        }
    }

    private void checkStrike(List<Character> computer, List<Character> player, int index) {
        if (computer.get(index).equals(player.get(index))) {
            strike++;
        }
    }

    private void checkBall(List<Character> computer, List<Character> player, int index) {
        for (int i = 0; i < LENGTH; i++) {
            if (index != i && computer.get(index).equals(player.get(i))) {
                ball++;
            }
        }
    }


}
