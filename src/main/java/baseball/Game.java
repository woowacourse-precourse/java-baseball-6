package baseball;

import baseball.domain.Count;
import baseball.utils.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임 동작
 */
public class Game {

    public void play() {
        BallCount ballCount = new BallCount();
        Count count = new Count();
        while (!count.is3Strike()) {
            List<Integer> input = getInput();
            ballCount.checkCount(input, count);
            OutputView.printResult(count);
        }
        OutputView.printAnswer();
    }

    private List<Integer> getInput() {
        InputView.printInput();
        String string = Console.readLine();
        List<Integer> input = stringToList(string);
        Validation.validateInputNumber(input);
        return input;
    }

    private List<Integer> stringToList(String string) {
        List<Integer> input = new ArrayList<>();

        for (String str : string.split("")) {
            input.add(Integer.parseInt(str));
        }
        return input;
    }

    public boolean shouldRestart() {
        InputView.printRestart();
        String string = Console.readLine();
        Validation.validateRestartNumber(string);
        return string.equals("1");
    }
}
