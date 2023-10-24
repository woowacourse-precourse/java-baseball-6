package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public static void start() {
        Balls computerBalls = createComputerBalls();

        System.out.println("숫자 야구 게임을 시작합니다.");
        String result;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            List<Integer> integerList = GameUtil.inputParse(input);
            Balls myBalls = new Balls(integerList);
            String statusResult = myBalls.compare(computerBalls);
            System.out.println(statusResult);

            result = checkResult(statusResult);
            if (result.equals("1")) {
                computerBalls = createComputerBalls(); // 새로 시작할 경우 computer의 Balls 변경
            }

        } while (!result.equals("2"));
    }

    public static Balls createComputerBalls() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return new Balls(computer);
    }

    public static String checkResult(String result) {
        if (result.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            return Console.readLine();
        }

        return "0";
    }
}
