package baseball.controller;

public class Validator {
    public static void checkEndGame(String target) {
        if (!target.matches("[1-2]"))
            throw new IllegalArgumentException();
    }

    public static void checkInitNums(String[] s) {
        if (s.length != 3)
            throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            if (!s[i].matches("[1-9]"))
                throw new IllegalArgumentException();
        }
    }
}