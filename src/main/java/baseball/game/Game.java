package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // computer 초기화
        List<Integer> computer = initializeComputer();

        // 숫자 야구 게임
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
    }

    private List<Integer> initializeComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
