package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean restartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reply = Console.readLine();
        if (reply.equals("1")) {
            return true;
        }
        return false;
    }
}
