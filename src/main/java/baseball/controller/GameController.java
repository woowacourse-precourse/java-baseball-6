package baseball.controller;

import baseball.model.Computer;
import baseball.view.GameView;

import java.util.List;

public class GameController {
    private final Computer computer;
    private final GameView gameView;
    private int strike;
    private int ball;

    public GameController() {
        computer = new Computer();
        gameView = new GameView();
    }

    public void startGame() {
        gameView.showIntro();
        int start = 1;
        while(start != 2) {
            computer.setNumber();
            while(true) {
                String playInput = gameView.getPlayerInput();
                strike = 0;
                ball = 0;

                judge(computer.getNumber(), playInput);
                gameView.showResult(strike, ball);

                if(strike == 3) {
                    start = gameView.gameContinue();
                    break;
                }
            }
        }
    }

    private void judge(List<Integer> number, String playInput) {
        for (int i = 0; i < playInput.length(); i++) {
            int inputDigit = Character.getNumericValue(playInput.charAt(i));
            if(isStrike(number, inputDigit, i)) strike++;
            else if(isBall(number, inputDigit)) ball++;
        }
    }

    private boolean isStrike(List<Integer> number, int input, int index) {
        return number.get(index) == input;
    }

    private boolean isBall(List<Integer> number, int input) {
        return number.contains(input);
    }
}
