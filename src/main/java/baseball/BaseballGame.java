package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isPlaying = true;
        int answer = Randoms.pickNumberInRange(111, 999);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            Console.readLine();
        } while (isPlaying);
    }
}
