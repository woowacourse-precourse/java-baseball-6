package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Replay {
    public boolean replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        char answer = Console.readLine().charAt(0);

        return answer == '1';
    }
}
