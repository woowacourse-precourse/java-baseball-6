package baseball.model.validator;

public class RestartNumberValidation {

    private static final Integer RESTART_GAME = 1;
    private static final Integer END_GAME = 2;

    public void validateNumber(Integer userNumber) {
        if (!isRestartNumber(userNumber)) {
            throw new IllegalArgumentException("1과 2 숫자만 허용한다");
        }
    }

    private boolean isRestartNumber(Integer userNumber) {
        return RESTART_GAME.equals(userNumber) || END_GAME.equals(userNumber);
    }
}
