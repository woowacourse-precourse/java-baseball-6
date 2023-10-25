package baseball.domain.game;

import baseball.domain.input.ConsoleReader;
import baseball.exception.BaseBallGameException;

public class BaseBallGameExitManager {

    private BaseBallGameExitManager() {
    }

    public static BaseBallGameExitManager newInstance() {
        return new BaseBallGameExitManager();
    }

    public boolean isExitingBaseballGame() {
        final String userRetryInput = ConsoleReader.input();
        validUserRetryInput(userRetryInput);
        return isUserInputExitOption(userRetryInput);
    }

    public void printInputExitOption() {
        final String EXIT_OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(EXIT_OPTION_MESSAGE);
    }

    public boolean isUserInputExitOption(final String userRetryInput) {
        final String EXIT_OPTION = "2";
        return userRetryInput.equals(EXIT_OPTION);
    }

    public void validUserRetryInput(final String userRetryInput) {
        final String RETRY_OR_EXIT_COMMAND = "[12]";
        if (!userRetryInput.matches(RETRY_OR_EXIT_COMMAND)) {
            BaseBallGameException.RETRY_OR_EXIT_INPUT_FAILURE_EXCEPTION.getException();
        }
    }

}
