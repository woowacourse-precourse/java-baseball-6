package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String restart = "1";

        while (restart.equals("1")) {
            int ball = 0;
            int str = 0;
            List<Integer> com = new ArrayList<>();

            while (com.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!com.contains(randomNumber)) {
                    com.add(randomNumber);
                }
            }

            while (!(str == 3)) {
                ball = 0;
                str = 0;
                List<Integer> user = new ArrayList<>();

                System.out.print("숫자를 입력해주세요: ");
                String s = Console.readLine();

                if (s.length() > 3) {
                    throw new IllegalArgumentException();
                }

                for (int x = 0; x < s.length(); x++) {
                    int i1 = Integer.parseInt(String.valueOf(s.charAt(x)));
                    if (i1 < 1 || i1 > 9) {
                        throw new IllegalArgumentException();
                    }
                    user.add((int) s.charAt(x) - 48);
                }

                for (int i = 0; i < 3; i++) {
                    if (Objects.equals(user.get(i), com.get(i))) {
                        str++;
                    }
                    if (!Objects.equals(user.get(i), com.get(i)) && user.contains(com.get(i))) {
                        ball++;
                    }
                }

                if (str == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (str > 0 && ball == 0) {
                    System.out.println(str + "스트라이크");
                } else if (str == 0 && ball > 0) {
                    System.out.println(ball + "볼");
                } else if (str > 0 && ball > 0) {
                    System.out.println(ball + "볼 " + str + "스트라이크");
                }

                if (str == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            }

            restart = Console.readLine();
            if (Objects.equals(restart, "1")) {

            } else if (Objects.equals(restart, "2")) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
