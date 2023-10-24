package baseball.model;

public class PlayerInputManager {

    private String input;

    private static final String MESSAGE_CHECK_NUMBER_SIZE = "3개의 숫자를 입력해주세요.";
    private static final String MESSAGE_CHECK_NUMBER_RANGE = "1~9 사이의 숫자를 입력해주세요.";
    private static final String MESSAGE_CHECK_NUMBER_DUPLICATION = "중복되지 않은 숫자를 입력해주세요.";

    private static final String MESSAGE_CHECK_NUMBER_ONE_OR_TWO = "1 또는 2를 입력해주세요.";

    public PlayerInputManager(String input, GameStatus gameStatus) {
        this.input = input;
        if(gameStatus == GameStatus.PLAYING){
            CheckNumberSize(input);
            CheckNumberRange(input);
            CheckNumberDuplication(input);
        }
        if (gameStatus == GameStatus.RESTART) {
            CheckNumberOneOrTwo(input);
        }

    }

    public void CheckNumberOneOrTwo(String input){
        if (input.length() != 1 || (input.charAt(0) != '1' && input.charAt(0) != '2')) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMBER_ONE_OR_TWO);
        }
    }

    public static void CheckNumberSize(String input){
        if (input.length() != 3) {
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMBER_SIZE);
        }
    }

    public static void CheckNumberRange(String input){
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException(MESSAGE_CHECK_NUMBER_RANGE);
            }
        }
    }

    public static void CheckNumberDuplication(String input){
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == input.charAt((i+1)%3) || input.charAt(i) == input.charAt((i+2)%3)) {
                throw new IllegalArgumentException(MESSAGE_CHECK_NUMBER_DUPLICATION);
            }
        }
    }

    public String getPlayerInput() {
        return input;
    }
}
