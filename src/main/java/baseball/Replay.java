package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Replay {
    public static boolean askReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        while (true) {
            String retry = Console.readLine();
            if (retry.equals("1")) {
                return true;
            } else if (retry.equals("2")) {
                return false;
            } else {
                throw new IllegalArgumentException("숫자 1,2 중에 입력해야 합니다.");
            }
        }
    }
}