package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        int status = 1;
        while (status == 1) {

            String computer = makeRandomNums();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status = Integer.parseInt(Console.readLine());
        }
    }

    private static String makeRandomNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return "" + computer.get(0) + computer.get(1) + computer.get(2);
    }
}
