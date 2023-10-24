package exception;

public class CommandException {
    public static final String RESTART = "1";
    public static final String EXIT = "2";
    private static final String RANGE_ERROR_MESSAGE = "Error : " + RESTART + "이나 " + EXIT + "를 입력해 주세요.";

    public static void commandException(String command) {
        validateCommandRange(command);
    }

    private static void validateCommandRange(String command) {
        if (!command.equals(RESTART) && !command.equals(EXIT)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

}
