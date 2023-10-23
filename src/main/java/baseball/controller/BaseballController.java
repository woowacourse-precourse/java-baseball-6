package baseball.controller;

import baseball.domain.CompareNumbers;
import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static final String GAME_OVER_CONDITION = "3스트라이크";
    public static void startGame(){
        OutputView.gameStartPrint();
        boolean continueGame = true;
        while(continueGame) {
            List<Integer> computer = Computer.createRandomNumbers();
            playGame(computer);

            OutputView.correctInputPrint();
            OutputView.restartAndGameOverPrint();

            continueGame = InputView.inputRestartDecision();
        }
        OutputView.gameOverPrint();
    }
    private static void playGame(List<Integer> computer){
        String result;
        do{
            OutputView.playerInputPrint();
            List<Integer> player = InputView.inputPlayerNumbers();
            CompareNumbers compare = new CompareNumbers(computer, player);
            result = compare.generateResult();
            OutputView.gameResultPrint(result);
        } while(!result.equals(GAME_OVER_CONDITION));
    }
}
