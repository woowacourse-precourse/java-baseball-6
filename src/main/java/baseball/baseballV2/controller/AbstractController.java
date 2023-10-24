package baseball.baseballV2.controller;

import baseball.baseballV2.view.outputview.ErrorMessageOutputView;
import baseball.baseballV2.view.outputview.OutputView;
import java.util.Map;


public abstract class AbstractController implements Controller {
    private final OutputView outputView = new ErrorMessageOutputView();

    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            model.put("errorMessage", e.getMessage());
            outputView.print(model);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    abstract void doProcess(Map<String, Object> model);
}
