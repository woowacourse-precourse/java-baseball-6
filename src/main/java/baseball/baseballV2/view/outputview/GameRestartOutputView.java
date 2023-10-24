package baseball.baseballV2.view.outputview;

import java.util.Map;

public class GameRestartOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        String message = (String) model.get("gameEnd");
        System.out.print(message);
    }
}
