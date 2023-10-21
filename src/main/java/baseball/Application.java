package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        if (inputString.equals("1"))
            return true;
        if (inputString.equals("2"))
            return false;

        throw new IllegalArgumentException("Input must be 1 or 2");
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