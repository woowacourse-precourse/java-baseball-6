package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String str = Console.readLine();

                boolean isException = false;
                isException |= str.length() != 3 ||
                        !str.matches("^[1-9]+$") ||
                        (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2));

                if (isException) {
                    throw new IllegalArgumentException();
                }

                List<Integer> user = new ArrayList<>();
                for (int i = 0; i < str.length(); ++i) {
                    user.add(str.charAt(i) - '0');
                }

                int strike = 0, ball = 0;
                for (int i = 0; i < 3; ++i) {
                    if (computer.get(i) == user.get(i)) ++strike;
                    else if (computer.contains(user.get(i))) ++ball;
                }

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                else if (strike == 0 && ball == 0) System.out.println("낫싱");
                else {
                    if(ball > 0) System.out.print(ball + "볼 ");
                    if(strike > 0) System.out.print(strike + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String flag = Console.readLine();
            if (flag.equals("2")) break;
        }
    }
}
