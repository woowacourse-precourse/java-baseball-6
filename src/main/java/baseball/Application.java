package baseball;

import baseball.View.InputView;
import baseball.View.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean START = true;
        boolean WRONG = true;
        // TODO: 프로그램 구현
        OutputView.startMessage();
        while (START) {
            Compare compare = new Compare(RandomNumberGenerater.RandomNumberGenerater());
            do {
                User user = new User(InputView.userInputMessage());
                List<Integer> result = compare.compareList(user.getUserInputList());
                OutputView.showUserInputResult(result);
                WRONG = compare.success(result);
            } while (WRONG);
            OutputView.gameOverMessage();
            START = RestartPrompt.stringToBoolean(InputView.askRestartMessage());
        }
    }
}
