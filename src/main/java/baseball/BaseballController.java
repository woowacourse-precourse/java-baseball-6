package baseball;

import baseball.util.UserInputEnum;
import baseball.util.common.Common;
import baseball.util.dto.Baseball;
import baseball.util.exception.TerminateApplicationException;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;

public class BaseballController {

    private final UserInputView userInputView;
    private final UserOutputView userOutputView;
    private final BaseballService baseballService;


    public BaseballController(UserInputView userInputView, UserOutputView userOutputView,
                              BaseballService baseballService) {
        this.userInputView = userInputView;
        this.userOutputView = userOutputView;
        this.baseballService = baseballService;
    }

    public void run() {
        userOutputView.printHelloGame();
        initGame();
        startGame();
    }

    private void startGame() {
        while (true) {
            getUserNumber();
            boolean resultByCompare = compareUserInputByComputerNumber();
            if (resultByCompare) {
                restartGame();
            }
        }
    }

    private void restartGame() {
        userOutputView.printRestartGame();
        String isContinueByUserInput = userInputView.isContinueGameByUserInput();
        UserInputEnum userInputEnum = UserInputEnum.fromString(isContinueByUserInput);

        if (userInputEnum.equals(UserInputEnum.RESTART)) {
            initGame();
        } else if (userInputEnum.equals(UserInputEnum.EXIT)) {
            throw new TerminateApplicationException("사용자가 프로그램 종료를 요청했습니다.");
        }


    }

    private void initGame() {
        baseballService.initComputerModel();
    }

    private void getUserNumber() {
        String inputUserNumberString = userInputView.inputUserNumber();
        baseballService.initUserModel(inputUserNumberString);
    }

    private boolean compareUserInputByComputerNumber() {
        Baseball baseball = baseballService.compareUserInputByComputerNumber();
        return evaluateByResult(baseball);
    }

    private boolean evaluateByResult(Baseball baseballDto) {
        if (baseballDto.getStrikeNumber() == Common.NUM_LENGTH) {
            userOutputView.printSuccessAnswer();
            return true;
        } else if (baseballDto.getNothingNumber() == Common.NUM_LENGTH) {
            userOutputView.printTotallyWrong();
        } else if (baseballDto.getStrikeNumber() != 0 || baseballDto.getBallNumber() != 0) {
            userOutputView.printMiddleWrong(baseballDto);
        }
        return false;
    }


}
