package baseball.utils;

public class Converter {
    public static int[] convertToArray(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
