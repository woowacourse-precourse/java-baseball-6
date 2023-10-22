package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isPlaying = true;
        int answerPlayer = -1;
        int answerComputer = Randoms.pickNumberInRange(111, 999);
        System.out.print("생성된 숫자는 " + answerComputer + "\n");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            answerPlayer = Integer.parseInt(Console.readLine());
            if (answerPlayer == answerComputer) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isPlaying = false;
            }
        } while (isPlaying);
    }
}
