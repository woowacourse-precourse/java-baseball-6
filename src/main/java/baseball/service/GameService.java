package baseball.service;

import baseball.domain.NumberBaseball;
import baseball.view.EndView;
import baseball.view.HintView;
import baseball.view.InputView;
import baseball.view.RestartView;

public interface GameService {

    void playOneGame(InputView inputView, HintView hintView, EndView endView, RestartView restartView, NumberBaseball computerBaseball);
}
