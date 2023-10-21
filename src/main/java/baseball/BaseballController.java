package baseball;

public class BaseballController {

    private final BaseballView view;
    private final BaseballModel model;

    public BaseballController(BaseballView view, BaseballModel model) {
        this.view = view;
        this.model = model;
    }
}
