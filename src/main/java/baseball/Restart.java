package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Restart {
    public static boolean inputRestartMenu() {
        String menu = readLine();
        if (!isValidMenu(menu)) {
            throw new IllegalArgumentException();
        }
        if (menu.equals("1")) return true;
        return false;
    }

    public static boolean isValidMenu(String menu) {
        if (menu.equals("1") || menu.equals("2")) return true;
        return false;
    }
}
