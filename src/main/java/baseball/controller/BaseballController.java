package baseball.controller;

import baseball.model.ComputerModel;
import baseball.model.UserModel;
import baseball.util.UserInputEnum;
import baseball.util.common.Common;
import baseball.util.dto.Baseball;
import baseball.util.exception.TerminateApplicationException;
import baseball.view.UserInputView;
import baseball.view.UserOutputView;

public class BaseballController {

    private final UserInputView userInputView;
    private final UserOutputView userOutputView;
    private final ComputerModel computerModel;
    private final UserModel userModel;


    public BaseballController(UserInputView userInputView, UserOutputView userOutputView,
                              ComputerModel computerModel,
                              UserModel userModel) {
        this.userInputView = userInputView;
        this.userOutputView = userOutputView;
        this.computerModel = computerModel;
        this.userModel = userModel;
    }

    public void startGame() {
        userOutputView.printHelloGame();
        initGame();

        while (true) {
            getUserNumber();
            boolean resultByCompare = compareUserInputByComputerNumber();
            if (resultByCompare) {
                restartGame();
            }
        }

    }

    private void restartGame() {
        userOutputView.restartGame();
        String isContinueByUserInput = userInputView.isContinueGameByUserInput();
        UserInputEnum userInputEnum = UserInputEnum.fromString(isContinueByUserInput);

        if (userInputEnum.equals(UserInputEnum.RESTART)) {
            initGame();
        } else if (userInputEnum.equals(UserInputEnum.EXIT)) {
            throw new TerminateApplicationException("사용자가 프로그램 종료를 요청했습니다.");
        }


    }

    private void initGame() {
        computerModel.initNumber();
    }

    private void getUserNumber() {
        String inputUserNumberString = userInputView.inputUserNumber();
        userModel.initUserInputBySplitDigits(inputUserNumberString);
    }

    private boolean compareUserInputByComputerNumber() {
        Baseball baseballDto = new Baseball();
        int trackIdx = 0;

        for (Integer userDigit : userModel.getSplitDigitsFromUserInput()) {
            if (userDigit.equals(computerModel.getSplitDigitFromRandomNumber(trackIdx))) {
                baseballDto.incrementStrikeCount();
            } else if (computerModel.hasContainNumber(userDigit)) {
                baseballDto.incrementBallCount();
            } else {
                baseballDto.incrementNothingCount();
            }
            trackIdx++;
        }

        return evaluateByResult(baseballDto);
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
