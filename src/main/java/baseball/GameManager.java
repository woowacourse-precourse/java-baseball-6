package baseball;

import baseball.util.NumberGenerator;
import baseball.util.Parser;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.writeNewlineMessage("숫자 야구 게임을 시작합니다.");
        do {
            List<Integer> computerNumbers = NumberGenerator.generateDefaultSizeComputerNumber();
            List<Integer> userInputNumbers;

            do {
                outputView.writeInlineMessage("숫자를 입력해주세요 : ");
                String userInput = inputView.readUserInput();
                userInputNumbers = Parser.parseToIntegerList(userInput);
            } while (calculateGameResult(computerNumbers, userInputNumbers));
        } while (isContinue());
    }

    private boolean calculateGameResult(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        // TODO : 게임 결과 계산
        return false;
    }

    private boolean isContinue() {
        outputView.writeNewlineMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = inputView.readUserRetryInput();

        if(userInput.equals("1")) {
            return true;
        }
        return false;
    }
}
