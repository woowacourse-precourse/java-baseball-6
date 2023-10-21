package baseball;

import baseball.core.Referee;
import baseball.util.NumberGenerator;
import baseball.util.Parser;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Collections;
import java.util.List;

public class GameManager {

    private static final String GAME_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_INTRO_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String RETRY_COMMAND = "1";
    private final Referee referee;
    private final InputView inputView;
    private final OutputView outputView;
    private List<Integer> computerNumbers;
    private List<Integer> userInputNumbers;

    public GameManager(Referee referee, InputView inputView, OutputView outputView) {
        this.referee = referee;
        this.inputView = inputView;
        this.outputView = outputView;
        this.computerNumbers = Collections.emptyList();
        this.userInputNumbers = Collections.emptyList();
    }

    public void play() {
        outputView.writeNewlineMessage(GAME_INTRO_MESSAGE);
        do {
            playOneRoundGame();
        } while (isContinue());
    }

    private void playOneRoundGame() {
        this.computerNumbers = NumberGenerator.generateDefaultSizeComputerNumber();

        do {
            outputView.writeInlineMessage(GAME_USER_INPUT_MESSAGE);
            String userInput = inputView.readUserInput();
            this.userInputNumbers = Parser.parseToIntegerList(userInput);
        } while (calculateGameResult());
    }

    private boolean calculateGameResult() {
        String judgeResult = referee.judge(this.computerNumbers, this.userInputNumbers);
        return false;
    }

    private boolean isContinue() {
        outputView.writeNewlineMessage(GAME_RETRY_MESSAGE);

        String userInput = inputView.readUserRetryInput();
        if(userInput.equals(RETRY_COMMAND)) {
            return true;
        }
        return false;
    }
}
