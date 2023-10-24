package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<Integer> generateNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void main(String[] args) {
        int gameStatus = 1;

        while (gameStatus != 2) {
            List<Integer> computer = generateNumbers();
            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                String userInput = readLine();
                int strike = 0, ball = 0;

                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        if (userInput.charAt(i) - '0' == computer.get(j) && i == j) {
                            strike++;
                        } else if (userInput.charAt(i) - '0' == computer.get(j) && i != j) {
                            ball++;
                        }
                    }
                }
                if (ball != 0) {
                    System.out.printf("%s 볼 ", ball);
                }

                if (strike != 0) {
                    System.out.printf("%s 스트라이크", strike);
                }
                System.out.println();
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String tmp = readLine();
                gameStatus = tmp.charAt(0)-'0';
            }
        }
    }
}
