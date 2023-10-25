package baseball.resolver;

import baseball.domain.Referee;
import baseball.domain.convert.BaseballConverter;
import baseball.view.view;

public class BaseballViewResolver {

    view view = new view();
    BaseballConverter converter = new BaseballConverter();

    public void startView() {
        view.startView();
    }

    public void endGame() {
        view.endView();
    }

    public int[] contactViewAndPlayControl() {
        return converter.convertNumberToArray(view.initView());
    }

    public int contactViewAndResultController(Referee referee) {
        view.resultTextView(referee);
        if (referee.judgment()) {
            return view.restartView();
        }
        return 0;
    }
}