package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Manager {

    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int flag;
        try {
            flag = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return flag == 1;
    }
}
