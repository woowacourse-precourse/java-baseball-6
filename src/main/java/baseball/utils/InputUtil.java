package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

import static baseball.utils.Message.*;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requireGuessNumber() {
        System.out.println(REQUIRE_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

}
