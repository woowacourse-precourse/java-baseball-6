package baseball.baseballV2.controller;

import baseball.baseballV2.model.TripleBalls;
import baseball.baseballV2.view.inputview.InputView;
import baseball.baseballV2.view.outputview.OutputView;
import java.util.Map;


public class EnterTripleBallsController extends AbstractController {
    private final OutputView outputView;
    private final InputView<TripleBalls> inputView;

    public EnterTripleBallsController(OutputView outputView,
                                      InputView<TripleBalls> inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        model.put("inputNumberPath", "숫자를 입력해주세요");
        outputView.print(model);
        model.put("userTripleBalls", inputView.input(model));
    }
}
