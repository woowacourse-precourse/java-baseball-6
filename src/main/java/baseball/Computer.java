package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public void gameStartPhrase() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> generateNumber() {
        List<Integer> computerNums = new ArrayList<>();

        while (computerNums.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNum)) {
                computerNums.add(randomNum);
            }
        }

        return computerNums;
    }

    public void inputNumberPhrase() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void restartOrEndPhrase() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
