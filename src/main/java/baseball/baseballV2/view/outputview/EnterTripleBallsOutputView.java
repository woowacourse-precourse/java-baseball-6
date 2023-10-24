package baseball.baseballV2.view.outputview;

import java.util.Map;

public class EnterTripleBallsOutputView implements OutputView {
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";

    @Override
    public void print(Map<String, Object> model) {
        System.out.printf("%s : ", INPUT_NUMBER_MESSAGE);
    }
}
