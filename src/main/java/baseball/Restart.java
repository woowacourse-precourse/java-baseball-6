package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Restart {
    private final static String FIRST_MENU = "1";
    private final static String SECOND_MENU = "2";

    public static boolean inputRestartMenu() {
        String menu = readLine();
        if (!isValidMenu(menu)) {
            throw new IllegalArgumentException();
        }
        return menu.equals(FIRST_MENU);
    }

    private static boolean isValidMenu(String menu) {
        if (menu.equals(FIRST_MENU)
                || menu.equals(SECOND_MENU)) return true;
        return false;
    }
}
