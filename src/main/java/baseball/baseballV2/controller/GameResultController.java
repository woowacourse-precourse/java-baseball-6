package baseball.baseballV2.controller;

import baseball.baseballV2.model.TripleBalls;
import baseball.baseballV2.view.outputview.OutputView;
import java.util.Map;

public class GameResultController extends AbstractController {
    private final OutputView outputView;
    private final TripleBalls computerTripleBalls;

    public GameResultController(OutputView outputView, TripleBalls computerTripleBalls) {
        this.outputView = outputView;
        this.computerTripleBalls = computerTripleBalls;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        TripleBalls tripleBalls = (TripleBalls) model.get("userTripleBalls");
        model.put("gameResult", tripleBalls.compareTripleBallCondition(computerTripleBalls));

        outputView.print(model);
    }
}
