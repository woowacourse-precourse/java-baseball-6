package baseball;
import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do{
            BaseballController.startGame();
        }while(InputView.inputRestartDecision());
        OutputView.gameOverPrint();
    }
}
