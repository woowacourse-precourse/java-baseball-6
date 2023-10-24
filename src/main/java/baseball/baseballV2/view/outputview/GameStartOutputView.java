package baseball.baseballV2.view.outputview;

import java.util.Map;

public class GameStartOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        String message = (String) model.get("gameStart");
        System.out.println(message);
    }
}
