package baseball.validator;

import baseball.util.GameConstant;

public class NewGameOrEndInputValidation {

    public void validate(String input) {
        isNumeric(input);
        isValueOneOrTwo(input);
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void isValueOneOrTwo(String input) {
        int gameCode = Integer.parseInt(input);
        if (isNotValidGameCode(gameCode)) {
            throw new IllegalArgumentException("1과 2중 입력해야 합니다.");
        }
    }

    private boolean isNotValidGameCode(int gameCode) {
        return gameCode != GameConstant.NEW_GAME_CODE && gameCode != GameConstant.END_GAME_CODE;
    }

}
