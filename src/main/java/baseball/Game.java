package baseball;

import java.util.List;

public class Game {
    public Game() {
    }

    private int strike = 0;
    private int ball = 0;

    public void startGame() {

        Number computer = new Number();
        Number player = new Number();

        resetScore();

        List<Integer> computerNumber = computer.setRandomNumber();
        // log
        System.out.println("컴퓨터: " + computerNumber);

        List<Integer> playerNumber = player.inputNumber();
        // log
        System.out.println("플레이어: " + playerNumber);

        resetScore();
        calculateScore(computerNumber, playerNumber);

    }

    private void calculateScore(List<Integer> computerNumber, List<Integer> playerNumber) {

        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("나싱");
        } else {
            System.out.println("스트라이크: " + strike);
            System.out.println("볼: " + ball);
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }
    
}
