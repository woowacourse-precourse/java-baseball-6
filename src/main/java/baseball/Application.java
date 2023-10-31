package baseball;

import baseball.View.InputView;
import baseball.View.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean start = true;
        boolean wrong = false;
        // TODO: 프로그램 구현
        OutputView.startMessage();
        while (start) {
            NumberComparison numberComparison = new NumberComparison(RandomNumberGenerator.RandomNumberGenerator());
            do {
                User user = new User(InputView.userInputMessage());
                List<Integer> result = numberComparison.compareList(user.getUserInputList());
                OutputView.showUserInputResult(result);
                wrong = numberComparison.success(result);
            } while (!wrong);
            OutputView.gameOverMessage();
            start = RestartPrompt.stringToBoolean(InputView.askRestartMessage());
        }
    }
}
