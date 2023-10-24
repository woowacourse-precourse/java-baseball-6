package baseball.view;

public class OutputMessage {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_REALLY_END_MESSAGE = "게임 종료";
    private static final String INPUT_NUMBER_VALIDATION_MESSAGE = "잘못된 값을 입력하셨습니다.";
    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printGameReallyEndMessage() {
        System.out.println(GAME_REALLY_END_MESSAGE);
    }

    public void printInputsValidationMessage() {
        System.out.println(INPUT_NUMBER_VALIDATION_MESSAGE);
    }


}
