package baseball.controller;

import baseball.domain.CompareNumbers;
import baseball.domain.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static String result = "";
    public static void startGame(){
        OutputView.gameStartPrint();
        List<Integer> computer = Computer.createRandomNumbers();
        CompareNumbers compare;
        do{
            List<Integer> player = InputView.inputPlayerNumbers();
            compare = new CompareNumbers(computer, player);
            result = compare.generateResult();
            System.out.println(result);
        } while(!result.equals("3스트라이크"));

        OutputView.correctInputPrint();
        OutputView.restartAndGameOverPrint();
    }
}
