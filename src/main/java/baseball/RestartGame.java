package baseball;

import camp.nextstep.edu.missionutils.Console;

public class RestartGame {
    public boolean restartGame() {
        char answer;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            answer = Console.readLine().charAt(0);
            if (answer == '1') {
                return true;
            } else if (answer == '2') {
                return false;
            } else {
                System.out.println("유효한 입력이 아닙니다. 다시 입력하세요");
            }
        }
    }
}
