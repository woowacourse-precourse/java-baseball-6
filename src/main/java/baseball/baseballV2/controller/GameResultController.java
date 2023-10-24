package baseball.baseballV2.controller;

import baseball.baseballV2.model.TripleBalls;
import baseball.baseballV2.system.util.Util;
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
        TripleBalls tripleBalls = (TripleBalls) model.get(Util.USER_TRIPLE_BALLS_KEY);
        model.put(Util.GAME_RESULT_PATH, tripleBalls.compareTripleBallCondition(computerTripleBalls));

        outputView.print(model);
    }
}
