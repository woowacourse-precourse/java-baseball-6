package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    static boolean askRestart() {
        // TODO: add inputString validation
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        return inputString.equals("1");
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            // Create random answer
            List<Integer> randomList = new ArrayList<>();
            while (randomList.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!randomList.contains(randomNumber)) {
                    randomList.add(randomNumber);
                }
            }

            // Run game
            Game game = new Game(randomList);
            game.run();

            // Ask and restart or break.
            if (!askRestart())
                break;
        }
    }
}