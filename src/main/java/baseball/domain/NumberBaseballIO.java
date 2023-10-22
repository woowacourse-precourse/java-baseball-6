package baseball.domain;

import baseball.domain.constants.NumberBaseballConstants;
import baseball.domain.validators.NumberBaseballValidator;
import baseball.utils.StringUtils;

import java.util.List;

public class NumberBaseballIO {
    private final InputOutputHandler inputOutputHandler;
    private final NumberBaseballValidator numberBaseballValidator;

    public NumberBaseballIO(InputOutputHandler inputOutputHandler, NumberBaseballValidator numberBaseballValidator) {
        this.inputOutputHandler = inputOutputHandler;
        this.numberBaseballValidator = numberBaseballValidator;
    }

    public void printStart() {
        inputOutputHandler.printText("숫자를 입력해주세요 : ");
    }

    public List<Integer> inputGuessAnswer(int numberLength) {
        printStart();
        String input = inputOutputHandler.inputUniqueNumbers(numberLength);
        return StringUtils.toIntegerList(input);
    }

    public void printResult(Result result) {
        inputOutputHandler.printlnText(result.toString());
    }

    public void printEndMessage(int numberLimit) {
        inputOutputHandler.printlnText(
                numberLimit + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 "  +
                NumberBaseballConstants.CONTINUE_GAME +
                ", 종료하려면 " +
                NumberBaseballConstants.GAME_OVER +"를 입력하세요.");
    }

    public int inputUserContinueGame() {
        int choice = inputOutputHandler.inputOneNumber();
        numberBaseballValidator.validateContinueGame(choice);
        return choice;
    }

    public int showAndReceiveContinueGame(int numberLimit) {
        printEndMessage(numberLimit);
        return inputUserContinueGame();
    }



}
