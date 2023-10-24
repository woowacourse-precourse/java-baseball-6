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

        while (true) {

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

            if (ModelRestartOrEnd.isEnd(ViewInput.restartOrEndInputView())) {
                break;
            }

        }

    }

    /**
     * 예외에 따른 메세지 설정 및 예외 던지기
     *
     * @param str 예외 이유
     */
    public static void errorThrow(String str) {

        String message = switch (str) {
            case "notNum" -> "숫자를 입력해 주세요";
            case "wrongLen" -> "3자리 숫자가 아닙니다.";
            case "duplicate" -> "중복된 숫자가 존재합니다.";
            case "invalidNum" -> "유효한 숫자가 아닙니다.";
            default -> "";
        };

        throw new IllegalArgumentException(message);
    }
}
