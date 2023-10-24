package baseball.baseballV2.controller;

import baseball.baseballV2.view.outputview.OutputView;
import java.util.Map;

public class GameStartController extends AbstractController {

    public final OutputView outputView;

    public GameStartController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        outputView.print(model);
    }
}
