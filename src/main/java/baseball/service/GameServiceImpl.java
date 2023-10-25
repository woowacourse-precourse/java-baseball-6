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
            String inputNum = getInputNumber(inputView);
            NumberBaseball inputBaseball = NumberBaseball.createBaseball(inputNum);

            Hint hint = createHint(hintService, computerBaseball, inputBaseball);
            displayHint(hintView, hintService, hint);

            if (hint.isCorrect()) {
                displayEnd(endView);
                return;
            }
        }
    }

    private String getInputNumber(InputView inputView) {
        inputView.displayInputMessage();
        return InputUtil.inputString();
    }

    private Hint createHint(HintService hintService, NumberBaseball computerBaseball, NumberBaseball inputBaseball) {
        return hintService.createHint(computerBaseball, inputBaseball);
    }

    private void displayHint(HintView hintView, HintService hintService, Hint hint) {
        List<String> countList = hintService.counts(hint);
        List<String> nameList = hintService.names(hint);
        hintView.displayHintMessage(countList, nameList);
    }

    private void displayEnd(EndView endView) {
        endView.displayEndMessage();
    }


}
