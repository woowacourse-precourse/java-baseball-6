package extension;


import baseball.numberBaseball.type.PlayType;

public class ValidateExt {
    public static boolean validateUserInput(String userNum) throws IllegalArgumentException {
        return userNum.length() == PlayType.MAX_PLAY_SIZE.getPlayValue()
                && userNum.chars().distinct().count() == PlayType.MAX_PLAY_SIZE.getPlayValue()
                && userNum.matches("[1-9]+");
    }
}