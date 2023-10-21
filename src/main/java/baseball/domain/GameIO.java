package baseball.domain;

import java.util.List;

public class GameIO {
    private final InputOutputHandler inputOutputHandler;

    public GameIO(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void printStart() {
        inputOutputHandler.printText("숫자를 입력해주세요 : ");
    }

    public List<Integer> inputGuessAnswer(int numberLength) {
        return inputOutputHandler.inputUniqueNumbers(numberLength);
    }

    public void printGuessResult(Result result) {
        inputOutputHandler.printlnText(result.toString());
    }

    public void printEndMessage(int numberLimit) {
        inputOutputHandler.printlnText(
                numberLimit + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 "  +
                NumberBaseBall.CONTINUE_GAME +
                ", 종료하려면 " +
                NumberBaseBall.GAME_OVER +"를 입력하세요.");
    }

    public int getUserEndChoice() {
        return inputOutputHandler.inputOneNumber();
    }

    public int printEndMessageAndInputChoice(int numberLimit) {
        printEndMessage(numberLimit);
        return getUserEndChoice();
    }



}
