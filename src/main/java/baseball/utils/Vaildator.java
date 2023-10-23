package baseball.utils;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.regex.Pattern;

public class Vaildator {
    private static final int NUMBER_LENGTH = 3;

    public static void isVaildRestartInput(String player) {
        if(!Objects.equals(player, "1") && !Objects.equals(player, "2")) {
            throw new IllegalArgumentException();
        }
    }

    public static void isVaildPlayerAnswer(String player) {
        isVaildLength(player);
        isVaildNumber(player);
        isVaildDuplicated(player);
    }

    private static void isVaildLength(String player) {
        if(player.length() !=  NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void isVaildNumber(String numbers) {
        boolean isNumber = Pattern.matches("^[1-9]*$", numbers);
        if(!isNumber) {
            throw new IllegalArgumentException();
        }
    }

    private static void isVaildDuplicated(String numbers) {
        String[] playerNumbers = numbers.split("");
        List<String> player = new ArrayList<>(List.of(playerNumbers));
        if(player.stream().distinct().count() !=  NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
