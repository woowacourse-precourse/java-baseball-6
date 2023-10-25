package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RestartGame {
    static Boolean restartGame(List<Integer> computer) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String restart = Console.readLine();
        if (restart.equals("1")) {
            computer.clear();
            while (computer.size() < 3) {
                int random = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(random)) {
                    computer.add(random);
                }
            }
        } else if (restart.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }
        return true;
    }
}