package baseball.baseballV2.controller;

import baseball.baseballV2.view.inputview.InputView;
import baseball.baseballV2.view.outputview.OutputView;
import java.util.Map;

public class GameRestartController extends AbstractController {
    private final OutputView outputView;
    private final InputView<String> inputView;

    public GameRestartController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        outputView.print(model);

        model.put("restartChoice", inputView.input(model));
    }
}
