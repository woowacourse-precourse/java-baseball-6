package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Restart {
    public boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int answer = Integer.parseInt(Console.readLine());

        if (answer == 1) {
            return true; // 재시작
        } else if (answer == 2) {
            return false; // 게임 종료
        } else {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

    }
}
