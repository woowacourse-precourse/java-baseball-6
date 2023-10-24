package baseball.baseballV2.view.outputview;

import java.util.Map;

public class EnterTripleBallsOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        String enterNumberMessage = (String) model.get("inputNumberPath");
        System.out.printf("%s : ", enterNumberMessage);
    }
}
