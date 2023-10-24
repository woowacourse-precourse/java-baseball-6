package baseball.domain.game;

public class BaseBallGameExitManager {

    private BaseBallGameExitManager() {
    }

    public static BaseBallGameExitManager newInstance() {
        return new BaseBallGameExitManager();
    }

    public void printInputExitOption() {
        final String EXIT_OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(EXIT_OPTION_MESSAGE);
    }

    public boolean isExitingBaseballGame(final String userRetryInput) {
        validUserRetryInput(userRetryInput);
        return false;
    }

    public boolean isUserInputRetryOption(final String userRetryInput) {
        final String RETRY_OPTION = "1";
        return userRetryInput.equals(RETRY_OPTION);
    }

    public boolean isUserInputExitOption(final String userRetryInput) {
        final String EXIT_OPTION = "2";
        return userRetryInput.equals(EXIT_OPTION);
    }

    public void validUserRetryInput(final String userRetryInput) {
        final String REGEX = "[12]";
        if (!userRetryInput.matches(REGEX)) throw new IllegalArgumentException();
    }

}
