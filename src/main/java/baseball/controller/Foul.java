package baseball.controller;

import java.util.Objects;


public class Foul {
    public static void validateInputHitter(String hitterString) {
        if (hitterString == null || hitterString.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] charArray = hitterString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }

            for (int j = i + 1; j < charArray.length; j++) {
                if (c == charArray[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static void validateInputContine(String start) {
        if (Objects.equals(start, "1") || Objects.equals(start, "2")) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
