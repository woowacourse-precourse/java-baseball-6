package baseball.service;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.service.hint.HintService;
import baseball.view.EndView;
import baseball.view.HintView;
import baseball.view.InputView;
import baseball.view.RestartView;

public interface GameService {

    void playOneGame(InputView inputView, HintView hintView,
                     EndView endView, RestartView restartView,
                     HintService hintService,
                     NumberBaseball computerBaseball);
}
