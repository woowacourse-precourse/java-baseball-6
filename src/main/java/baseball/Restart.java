package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    static String restartMsg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public int restart() {
        System.out.println(restartMsg);
        String raw = Console.readLine();

        try {
            int input = Integer.valueOf(raw);
            if (input == 1 || input == 2) {
                return input;
            } else {
                return 3;
            }
        } catch (Exception e) {
            return 3;
        }
    }
}
