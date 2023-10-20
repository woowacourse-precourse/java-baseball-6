package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> user = new ArrayList<>();

            String input = Console.readLine();
            for (String number : input.split("")) {
                user.add(Integer.parseInt(number));
            }

            if (user.size() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }

            if (user.get(0) < 1 || user.get(0) > 9 || user.get(1) < 1 || user.get(1) > 9 || user.get(2) < 1 || user.get(2) > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
            }

            if (user.get(0).equals(user.get(1)) || user.get(0).equals(user.get(2)) || user.get(1).equals(user.get(2))) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }
    }
}
