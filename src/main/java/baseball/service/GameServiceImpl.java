package baseball.service;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.service.hint.HintService;
import baseball.util.InputUtil;
import baseball.view.*;
import java.util.List;

public class GameServiceImpl implements GameService {

    public GameServiceImpl() {

    }

    @Override
    public void playOneGame(InputView inputView, HintView hintView,
                            EndView endView, RestartView restartView,
                            HintService hintService,
                            NumberBaseball computerBaseball) {
        while (true) {
            inputView.displayInputMessage();

            String inputNum = InputUtil.inputString();
            NumberBaseball inputBaseball = NumberBaseball.createBaseball(inputNum);

            Hint hint = hintService.createHint(computerBaseball, inputBaseball);
            List<String> countList = hintService.counts(hint);
            List<String> nameList = hintService.names(hint);
            hintView.displayHintMessage(countList, nameList);
            if (hint.isCorrect()) {
                endView.displayEndMessage();
                return;
            }
        }
    }


}
