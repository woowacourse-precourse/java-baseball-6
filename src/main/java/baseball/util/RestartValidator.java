package baseball.util;

public class RestartValidator {

    private static final String RESTART_COMMAND_ERROR_MESSAGE = "1 또는 2를 입력해주세요.";

    public static void validateRestartNumber(String input){
        if(!(input.equals("1") || input.equals("2"))){
            throw new IllegalArgumentException(RESTART_COMMAND_ERROR_MESSAGE);
        }
    }
}
