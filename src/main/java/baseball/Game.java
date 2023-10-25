package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static void start() {
        System.out.println("숫자 야구 게임을 시작합니다");
        List<Integer> computer = new ArrayList<Integer>();
        while (computer.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(random)) {
                computer.add(random);
            }
        }
        boolean isStart = true;
        while (isStart) {
            boolean isEnd = false;
            while (!isEnd) {
                System.out.println("숫자를 입력해주세요 : ");
                String test = Console.readLine();
                ValidateInput.validateInput(test);
                List<Integer> input = StringToInteger.stringToIntegerList(test);
                if (RunGame.runGame(computer, input)) {
                    isEnd = true;
                }
            }
            if (!RestartGame.restartGame(computer)) {
                isStart = false;
                System.out.println("게임을 종료합니다.");
            } else isStart = true;
        }
    }
}