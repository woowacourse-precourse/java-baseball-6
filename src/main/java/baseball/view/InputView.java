package baseball.view;

import baseball.util.InputUtil;
import java.util.List;

public class InputView {

    private static final String INPUT_BASEBALL_NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    public static List<Integer> readBaseBallNumbers() {
        System.out.print(INPUT_BASEBALL_NUMBER_REQUEST_MESSAGE); // TODO: Outputview로 분리하는 것 고민중
        return InputUtil.readIntegerList();
    }
}
