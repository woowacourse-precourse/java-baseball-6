package baseball;

import java.util.List;
import model.ModelCompareAnsInput;
import model.ModelCreateRandomNumber;
import model.ModelRestartOrEnd;
import model.ModelUserNumCheck;
import view.ViewInput;
import view.ViewResult;
import view.ViewStart;

/**
 * BaseBallGame.java
 * <p>
 * 야구게임이 수행될 메인 부분
 *
 * @author Lee NaYeon
 * @since 2023-10-24
 */

public class BaseBallGame {

    public void start() {

        ViewStart.view();

        do {

            List<Integer> computer = ModelCreateRandomNumber.createRandomNumber();

            System.out.println(computer);

            while (true) {

                List<Integer> input = ModelUserNumCheck.changeToComparable(ViewInput.numInputView());

                int[] result = ModelCompareAnsInput.compareAnsInput(computer, input);

                ViewResult.view(result);

                if (ModelCompareAnsInput.isAns(result)) {
                    break;
                }
            }

        } while (!ModelRestartOrEnd.isEnd(ViewInput.restartOrEndInputView()));

    }

}
