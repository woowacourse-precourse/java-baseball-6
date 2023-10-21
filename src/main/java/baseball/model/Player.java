package baseball.model;

import baseball.validate.GameValidate;
import baseball.validate.InputValidate;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.LinkedHashSet;
import java.util.Set;

public class Player {
    private final OutputView outputView;
    private final InputView inputView;
    private final InputValidate inputValidate;
    private final GameValidate gameValidate;
    public Player(){
        this.gameValidate = new GameValidate();
        this.inputView = new InputView();
        this.inputValidate = new InputValidate();
        this.outputView = new OutputView();
    }
    public boolean swingBat(Computer computer) {
        Set<Ball> balls = new LinkedHashSet<>();
        outputView.showGameInputMessage();
        String input = inputView.getPlayerGuessNumbers();
        inputValidate.checkNumbers(input);
        for(String number : input.split("")) {
            int givensNumber = Integer.parseInt(number);
            balls.add(new Ball(givensNumber));
        }
        return computer.getHintByPlayer(balls);
    }

    public boolean isRestartGame() {
        String input  = inputView.getPlayerRestart();
        int restartNumber = inputValidate.checkNumber(input);
        gameValidate.checkGameRestartInput(restartNumber);
        return restartNumber == 1;
    }
}
