package util;

import camp.nextstep.edu.missionutils.Console;

public class PlayerGameRestartUtil {
    public static String gameRestartQuestion() {
        String ballNumber = Console.readLine();
        if (ballNumber == "1") { ballNumber = "1️⃣ 입니다?"; }
        if (ballNumber == "2") { ballNumber = "2️⃣ 입니다?"; }
        return ballNumber;
    }
}