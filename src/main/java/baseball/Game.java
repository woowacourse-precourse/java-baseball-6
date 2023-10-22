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
    boolean gameState = true;

    public void play() {
        CountCheck countCheck = new CountCheck();
        Count count = new Count();
        /**
         * 테스트용 코드
         */
        List<Integer> answer = countCheck.getAnswer();
        System.out.println(answer);

        while(count.getStrikeCount() != 3) {
            List<Integer> input = getInput();
            countCheck.checkCount(input, count);
            OutputView.result(count);
        }
        OutputView.answer();
    }

    public List<Integer> getInput() {
        InputView.input();
        String string = Console.readLine();
        List<Integer> inputNumber = new ArrayList<>();
        for (String str : string.split("")) {
            inputNumber.add(Integer.parseInt(str));
        }
        Validation.validateNumber(inputNumber);
        return inputNumber;
    }

    public boolean isRestart() {
        String string = Console.readLine();
        Validation.validateRestart(string);
        if (string.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}
