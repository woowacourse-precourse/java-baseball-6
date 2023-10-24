package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static boolean isContinue = true;

    public static void main(String[] args) {
        List<Integer> systemNumber = new ArrayList<>();
        while (systemNumber.size() < 3) {
            Integer number = Randoms.pickNumberInRange(0, 9);
            if (!systemNumber.contains(number)) {
                systemNumber.add(number);
            }
        }
        while (isContinue) {
            int ball = 0, strike = 0;

            String userInput = Console.readLine();
            if (userInput.matches("[^1-9]")) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
            }
            List<Integer> userNumber = new ArrayList<>();
            for (String s : userInput.split("")) {
                if (userNumber.contains(Integer.parseInt(s))) {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
                userNumber.add(Integer.parseInt(s));
            }
            if (userNumber.size() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }

            for (int u : userNumber) {
                if (systemNumber.contains(u)) {
                    if (systemNumber.indexOf(u) == userNumber.indexOf(u)) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restartInput = Console.readLine();
                if (restartInput.equals("1")) {
                    isContinue = true;
                    systemNumber.clear();
                    while (systemNumber.size() < 3) {
                        Integer number = Randoms.pickNumberInRange(0, 9);
                        if (!systemNumber.contains(number)) {
                            systemNumber.add(number);
                        }
                    }
                } else {
                    isContinue = false;
                }
            }
        }
    }
}
